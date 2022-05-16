package com.airport.management.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.airport.management.model.TicketStatus.ACTIVE;
import static com.airport.management.model.TicketStatus.CANCELED;

public class Airport {
    private int id;
    private String name;
    private List<Airplane> airplanes;

    public Airport(int id, String name) {
        this.id = id;
        this.name = name;
        this.airplanes = new ArrayList<>();
    }

    public void addAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
    }
    //user-ul cumpara tichete, dar aeroportul trb sa stie TOATE tichetele
    public void buyTickets(String destination, User user, int numberOfTickets) { //presupun ca stiu cate tichete vrea userul sa cumpere
        for (Airplane airplane : airplanes) {
            if (airplane.getDestination().equals(destination)) {
                //sunt tichete temporare, care se creeaza in sesiunea respectiva
                List<Ticket> tickets = new ArrayList<>(); //presupun ca inca nu e niciun tichet cumparat de user pt destinatia respectiva
                for (int i = 0; i < numberOfTickets; i++) {
                    Ticket newTicket = new Ticket(ACTIVE, user.getName(), airplane); //se creeaza un nou tichet cu avionul curent
                    tickets.add(newTicket); //adaug tichetul in lista temp
                }
                //acum devin tichete permanente
                user.buyTickets(tickets); //adaug tichetele la user
                airplane.addTickets(tickets); //adaug tichetele la avion
            }
        }
    }

    /**
     * We are cancelling all tickets for destination in this method
     */
//    public void cancelTicket(String destination, User user) {
//        for (Airplane airplane : airplanes) {
//            if (airplane.getDestination().equals(destination)) {
//                List<Ticket> tickets = airplane.getTickets();
//                for (Ticket ticket: tickets) {
//                    user.cancelTicket(ticket.getId());
//                    ticket.setStatus(CANCELED);
//                }
//            }
//        }
//    }
    //sterg un singur tichet al unui user
    public void cancelTicket(User user, Ticket ticket) {
        for (Airplane airplane : airplanes) {
            List<Ticket> tickets = airplane.getTickets(); //stochez toate tichetele unui avion intr-o lista temp
            for (Ticket t : tickets) { //trec prin fiecare tichet al acelui avion
                if (t.getId() == ticket.getId()) {
                    user.cancelTicket(ticket.getId()); //fac update la tichet-ul user-ului
                    ticket.setStatus(CANCELED); //airplane-ul stie ca acum tichetul e canceled ca status
                }
            }
        }
    }

    public List<Ticket> filterTickets(String destination, String customerName, TicketStatus status) {
        List<Ticket> result = new ArrayList<>();
        for (Airplane airplane: airplanes) {
            if (airplane.getDestination().equals(destination)) { //destination e de pe clasa Airplane (ar fi trb 2 lambda)
                result.addAll(airplane.getTickets());
            }
        }
        return result.stream() //customerName si status e de pe clasa Ticket
                .filter(ticket -> ticket.getCustomerName().equals(customerName))
                .filter(ticket -> ticket.getStatus() == status)
                .collect(Collectors.toList());
    }
}
