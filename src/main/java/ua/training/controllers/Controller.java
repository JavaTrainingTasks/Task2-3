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
 */
public class Controller {
	private View view;
	private Notebook notebook;

	public Controller(View view, Notebook notebook) {
		this.view = view;
		this.notebook = notebook;
	}

	public void run() {
		Scanner sc =new Scanner(System.in);
	cyckle: while(true) {
		Scanner sc1 =new Scanner(System.in);

		notebook.addNote(input(sc));
		view.printMessage(View.ONE_MORE_NOTE_MESSAGE);
		if(sc1.hasNextInt()) {
			int input = sc.nextInt();
			switch (input) {
				case 1:
					continue;
				default: {
					view.printMessage(View.WRONG_INPUT_MESSAGE);
					break cyckle;
				}
			}
		}
		else {
					break cyckle;
				}
		}
		view.printMessage(notebook.toString());
	}

	private Note input(Scanner sc) {
		Note note = new Note();
		String input = "";

		view.printMessage(View.INITIAL_MESSAGE);
		for (InputDataType type: InputDataType.values()) {
			view.printMessage(View.INPUT_DATA_MESSAGE, type.toString().toLowerCase());

			while (sc.hasNextLine()){
				input = sc.nextLine();

				if( validate(input,type)) {
					note.setFildWithType(input,type);
					break;
				}
				else {
					view.printMessage(View.INVALID_INPUT_MESSAGE, type.toString().toLowerCase());
					continue;
				}
			}


		}
		return note;
	}

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
			case COMMENT:
				return true;
			case NICKNAME:
				pattern = Pattern.compile(RegExp.NICKNAME);
				matcher = pattern.matcher(input);
				break;
		}
		return matcher.find();

	}


	void printNote(Note note) {
		view.printMessage(View.NOTE_MESSAGE);
		view.printMessage(note.toString());
	}

}




