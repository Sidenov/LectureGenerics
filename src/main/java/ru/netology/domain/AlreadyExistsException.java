package ru.netology.domain;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super("Билет с таким Id=" + id + " уже существует");
    }
}
