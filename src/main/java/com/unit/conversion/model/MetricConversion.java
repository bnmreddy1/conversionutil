package com.unit.conversion.model;

public class MetricConversion {
	private String conversionFrom;
	private String conversionTo;
	private String formula;

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

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public MetricConversion(String conversionFrom, String conversionTo, String formula) {
		super();
		this.conversionFrom = conversionFrom;
		this.conversionTo = conversionTo;
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "MetricConversion [conversionFrom=" + conversionFrom + ", conversionTo=" + conversionTo + ", formula="
				+ formula + "]";
	}

}
