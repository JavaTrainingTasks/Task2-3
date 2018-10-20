package ua.training.controllers;

import ua.training.model.InputDataType;
import ua.training.model.Note;
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

        builder.setName(inputNote(InputDataType.NAME))
                .setSurname(inputNote(InputDataType.SURNAME))
                .setPatronymic(inputNote(InputDataType.PATRONYMIC))
                .setNickname(inputNote(InputDataType.NICKNAME))
                .setMobileTelephone(inputNote(InputDataType.TELEPHONE))
                .setEmail(inputNote(InputDataType.EMAIL))
                .setComment(inputNote(InputDataType.COMMENT));
        note = builder.buildNote();
        return  note;

    }



   private String inputNote(InputDataType type) {
        String input = "";
        view.printMessage(View.INPUT_DATA_MESSAGE,type.toString());
            while (sc.hasNextLine()) {
                input = sc.nextLine();

                if (validate(input, type)) {
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
     * @param type  types of input data  from {@linkplain ua.training.model.InputDataType}
     * @return true if data is valid, adn false - if not
     */

    private boolean validate(String input, InputDataType type) {
        Pattern pattern = null;
        Matcher matcher = null;

        switch (type) {
            case NAME:
                pattern = Pattern.compile(RegExp.NAME);
                matcher = pattern.matcher(input);
                break;
            case SURNAME:
                pattern = Pattern.compile(RegExp.NAME);
                matcher = pattern.matcher(input);
                break;
            case PATRONYMIC:
                pattern = Pattern.compile(RegExp.NAME);
                matcher = pattern.matcher(input);
                break;
            case TELEPHONE:
                pattern = Pattern.compile(RegExp.TELEPHONE);
                matcher = pattern.matcher(input);
                break;
            case EMAIL:
                pattern = Pattern.compile(RegExp.EMAIL);
                matcher = pattern.matcher(input);
                break;

            case NICKNAME:
                pattern = Pattern.compile(RegExp.NICKNAME);
                matcher = pattern.matcher(input);
                break;
            default:
                return true;
        }

        return matcher.find();

    }

}
