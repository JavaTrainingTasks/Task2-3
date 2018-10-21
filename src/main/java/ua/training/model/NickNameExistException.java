package ua.training.model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import ua.training.model.entity.Note;

public class NickNameExistException extends MySQLIntegrityConstraintViolationException {
    private Note note;
    public NickNameExistException() {
        super();
    }
    NickNameExistException(String message, Note note) {
        super(message);
        this.note=note;
    }

    public Note getNote() {
        return note;
    }
}
