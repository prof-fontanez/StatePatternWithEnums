package controller;

import model.Context;

/**
 * The <code>State</code> interface shall be use to implement different types of
 * state transition classes. For example, a Sequential State implementation will
 * facilitate transitions in an incremental manner, starting with the first
 * state. Enforcement of these rules shall be done by the {@link Context} being
 * passed to the methods this interface provides. Therefore, the definition of 
 * what 'next' and 'previous' means can change as defined by this context object.
 * 
 * @author Hector Fontanez
 * @version 2.1
 * @since 1.0
 *
 */
public interface State
{
	/**
	 * Transitions to the next state from this state.
	 * 
	 * @param context
	 *            The object that defines what 'next' means
	 * @since 1.0
	 */
	public abstract void next(Context context);


	/**
	 * Transitions to the previous state from this state.
	 * 
	 * @param context
	 *            The object that defines what 'previous' means
	 * @since 1.0
	 */

	public abstract void previous(Context context);

	default boolean hasNext() {
		return true;
	}

	default boolean hasPrevious() {
		return true;
	}

	default String getName() {
		return this.getClass().getSimpleName();
	}
}
