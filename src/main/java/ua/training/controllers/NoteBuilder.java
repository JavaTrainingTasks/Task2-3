package ua.training.controllers;

import ua.training.model.Note;


public class NoteBuilder {
    private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String comment;
    private String mobileTelephone;
    private String email;

    public NoteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public NoteBuilder setSurname(String surname) {
        this.surname = surname;
        return this;

    }

    public NoteBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public NoteBuilder setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public NoteBuilder setMobileTelephone(String mobileTelephone) {
        this.mobileTelephone = mobileTelephone;
        return this;

    }

    public NoteBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public NoteBuilder setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    Note buildNote() {
        return new Note(name, surname, patronymic, nickname, comment, mobileTelephone, email);
    }
}
