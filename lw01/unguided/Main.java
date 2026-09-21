package unguided; 
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int n = sc.nextInt();
        while (sc.hasNext()) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();
                
            if (type.equals("Laptop")) {
                rentals.add(new LaptopRental(id, days));
            } else if (type.equals("Projector")) {
                rentals.add(new ProjectRental(id, days));
            }
        }
        
        for(Rental rental : rentals) {
            System.out.println(rental.summary());
        }

        sc.close();
    }
}
