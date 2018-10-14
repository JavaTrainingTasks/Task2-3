package ua.training.model;

import java.util.ArrayList;

public class Notebook {
	ArrayList<Note> notebook = new ArrayList<>();

	public  void addNote (Note note) {
		notebook.add(note);
	}

	public Note getNoteById(int id) {
		return notebook.get(id);
	}
	@Override
	public String toString() {
		String output = "";
		for (Note note: notebook ) {
			output=output + note.toString() + "\n";
		}
		return output;
	}
}
