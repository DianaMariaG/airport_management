package com.airport.management.app;

//import com.airport.management.model.*;
//
//import java.util.List;
//
//import static com.airport.management.model.TicketStatus.*;
//
//public class AirportApp {
//    public static void main(String[] args) {
//        AirportApp app = new AirportApp();
//        Airport airport = app.generateAirportInstance();
//
//        User user1 = new User("Paul");
//        User user2 = new User("Sorina");
//        User user3 = new User("Mara");
//
//        // buy tickets for 3 users
//        airport.buyTickets("Barcelona", user1, 3);
//        airport.buyTickets("Madrid", user1, 3);
//        airport.buyTickets("Barcelona", user2, 2);
//        airport.buyTickets("Valencia", user3, 4);
//
//        // cancel Paul's ticket to Madrid and display them
////        airport.cancelTicket("Madrid", user1);
////        List<Ticket> tickets = airport.filterTickets("Madrid","Paul",CANCELED);
////        System.out.println(tickets);
//
//        // update owner of one of Sorina's tickets to Barcelona
//        tickets = airport.filterTickets("Barcelona","Sorina",ACTIVE);
//        user2.updateOwner(user3, tickets.get(0));
//        System.out.println(tickets);
//    }
//
//    private Airport generateAirportInstance() {
//        Airport airport = new Airport(1, "Cluj Airport");
//        airport.addAirplane(new Airplane(AirplaneType.Airbus,150, "Barcelona"));
//        airport.addAirplane(new Airplane(AirplaneType.Boeing,100, "Madrid"));
//        airport.addAirplane(new Airplane(AirplaneType.Airbus,130, "Valencia"));
//        return airport;
//    }
//}
