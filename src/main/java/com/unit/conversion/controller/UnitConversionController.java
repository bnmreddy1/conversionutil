package com.unit.conversion.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.unit.conversion.model.Code;
import com.unit.conversion.model.ConversionResponse;
import com.unit.conversion.model.MetricConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unit.conversion.model.ConversionRequest;
import com.unit.conversion.service.UnitConversionService;

@RestController
public class UnitConversionController {
	@Autowired
	UnitConversionService unitConversionService;
	Logger logger = LoggerFactory.getLogger(UnitConversionController.class);

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "api/validate/conversion", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity validateConversion(@RequestBody ConversionRequest conversionRequest, HttpServletResponse httpResponse,
			HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers) {
		try {
				logger.info("Request received :"+conversionRequest);
				ConversionResponse result=unitConversionService.validata(conversionRequest);
				ResponseEntity responseEntity = new ResponseEntity(result, HttpStatus.OK);
				return responseEntity;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "api/conversionUnits", method = RequestMethod.GET)

	@ResponseBody
	public ResponseEntity getUnitType(@RequestHeader HttpHeaders headers) {
		try {

			List<Code> result = unitConversionService.getUnitType();
			if(result.size()>0)
				return new ResponseEntity(result, HttpStatus.OK);
			else
				return new ResponseEntity("Invalid Type", HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}



}
