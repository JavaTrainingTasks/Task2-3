package ua.training.model.db;

import ua.training.model.entity.Note;

import java.sql.*;
import java.util.List;

public class NoteService implements NoteDAO {
    Connection connection = DBUtil.getConnection();

    @Override
    public void addNote(Note note) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into Note(Name, Surname, Patronymic, NickName, Email, Telephone, Date,Comment) values(?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, note.getName());
            preparedStatement.setString(2, note.getSurname());
            preparedStatement.setString(3, note.getPatronymic());
            preparedStatement.setString(4, note.getNickname());
            preparedStatement.setString(5, note.getEmail());
            preparedStatement.setString(6, note.getMobileTelephone());
            preparedStatement.setString(7, note.getDate());
            preparedStatement.setString(8, note.getComment());

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

    @Override
    public Note getByNickName(String nickname) {
        Statement statement = null;
        Note note ;
        String sql = "select * from Note where NickName = "+"\'"+nickname+"\';";

        try {
            note = new Note();
            statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(sql);
            while (resultSet.next()) {
                note.setId(Integer.parseInt(resultSet.getString("NoteId")));
                note.setName(resultSet.getString("Name"));
                note.setSurname(resultSet.getString("Surname"));
                note.setComment(resultSet.getString("Comment"));
                note.setEmail(resultSet.getString("Email"));
                note.setMobileTelephone(resultSet.getString("Telephone"));
                note.setNickname(resultSet.getString("NickName"));
                note.setPatronymic(resultSet.getString("Patronymic"));
                note.setDate(resultSet.getString("Date"));
                return note;
            }

        } catch (SQLException e) {
            System.out.println("Note note found");
            e.printStackTrace();
        }
        return null;
    }
}
