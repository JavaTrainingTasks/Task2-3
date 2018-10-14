package ua.training.view;

public class View {
	public static final String INITIAL_MESSAGE = "Let`s make a note!";
	public static final String INVALID_INPUT_MESSAGE = "Invalid input! Please check input for ";
	public static final String INPUT_DATA_MESSAGE = "Please input";
	public static final String NOTE_MESSAGE = "The note is: n";
	public static final String ONE_MORE_NOTE_MESSAGE = "One more note? \n print '1' if yes and anything else if not";
	public static final String WRONG_INPUT_MESSAGE = "Wrong input! Enough for now.";

	public  void printMessage(String ...message) {
		String fullMessage = "";
		for (String el:message) {
			fullMessage = fullMessage.concat(el+ " ");
		}
		System.out.println(fullMessage);
	}
}
