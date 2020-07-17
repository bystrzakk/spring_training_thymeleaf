package com.app.controller.model;

public class DocumentDto {

    private String name;
    private String surname;

    public DocumentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DocumentDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
