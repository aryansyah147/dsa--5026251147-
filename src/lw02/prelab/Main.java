package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();

            String[] transaction = new String[3];
            transaction[0] = name;
            transaction[1] = type;
            transaction[2] = amount;
            transactions.add(transaction);

            // cek apakah customer ini sudah pernah muncul sebelumnya
            boolean sudahAda = false;
            for (int i = 0; i < customers.size(); i++) {
                String[] cust = customers.get(i);
                if (cust[0].equals(name)) {
                    sudahAda = true;
                }
            }

            if (sudahAda == false) {
                String[] newCustomer = new String[2];
                newCustomer[0] = name;
                newCustomer[1] = "0";
                customers.add(newCustomer);
            }
        }
        sc.close();

        // pindahkan semua transaksi ke Queue
        Queue<String[]> queue = new LinkedList<>();
        while (transactions.isEmpty() == false) {
            String[] data = transactions.poll();
            queue.add(data);
        }

        Stack<String[]> failedTransactions = new Stack<>();

        // proses satu-satu transaksi dari queue
        while (queue.isEmpty() == false) {
            String[] transaction = queue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            // cari data customer-nya di list customers
            int balance = 0;
            int index = -1;
            for (int i = 0; i < customers.size(); i++) {
                String[] cust = customers.get(i);
                if (cust[0].equals(name)) {
                    balance = Integer.parseInt(cust[1]);
                    index = i;
                }
            }

            if (type.equals("DEPOSIT")) {
                balance = balance + amount;
                customers.get(index)[1] = "" + balance;
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    failedTransactions.push(transaction);
                } else {
                    balance = balance - amount;
                    customers.get(index)[1] = "" + balance;
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (int i = 0; i < customers.size(); i++) {
            String[] cust = customers.get(i);
            System.out.println(cust[0] + " : " + cust[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (failedTransactions.isEmpty() == false) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}