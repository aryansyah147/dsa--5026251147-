package unguided;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int n = sc.nextInt();
        for (int i = 0; i < n && sc.hasNext(); i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            Rental rental;
            if (type.equalsIgnoreCase("Laptop")) {
                rental = new LaptopRental(id, days);
            } else if (type.equalsIgnoreCase("Projector")) {
                rental = new ProjectRental(id, days);
            } else {
                continue;
            }
            rentals.add(rental);
        }

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }

        sc.close();
    }
}