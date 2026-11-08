package lw04.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt(); // baris 1 : jumlah branch

        int [] branches = new int[n]; // baris 2 : ini arraynya branch
        for (int i=0; i<n; i++) {
            branches[i] = sc.nextInt(); 
        }

        int m = sc.nextInt(); // baris 3 : jumlah target

        int[] targets = new int[m];
        for (int i=0; i <m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        insertionSort(branches, 3);

        for (int i=0; i<n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }
        System.out.println();

        for(int i=0; i<m; i++) {
            int index = linearSearch(branches, targets[i]);
            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }

    }

    static void insertionSort(int[] branches, int passes) {
    for (int p = 1; p <= passes; p++) {
        int temp = branches[p];
        boolean stop = false;
        for (int i = p - 1; i >= 0 && !stop; i--) {
            if (branches[i] < temp) {
                branches[i + 1] = branches[i];
                branches[i] = temp;
            } else {
                stop = true;
            }
        }
    }
}

    static int linearSearch(int[] branches, int target) {
        for (int i=0; i<branches.length; i++) {
            if (branches[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
