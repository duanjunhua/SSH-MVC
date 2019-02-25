package com.cons;

import com.cons.service.Function;
import com.cons.service.FunctionService;

public class Consumer {

	public static void main(String[] args) {
		Function function = new FunctionService().getFunctionPort();
		System.out.println(function.transWords("Hello World!"));
	}
}
