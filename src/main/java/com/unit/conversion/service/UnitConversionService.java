package com.unit.conversion.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.unit.conversion.DAO.UniteConversionDAO;
import com.unit.conversion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class UnitConversionService {
	public static final String INVALID_AMOUNT = "Invalid amount";
	public static final String INVALID_UNIT = "Invalid Unit";
	private ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

	@Autowired
	UniteConversionDAO uniteConversionDAO;



	public List<Code> getUnitType()
	{
		return uniteConversionDAO.getMeasureList();
	}

	public ConversionResponse validata(ConversionRequest conversionRequest) throws ScriptException {

			List<MetricConversion> conversionList = uniteConversionDAO.getConversionList();
			List<ValidationError> errorList = validateInput(conversionRequest,conversionList);
			Optional<MetricConversion> opt = conversionList.stream()
					.filter(c -> c.getConversionFrom().equalsIgnoreCase(conversionRequest.getConversionFrom()) &&
							c.getConversionTo().equalsIgnoreCase(conversionRequest.getConversionTo())
					)
					.findFirst();

			if(!CollectionUtils.isEmpty(errorList))
			{
				return new ConversionResponse("invalid",errorList);
			}

			String calcoutput = opt.get().getFormula().replaceAll("value",
					conversionRequest.getInputValue());
			Object output = engine.eval(calcoutput);
			BigDecimal calvalue= new BigDecimal(output.toString()).setScale(2, RoundingMode.CEILING);
			BigDecimal givenValue= new BigDecimal(conversionRequest.getStudentResponse()).setScale(2, RoundingMode.CEILING);
			return calvalue.compareTo(givenValue) == 0
					? new ConversionResponse( "correct", Collections.EMPTY_LIST)
					: new ConversionResponse ("incorrect",Collections.EMPTY_LIST);


	}



	private List<ValidationError> validateInput(ConversionRequest conversionRequest, List<MetricConversion> conversionList){

		List<ValidationError> validationErrorList = new ArrayList<>();
		if(!isNumeric(conversionRequest.getInputValue())) {
			ValidationError validationError = new ValidationError(Field.inputValue,INVALID_AMOUNT);
			validationErrorList.add(validationError);
		}
		if(!isNumeric(conversionRequest.getStudentResponse())) {
			ValidationError validationError = new ValidationError(Field.studntResponse,INVALID_AMOUNT);
			validationErrorList.add(validationError);
		}


		Optional<MetricConversion> opt = conversionList.stream()
				.filter(c -> c.getConversionFrom().equalsIgnoreCase(conversionRequest.getConversionFrom())
				)
				.findFirst();
		if (!opt.isPresent())
		{
			ValidationError validationError = new ValidationError(Field.conversionFrom,INVALID_UNIT);
			validationErrorList.add(validationError);
		}
		opt = conversionList.stream()
				.filter(c -> c.getConversionTo().equalsIgnoreCase(conversionRequest.getConversionTo())
				)
				.findFirst();
		if (!opt.isPresent())
		{
			ValidationError validationError = new ValidationError(Field.conversionTo,INVALID_UNIT);
			validationErrorList.add(validationError);
		}

		return validationErrorList;

	}

	private  boolean isNumeric(String strNum) {
		if (StringUtils.isEmpty(strNum)) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
