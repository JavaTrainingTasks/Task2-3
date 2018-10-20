package ua.training.controllers;

import ua.training.model.InputDataType;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller check inputs, put, and get data from model, return data to view
 * Created 15.10.18
 *
 * @author or Yaroslav Kratt
 */
public class Controller {
	private View view;
	private Notebook notebook;

	/**
	 * @param view     this will print all of messages in programm
	 * @param notebook here will be kept all of the notes
	 */
	public Controller(View view, Notebook notebook) {
		this.view = view;
		this.notebook = notebook;
	}

	/**
	 * executes te program
	 */
	public void run() {
		Scanner sc = new Scanner(System.in);
		addNotes(sc);
	}

	 void addNotes(Scanner sc) {
		NoteInput noteInput = new NoteInput(sc, view);

		cyckle: while (true) {
			noteInput.inputNote();
			Scanner sc1 = new Scanner(System.in);
			view.printMessage(View.ONE_MORE_NOTE_MESSAGE);
			if (sc1.hasNextInt()) {
				int input = sc1.nextInt();
				switch (input) {
					case 1:
						continue;
					}
				}
			 else {
				break cyckle;
			}
		}
		 view.printMessage(notebook.toString());

	 }

	/**
	 * @param sc scanner for getting input data from console
	 * @return new note with validated data
	 * @see #validate(String, InputDataType)
	 */
	private Note input(Scanner sc) {

	}

	/**
	 * @param input input for validating with regular expressions
	 * @param type  types of input data  from {@linkplain ua.training.model.InputDataType}
	 * @return true if data is valid, adn false - if not
	 */

}




