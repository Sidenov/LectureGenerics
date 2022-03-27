package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class AirTicketTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    AirTicket first = new AirTicket(1, 4000, "Домодедово", "Пулково");
    AirTicket second = new AirTicket(2, 2000, "Липецк", "Домодедово");
    AirTicket third = new AirTicket(3, 3000, "Пулково", "Нальчик");
    AirTicket fourth = new AirTicket(4, 1000,"Липецк", "Пулково");
    AirTicket fifth = new AirTicket(5, 6000, "Пулково", "Емельяново");
    AirTicket sixth = new AirTicket(6, 700, "Домодедово", "Пулково");
    AirTicket seventh = new AirTicket(7, 1500, "Внуково", "Иркутск");
    AirTicket eighth = new AirTicket(8, 2500, "Пулково", "Абакан");
    AirTicket ninth = new AirTicket(9, 3100, "Толмачево", "Домодедово");
    AirTicket tenth = new AirTicket(10, 2000, "Сочи", "Геленджик");

    @Test
    void addAirTicket() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        AirTicket[] expected = {fourth, second, third, first, fifth};
        AirTicket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addAirTicketIfIdAlreadyExists() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertThrows(AlreadyExistsException.class, () -> {
            repository.save(first);
        });
    }

    @Test
    void removeByIdAirTicket() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        repository.removeById(3);

        AirTicket[] expected = {fourth, second, first, fifth};
        AirTicket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdIfIdNotFound() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(20);
        });
    }

    @Test
    void findAllManager() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);


        AirTicket[] expected = {seventh};
        AirTicket[] actual = manager.findAll("Внуково", "Иркутск");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllIfAirTicketIsOut() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);


        AirTicket[] expected = new AirTicket[0];
        AirTicket[] actual = manager.findAll("Домодедово", "Иркутск");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllIfTwoSameAirTicket() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);


        AirTicket[] expected = {sixth, first};
        AirTicket[] actual = manager.findAll("Домодедово", "Пулково");

        assertArrayEquals(expected, actual);
    }
}