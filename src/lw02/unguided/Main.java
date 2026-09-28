package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
    Scanner sc = new Scanner (Main.class.getResourceAsStream("borrowing.txt"));

    LinkedList<String[]> requests = new LinkedList<>();

        while (sc.hasNext()) {
            String name = sc.next();
            String title = sc.next();

            String[] request = new String[3];
            request[0] = name;
            request[1] = title;
            requests.add(request);
        }
        sc.close();

        LinkedList<String[]> books = new LinkedList<>();

        String[] book1 = new String[2];
        book1[0] = "Kalkulus";
        book1[1] = "2";
        books.add(book1);

        String[] book2 = new String[2];
        book2[0] = "Fisika";
        book2[1] = "1";
        books.add(book2);

        String[] book3 = new String[2];
        book3[0] = "Statistika";
        book3[1] = "2";
        books.add(book3);

         LinkedList<String[]> members = new LinkedList<>();

         for (int t = 0; t < requests.size(); t++) {
            String[] req = requests.get(t);
            String name = req[0];

            boolean pernah = false;
            for (int i = 0; i < books.size(); i++) {
                String[] member = books.get(i);
                if (member[0].equals(name)) {
                    pernah = true;
                }
            }

            if (pernah == false) {
                String[] newMember = new String[2];
                newMember[0] = name;
                newMember[1] = "0";
                books.add(newMember);
            }
        }

        System.out.println("Daftar buku:");







}
