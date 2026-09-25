package unguided;

public abstract class Rental implements Chargeable {

    private String id; // atribut
    private int days; // atribut

        protected Rental(String id, int days) { // constructor
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive");
        }
        this.id = id;
        this.days = days;
    }


    public String getId() { // getter methid se simpel return
        return id;
    }

    public int getDays() { // // getter methid se simpel return
        return days;
    }

    @Override // menimpah method dari interface Chargeable
    public abstract int calculateCharge(); // karena ini abstract, maka tidak ada implementasi di sini, tapi di subclassnya

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("units must be positive");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return getId() + " | " + label() + " | " + calculateCharge();
    }
}
