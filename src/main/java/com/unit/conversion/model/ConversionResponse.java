package com.unit.conversion.model;

import java.util.List;

public class ConversionResponse {
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String result;

	public List<ValidationError> getValidationErrorList() {
		return validationErrorList;
	}

	public void setValidationErrorList(List<ValidationError> validationErrorList) {
		this.validationErrorList = validationErrorList;
	}

	private List<ValidationError> validationErrorList;

	public ConversionResponse(String result,List<ValidationError> validationErrorList) {
		this.validationErrorList = validationErrorList;
		this.result = result;
	}

}
