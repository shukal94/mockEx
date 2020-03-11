package com.solvd.util.calculation;

import com.solvd.util.interfaces.Calculation;


public class AddCalculation implements Calculation {
    public Number calculate(Number a, Number b) {
        return a.doubleValue() + b.doubleValue();
    }
}
