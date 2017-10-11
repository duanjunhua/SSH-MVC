package com.djh.demo.aop.aspect;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImp implements ArithmeticCalculator {

	@Override
	public int add(int numberA, int numberB) {
		int result = numberA + numberB;
		return result;
	}

	@Override
	public int sub(int numberA, int numberB) {
		int result = numberA - numberB;
		return result;
	}

	@Override
	public int multiple(int numberA, int numberB) {
		int result = numberA * numberB;
		return result;
	}

	@Override
	public int div(int numberA, int numberB) {
		int result = numberA / numberB;
		return result;
	}

}
