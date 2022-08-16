package com.calculator.service;

import com.calculator.exception.MyException;

public interface ICalculatorService {
    double operator(double number1, double number2, String operator) throws MyException;
}
