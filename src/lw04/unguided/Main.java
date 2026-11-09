package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();

        int[] cards = new int[n];
        for(int i=0; i<n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] requests = new int[m];
        for(int i=0; i<m; i++) {
            requests[i] = sc.nextInt();
        }

        sc.close();

        sortCards(cards, 2);

        for(int i=0; i<n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for(int i=0; i<m; i++) {
            int index = findCards(cards, requests[i]);
            if (index != -1) {
                System.out.println(requests[i] + ": FOUND at index " + index);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }
    }

    // sorting 
    static void sortCards(int[] arr, int passes) {
        for(int p=0; p<passes; p++) {
            int minIdx = p;
            for(int i = p + 1; i < arr.length; i ++) {
                if (arr[i] < arr[minIdx]) {
                    minIdx = i;
                }
            }
            int temp = arr[p];
            arr[p] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // searching
    static int findCards(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}