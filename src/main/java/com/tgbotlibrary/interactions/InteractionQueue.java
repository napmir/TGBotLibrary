package com.tgbotlibrary.interactions;


public interface InteractionQueue {
	/**
	 * Method to add a new {@link Command} to the queue tail.
	 * 
	 * @param command
	 *            Is the command object being stored at the end of queue.
	 * */
	public void add(Interaction interaction);

	/**
	 * Method to retrieve and remove the {@link Command} object from the queue's
	 * head.
	 * 
	 * @return The {@link Command} object removed or null if empty.
	 * */
	public Interaction poll();

	/**
	 * Method to check the size of queue based on the elements stored.
	 * 
	 * @return Returns the number of elements in the queue.
	 * */
	public int size();

	/**
	 * Method to check whether the queue has elements or not.
	 * 
	 * @return Returns <b>true</b> if this queue contains no element or
	 *         <b>false</b> otherwise.
	 * */
	public boolean isEmpty();

	/**
	 * Method to check if any {@link Command} instance is enqueued or not.
	 * 
	 * @return Returns <b>true</b> if the given Command is inside the queue or
	 *         <b>false</b> otherwise.
	 * */
	public boolean contains(Interaction command);
}
