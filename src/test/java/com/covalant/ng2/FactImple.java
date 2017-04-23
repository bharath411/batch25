package com.covalant.ng2;

import org.testng.annotations.Factory;

public class FactImple {

	@Factory
	public Object[] invoke(){
		Object[] obj = new Object[100];
		for (int i = 0; i < 100; i++) {
			LoginEx ex = new LoginEx();
			obj[i] = ex;
		}
		
		return obj;
	}
}
