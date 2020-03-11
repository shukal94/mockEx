package com.solvd.util;

import com.solvd.util.interfaces.Calculation;
import com.solvd.util.calculation.AddCalculation;

public class Calculator {

    private Calculation addCalculation = new AddCalculation();

    public Calculator() {

    }

    public Number add(Number a, Number b) {
        return addCalculation.calculate(a, b);
    }

}
