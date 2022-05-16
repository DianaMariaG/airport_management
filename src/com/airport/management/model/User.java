package com.airport.management.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.airport.management.model.TicketStatus.CANCELED;

public class User {
    private String name;
    private List<Ticket> tickets;

    public User(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buyTickets(List<Ticket> ticketList) {
        tickets.addAll(ticketList);
    }

    public void addTicket(Ticket newTicket) {
        tickets.add(newTicket);
    }

    public void cancelTicket(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                ticket.setStatus(CANCELED);
            }
        }
    }

    public void updateOwner(User newOwner, Ticket ticketToUpdate) {
        for (Ticket ticket: tickets) {
            if (ticket.getId() == ticketToUpdate.getId()) { //caut in lista de tichete dupa id acel tichet la care vreau sa ii schimb owner-ul,
                ticketToUpdate.setCustomerName(newOwner.getName()); //pun pe tichet un nou nume la customer
                newOwner.addTicket(ticketToUpdate); //adaug tichetul in lista de tichete a noului owner
            }
        }
        tickets.removeIf(ticket -> ticket.getId()== ticketToUpdate.getId()); //sterg din lista de tichete a owner-ului vechi +
        // se face remove doar daca cele 2 id-uri sunt egale
    }

}
