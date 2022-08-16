package com.calculator.service.impl;

import com.calculator.exception.MyException;
import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double operator(double number1, double number2, String operator) throws MyException {
        double result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {

                    result = number1 / number2;
                } else {
                    throw new MyException("can not division by/zero");
                }
                break;
        }
        return result;
    }
}
