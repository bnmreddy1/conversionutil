package com.unit.conversion.DAO;

import com.unit.conversion.model.Code;
import com.unit.conversion.model.MetricConversion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class UniteConversionDAO {

    public  List<MetricConversion> conversionList;


    public  List<Code> measureList;

    @PostConstruct
    public void loadConversionList()
    {
        conversionList = new ArrayList<>();
        measureList = new ArrayList<>();
        conversionList.add(new MetricConversion("celsius", "celsius", "value * 1"));
        conversionList.add(new MetricConversion("fahrenheit", "fahrenheit", "value * 1"));
        conversionList.add(new MetricConversion("kelvin", "kelvin", "value * 1"));
        conversionList.add(new MetricConversion("rankine", "rankine", "value * 1"));

        conversionList.add(new MetricConversion("celsius", "fahrenheit", "(value * 9 / 5) + 32"));
        conversionList.add(new MetricConversion("celsius", "kelvin", "value + 273.15"));
        conversionList.add(new MetricConversion("celsius", "rankine", "(value * 9 / 5) + 491.67"));
        conversionList.add(new MetricConversion("fahrenheit", "celsius", "(value - 32) * 5 / 9"));
        conversionList.add(new MetricConversion("fahrenheit", "kelvin", "(value - 32) * 5 / 9 + 273.15"));
        conversionList.add(new MetricConversion("fahrenheit", "rankine", "(value - 32) + 491.67"));

        conversionList.add(new MetricConversion("kelvin", "celsius", "value - 273.15"));
        conversionList.add(new MetricConversion("kelvin", "fahrenheit", "(value - 273.15) * 9 / 5 + 32"));
        conversionList.add(new MetricConversion("kelvin", "rankine", "(value - 273.15) * 9 / 5 + 491.67"));

        conversionList.add(new MetricConversion("rankine", "celsius", "(value - 491.67) * 5 / 9"));
        conversionList.add(new MetricConversion("rankine", "fahrenheit", "(value - 491.67) + 32"));
        conversionList.add(new MetricConversion("rankine", "kelvin", "(value - 491.67) * 5 / 9 + 273.15"));

        measureList.add(new Code("rankine","Rankine"));
        measureList.add(new Code("kelvin","Kelvin"));

        measureList.add(new Code("celsius","Celsius"));
        measureList.add(new Code("fahrenheit","Fahrenheit"));

    }



    public List<MetricConversion> getConversionList() {

        return conversionList;
    }

    public List<Code> getMeasureList() {

        return measureList;
    }



}

