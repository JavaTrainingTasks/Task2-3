package ua.training.model.db;

import ua.training.model.entity.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NoteService implements NoteDAO {
    Connection connection = DBUtil.getConnection();
    @Override
    public void addNote(Note note) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into Note(Name, Surname, Patronymic, NickName, Email, Telephone, Date,Comment) values(?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,note.getName());
            preparedStatement.setString(2,note.getSurname());
            preparedStatement.setString(3,note.getPatronymic());
            preparedStatement.setString(4,note.getNickname());
            preparedStatement.setString(5,note.getEmail());
            preparedStatement.setString(6, note.getMobileTelephone());
            preparedStatement.setString(7, note.getDate());
            preparedStatement.setString(8,note.getComment());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Note note) {

    }

    @Override
    public void remove(Note note) {

    }

    @Override
    public List<Note> getAll() {
        return null;
    }

    @Override
    public Note getById(Long id) {
        return null;
    }
}
