package ru.netology.domain;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Билет с данным Id=" + id + " отсуствует");
    }
}
