package model;

import java.util.Observable;

import controller.State;

public final class Context extends Observable
{
	private State currentState;

	public Context(State state)
	{
		currentState = state;
	}
	
	public void setState(State currentState) {
		this.currentState = currentState;
		setChanged();
		notifyObservers();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void goNext()
	{
		currentState.next(this);
	}

	public void goPrevious()
	{
		currentState.previous(this);
	}
}
