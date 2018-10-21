package ua.training.controllers;

import ua.training.model.NickNameExistException;
import ua.training.model.db.DBUtil;
import ua.training.model.db.NoteService;
import ua.training.model.entity.Notebook;
import ua.training.view.View;

import java.util.Scanner;

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
		DBUtil.getConnection();
		addNotes(sc);
	}

	 void addNotes(Scanner sc) {
		NoteInput noteInput = new NoteInput(sc, view);
		 NoteService ns = new NoteService();
		cyckle: while (true) {

		 	try {
		 		ns.addNote(noteInput.createNote(ns));
		 	}
		 	catch (NickNameExistException e) {
		 		view.printMessage(View.NICK_NAME_EXIST_MASSAGE);
		 		e.printStackTrace();
		 		continue cyckle;
			}
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




}




