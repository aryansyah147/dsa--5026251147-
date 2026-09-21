package lw01.prelab;  

public abstract class PrintJob implements Chargeable {

    private String id; // atribut 
    private int pages; // atribut

    protected PrintJob(String id, int pages) { // constructor
        if (pages <= 0) {
            throw new IllegalArgumentException("pages must be positive");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() { // getter methid se simpel return
        return id;
    }

    public int getPages() { // // getter methid se simpel return
        return pages;
    }

    @Override // menimpah method dari interface Chargeable
    public abstract int calculateCharge(); // karena ini abstract, maka tidak ada implementasi di sini, tapi di subclassnya

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("copies must be positive");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return getId() + " | " + label() + " | " + calculateCharge();
    }
}