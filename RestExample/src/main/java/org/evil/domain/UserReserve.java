package org.evil.domain;

public class UserReserve {
    private Sport sport;
    private int quantity;

    public UserReserve() {
        this.sport = new Sport();
        this.quantity = 0;
    }

    public UserReserve(Sport sport, int quantity) {
        this.sport = sport;
        this.quantity = quantity;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
