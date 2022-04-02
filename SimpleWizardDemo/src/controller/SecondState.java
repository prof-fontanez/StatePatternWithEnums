/*
 * Name: Hector
 * CSC2340 - Object-Oriented Programming (Java)
 * Prof. Fontanez
 * Assignment: [i.e. Homework #1, Problem 2.3]
 * Date/Time: Apr 2, 2022: 10:16:19 AM
 */
package controller;

import model.Context;

public enum SecondState implements State {
	INSTANCE;

	@Override
	public void next(Context context) {
		context.setState(ThirdState.INSTANCE);
	}

	@Override
	public void previous(Context context) {
		context.setState(FirstState.INSTANCE);
	}
}
