package ua.training.model;

import java.util.ArrayList;

/**
 * Consist of  objects of {@linkplain ua.training.model.Note}.
 * You can add, delete and print notes
 * Created 15.10.18
 * @author or Yaroslav Kratt

 */
public class Notebook {

	ArrayList<Note> notebook = new ArrayList<>();

	public  void addNote (Note note) {
		notebook.add(note);
	}

	public Note getNoteById(int id) {
		return notebook.get(id);
	}

	//refact
	public Note getNoteByNameAndSurname(String name, String surname) {
		for (Note note:notebook) {
			if(note.getName().equals(name) && note.getSurname().equals(surname)) {
				return note;
			}
		}
		return null;
	}

	/**
	 *
	 * @return string with all notes in notebook
	 */
	@Override
	public String toString() {
		String output = "";
		for (Note note: notebook ) {
			output=output + note.toString() + "\n";
		}
		return output;
	}
}
