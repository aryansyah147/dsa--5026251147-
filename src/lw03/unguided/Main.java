package lw03.unguided;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner (Main.class.getResourceAsStream("enrollment.txt"));

       Map<String, Integer> enrollment = new LinkedHashMap<>();

       List<String> hasilCheck = new ArrayList<>();

       int penolakan = 0;

       while (sc.hasNextLine()) {
            String tipe = sc.next(); // REGISTER / CHECK / WITHDRAW
            String kode = sc.next(); // kode matkul

            if(tipe.equals("REGISTER")) {
                int jumlah = sc.nextInt(); 
                if (jumlah <= 0) {
                    penolakan++;
                } else if (enrollment.containsKey(kode)) {
                    int current = enrollment.get(kode); 
                    enrollment.put(kode, current + jumlah); 
                } else {
                    enrollment.put(kode, jumlah);
                }

            } else if (tipe.equals("WITHDRAW")) {
                int jumlah = sc.nextInt();

                if(jumlah <= 0) {
                    penolakan++;
                } else if (enrollment.containsKey(kode) && enrollment.get(kode) >= jumlah) {
                    int current = enrollment.get(kode);
                    enrollment.put(kode, current - jumlah);
                } else {
                    penolakan++;
                }

            } else if (tipe.equals("CHECK")) {
                if (enrollment.containsKey(kode)) {
                    hasilCheck.add(kode + " : " + enrollment.get(kode) + " students");
                } else {
                    hasilCheck.add(kode + " : Not Found");
                }
            }


        }

        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for(int i=0; i<hasilCheck.size(); i++) {
            System.out.println(hasilCheck.get(i));
        }
        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for (String kode : enrollment.keySet()) {
            System.out.println(kode + " : " + enrollment.get(kode) + " students");
        }
        System.out.println();

        System.out.println("===== Rejected Operations =====");
        System.out.println("REjectefd Operations : " + penolakan);








    }
}
