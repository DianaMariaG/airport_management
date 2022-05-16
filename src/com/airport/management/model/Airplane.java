package com.airport.management.model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private static int GENERATED_ID;
    private int id;
    private AirplaneType type;
    private int numberOfSeats;
    private String destination;
    private List<Ticket> tickets;

    public Airplane(AirplaneType type, int numberOfSeats, String destination) {
        this.id = GENERATED_ID++;
        this.type = type;
        this.numberOfSeats = numberOfSeats;
        this.destination = destination;
        this.tickets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(List<Ticket> tickets) {
        if (this.numberOfSeats >= tickets.size()) {
            this.tickets.addAll(tickets);
            this.numberOfSeats = this.numberOfSeats - tickets.size();
        } else {
            throw new IllegalArgumentException("Nu mai sunt locuri in avion");
        }
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", type=" + type +
                ", numberOfSeats=" + numberOfSeats +
                ", destination='" + destination + '\'' +
                '}';
    }
}
