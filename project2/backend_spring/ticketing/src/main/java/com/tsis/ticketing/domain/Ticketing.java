package com.tsis.ticketing.domain;

public class Ticketing {
    private int TicketingID;
    private String PhoneNumber;
    private String Seat;
    private int MovieID;

    public int getTicketingID() {
        return TicketingID;
    }

    public void setTicketingID(int ticketingID) {
        TicketingID = ticketingID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int movieID) {
        MovieID = movieID;
    }

    @Override
    public String toString() {
        return "Ticketing{" +
                "TicketingID=" + TicketingID +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Seat='" + Seat + '\'' +
                ", MovieID=" + MovieID +
                '}';
    }
}
