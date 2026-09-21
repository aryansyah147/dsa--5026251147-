package lw01.prelab;  

public class MonoPrint extends PrintJob { // subclass dari PrintJob

    public MonoPrint(String id, int pages) {
        super(id, pages); // pske super unuk mengambil constructor dari superclass PrintJob
    }

    @Override 
    public int calculateCharge() {
        return getPages() * 500;
    }

    @Override // karena di monoprint labelnya me retuyn mono,tidak seperti printjob
    public String label() {
        return "Mono";
    }
}