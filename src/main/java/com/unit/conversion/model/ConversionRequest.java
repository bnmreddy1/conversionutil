package com.unit.conversion.model;

import java.math.BigDecimal;

public class ConversionRequest {
	private String inputValue;
	private String conversionFrom;
	private String conversionTo;
	private String studentResponse;
	public String getInputValue() {
		return inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	public String getConversionFrom() {
		return conversionFrom;
	}
	public void setConversionFrom(String conversionFrom) {
		this.conversionFrom = conversionFrom;
	}
	public String getConversionTo() {
		return conversionTo;
	}
	public void setConversionTo(String conversionTo) {
		this.conversionTo = conversionTo;
	}
	public String getStudentResponse() {
		return studentResponse;
	}
	public void setStudentResponse(String studentResponse) {
		this.studentResponse = studentResponse;
	}
	

}
