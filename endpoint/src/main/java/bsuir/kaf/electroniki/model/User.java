package bsuir.kaf.electroniki.model;

import java.io.Serializable;

public class User implements Serializable, Entity {

    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean isNew() {
        return Entity.super.isNew();
    }
}
