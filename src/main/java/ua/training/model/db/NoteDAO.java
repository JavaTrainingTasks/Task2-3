package ua.training.model.db;

import ua.training.model.entity.Note;

import java.util.List;

public interface NoteDAO {
    void addNote(Note note);
    void deleteById(Long id);
    void update(Note note);
    void remove (Note note);
    List<Note> getAll();
    Note getById(Long id);


    Note getByNickName(String nickname);
}
