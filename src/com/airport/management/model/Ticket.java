package com.airport.management.model;

public class Ticket {
    private static int GENERATED_ID = 1;
    private int id;
    private TicketStatus status;
    private String customerName;
    private Airplane airplane;

    public Ticket(TicketStatus status, String customerName, Airplane airplane) {
        this.id = GENERATED_ID++;
        this.status = status;
        this.customerName = customerName;
        this.airplane = airplane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", status=" + status +
                ", customerName='" + customerName + '\'' +
                ", airplane=" + airplane +
                '}';
    }
}
