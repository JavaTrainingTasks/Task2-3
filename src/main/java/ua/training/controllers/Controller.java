package ua.training.controllers;

import ua.training.model.InputDataType;
import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

import java.util.Date;
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
		cyckle:
		while (true) {
			Scanner sc1 = new Scanner(System.in);

			notebook.addNote(input(sc));
			view.printMessage(View.ONE_MORE_NOTE_MESSAGE);
			if (sc1.hasNextInt()) {
				int input = sc1.nextInt();
				switch (input) {
					case 1:
						continue;
					default: {
						break cyckle;
					}
				}
			} else {
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
		Note note = new Note();
		String input = "";

		view.printMessage(View.INITIAL_MESSAGE);
		for (InputDataType type : InputDataType.values()) {
			if (type == InputDataType.DATE) {
				continue;
			}
			view.printMessage(View.INPUT_DATA_MESSAGE, type.toString().toLowerCase());

			while (sc.hasNextLine()) {
				input = sc.nextLine();

				if (validate(input, type)) {
					note.setFildWithType(input, type);
					break;
				} else {
					view.printMessage(View.INVALID_INPUT_MESSAGE, type.toString().toLowerCase());
					continue;
				}
			}


		}
		return note;
	}

	/**
	 * @param input input for validating with regular expressions
	 * @param type  types of input data  from {@linkplain ua.training.model.InputDataType}
	 * @return true if data is valid, adn false - if not
	 */
	private boolean validate(String input, InputDataType type) {
		Pattern pattern = null;
		Matcher matcher = null;

		switch (type) {
			case NAME:
				pattern = Pattern.compile(RegExp.NAME);
				matcher = pattern.matcher(input);
				break;
			case SURNAME:
				pattern = Pattern.compile(RegExp.NAME);
				matcher = pattern.matcher(input);
				break;
			case PATRONYMIC:
				pattern = Pattern.compile(RegExp.NAME);
				matcher = pattern.matcher(input);
				break;
			case TELEPHONE:
				pattern = Pattern.compile(RegExp.TELEPHONE);
				matcher = pattern.matcher(input);
				break;
			case EMAIL:
				pattern = Pattern.compile(RegExp.EMAIL);
				matcher = pattern.matcher(input);
				break;

			case NICKNAME:
				pattern = Pattern.compile(RegExp.NICKNAME);
				matcher = pattern.matcher(input);
				break;
			default:
				return true;
		}

		return matcher.find();

	}
}




