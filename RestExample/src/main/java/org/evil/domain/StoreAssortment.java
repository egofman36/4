package org.evil.domain;

public class StoreAssortment {
    private Sport[] sports;
    private int[] quantity;

    public StoreAssortment(Sport[] sports, int[] quantity) {
        this.sports = sports;
        this.quantity = quantity;
    }

    public StoreAssortment() {
    }

    public void setQuantityFromIndex(int index, int value) {
        try {
            quantity[index] = value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sport[] getSports() {
        return sports;
    }

    public void setSports(Sport[] sports) {
        this.sports = sports;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
