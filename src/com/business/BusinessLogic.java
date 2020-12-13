package com.business;

import com.exception.InvalidNumberException;

public interface BusinessLogic {
	
	public void prompt();
	
	public int choices(int n) throws InvalidNumberException;
}
