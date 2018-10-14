package ua.training.controllers;

import ua.training.model.Note;
import ua.training.model.Notebook;
import ua.training.view.View;

import java.util.Scanner;

/**
 * Controller check inputs, put, and get data from model, return data to view
 *
 */
public class Controller {
	private Note note;
	private View view;
	private Notebook notebook;
	public Controller(Note note, View view, Notebook notebook) {
		this.note = note;
		this.view = view;
		this.notebook = notebook;
	}

	public void run() {
	}

	boolean validate(Scanner sc) {
		return false;
	}
	String printOut() {
		return "";
	}
}
