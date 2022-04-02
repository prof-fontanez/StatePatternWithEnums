/*
 * Name: Hector
 * CSC2340 - Object-Oriented Programming (Java)
 * Prof. Fontanez
 * Assignment: [i.e. Homework #1, Problem 2.3]
 * Date/Time: Apr 2, 2022: 10:13:57 AM
 */
package controller;

import model.Context;

public enum FirstState implements State {
	INSTANCE;
	
	@Override
	public void next(Context context) {
		context.setState(SecondState.INSTANCE);
	}

	@Override
	public void previous(Context context) {
		System.out.println("There is no previous state");
	}
	
	@Override
	public boolean hasPrevious() {
		return false;
	}
}
