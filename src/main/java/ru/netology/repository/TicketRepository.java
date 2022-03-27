package ru.netology.repository;

import ru.netology.domain.AirTicket;
import ru.netology.domain.AlreadyExistsException;
import ru.netology.domain.NotFoundException;

import java.util.Arrays;

public class TicketRepository {
    private AirTicket[] ticket = new AirTicket[0];

    public void save(AirTicket newTicket) {
        if (findById(newTicket.getId()) == newTicket) {
            throw new AlreadyExistsException(newTicket.getId());
        }
        int length = ticket.length + 1;
        AirTicket[] tmp = new AirTicket[length];
        System.arraycopy(ticket, 0, tmp, 0 , ticket.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newTicket;
        ticket = tmp;
        Arrays.sort(ticket);
    }

    public AirTicket[] findAll() {return ticket;}

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        int length = ticket.length - 1;
        AirTicket[] tmp = new AirTicket[length];
        int index = 0;
        for (AirTicket tick : ticket) {
            if (tick.getId() != id) {
                tmp[index] = tick;
                index++;
            }
        }
        ticket = tmp;
    }

    public AirTicket findById(int id) {
        for (AirTicket tick : ticket) {
            if (tick.getId() == id) {
                return tick;
            }
        }
        return null;
    }
}
