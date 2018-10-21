package ua.training.controllers;

import ua.training.model.DataType;
import ua.training.model.NickNameExistException;
import ua.training.model.db.NoteService;
import ua.training.model.entity.Note;
import ua.training.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteInput {
    private Scanner sc;
    private View view;
    private Note note;

    NoteInput(Scanner sc, View view) {
        view.printMessage(View.INITIAL_MESSAGE);
        this.sc = sc;
        this.view = view;
    }

    public Note createNote(NoteService noteService) throws NickNameExistException {
        NoteBuilder builder = new NoteBuilder();
        String nickname ="";

        builder.setName(inputNote(DataType.NAME, RegExp.NAME))
                .setSurname(inputNote(DataType.SURNAME, RegExp.NAME))
                .setPatronymic(inputNote(DataType.PATRONYMIC, RegExp.NAME))
                .setMobileTelephone(inputNote(DataType.TELEPHONE, RegExp.TELEPHONE))
                .setEmail(inputNote(DataType.EMAIL, RegExp.EMAIL))
                .setComment(inputNote(DataType.COMMENT,""));
        nickname =  inputNote(DataType.NICKNAME, RegExp.NICKNAME);

        if(noteService.getByNickName(nickname)!= null) {
            throw new NickNameExistException();
        }
        else {
            builder.setNickname(nickname);
        }
        note = builder.buildNote();
        return  note;

    }



   private String inputNote(DataType type, String regexp) {
        String input = "";
        view.printMessage(View.INPUT_DATA_MESSAGE,type.toString());
            while (sc.hasNextLine()) {
                input = sc.nextLine();

                if (validate(input, regexp)) {
                    return input;
                } else {
                    view.printMessage(View.INVALID_INPUT_MESSAGE, type.toString());
                    continue;
                }
            }
            return input;
    }



    /**
     * @param input input for validating with regular expressions
     * @return true if data is valid, adn false - if not
     */
    private boolean validate(String input,  String regexp) {
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();

    }

}
