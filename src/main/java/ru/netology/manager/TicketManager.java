package ru.netology.manager;

import ru.netology.domain.AirTicket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(AirTicket ticket) {
        repository.save(ticket);
    }

    public AirTicket[] findAll(String searchAiportFrom, String searchAiportTo) {
        AirTicket[] result = new AirTicket[0];
        for (AirTicket ticket : repository.findAll()) {
            if (matches(ticket, searchAiportFrom, searchAiportTo)) {
                int length = result.length + 1;
                AirTicket[] tmp = new AirTicket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(AirTicket ticket, String searchAiportFrom, String searchAiportTo) {
        if (ticket.getAiportFrom().contains(searchAiportFrom)
                && ticket.getAiportTo().contains(searchAiportTo)) {
            return true;
        } else {
            return false;
        }
    }
}
