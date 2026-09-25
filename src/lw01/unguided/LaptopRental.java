package unguided;

public class LaptopRental extends Rental implements Chargeable {
    private int daysRented;

    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override 
    public int calculateCharge() {
        return getDays() * 40000;
    }

    @Override // karena di monoprint labelnya me retuyn mono,tidak seperti printjob
    public String label() {
        return "Laptop";
    }

}
