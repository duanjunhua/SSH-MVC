package com.cons;

import com.cons.service.Provider;
import com.cons.service.ProviderService;

public class Consumer {

	public static void main(String[] args) {
		Provider provider = new ProviderService().getProviderPort();
		System.out.println(provider.transWords("Hello World!"));
	}
}
