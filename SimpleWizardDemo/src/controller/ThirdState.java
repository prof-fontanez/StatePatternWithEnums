/*
 * Name: Hector
 * CSC2340 - Object-Oriented Programming (Java)
 * Prof. Fontanez
 * Assignment: [i.e. Homework #1, Problem 2.3]
 * Date/Time: Apr 2, 2022: 10:23:02 AM
 */
package controller;

import model.Context;

public enum ThirdState implements State {
	INSTANCE;

	@Override
	public void next(Context context) {
		System.out.println("There is no next state!");
	}

	@Override
	public void previous(Context context) {
		context.setState(SecondState.INSTANCE);
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}
}
