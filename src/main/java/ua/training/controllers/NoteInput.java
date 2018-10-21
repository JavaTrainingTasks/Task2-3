package ua.training.controllers;

import ua.training.model.InputDataType;
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

    public Note createNote() {
        NoteBuilder builder = new NoteBuilder();

        builder.setName(inputNote(InputDataType.NAME, RegExp.NAME))
                .setSurname(inputNote(InputDataType.SURNAME, RegExp.NAME))
                .setPatronymic(inputNote(InputDataType.PATRONYMIC, RegExp.NAME))
                .setNickname(inputNote(InputDataType.NICKNAME, RegExp.NICKNAME))
                .setMobileTelephone(inputNote(InputDataType.TELEPHONE, RegExp.TELEPHONE))
                .setEmail(inputNote(InputDataType.EMAIL, RegExp.EMAIL))
                .setComment(inputNote(InputDataType.COMMENT,""));
        note = builder.buildNote();
        return  note;

    }



   private String inputNote(InputDataType type, String regexp) {
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
