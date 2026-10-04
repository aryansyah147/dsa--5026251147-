package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // problem1();
        // problem2();
        problem3();
    }

    public static void problem1() {
      Scanner sc = new Scanner (Main.class.getResourceAsStream("playlist.txt"));

      List<String> playlist = new ArrayList<>();

      while (sc.hasNext()) {
        String baris = sc.nextLine(); // pake nextLine biar bisa baca seluruh baris, bukan cuma kata pertama
        if (baris.isEmpty()) { // kalau baris kosong (tidak ada isinya)
          continue; // lewati baris ini, lanjut ke baris berikutnya
        }

        
        String[] bagian = baris.split(" ", 2); // memotong max 2 bagian, jadi kalau ada spasi di judul lagu, judulnya tetap utuh
        
        String perintah = bagian[0]; // ADD Ditto, ADD dibaca perintah
        String lagu = bagian[1]; // ADD Ditto, Ditto dibaca judul lagu

        if (perintah.equals("ADD")) { // kalo perintah ADD
            playlist.add(lagu); // maka judul lagu dipindah paling belakang playlist
        } else if (perintah.equals("REMOVE")) { // kalo perintah REMOVE
            playlist.remove(lagu); // maka hapus lagu kemunculan pertama dari playlist
        } else if(perintah.equals ("INSERT")) {
            String[] indexAndSong = lagu.split(" ", 2); // pecah lagi: index dan nama lagu
            int index = Integer.parseInt(indexAndSong[0]); // ubah teks index jadi angka
            String song = indexAndSong[1]; // nama lagu yang mau disisipkan
            playlist.add(index, song); // sisipkan lagu tepat di posisi index itu
        }
      }

      sc.close();

      System.out.println("===== Problem 1 =====");
      System.out.println("Total Songs: " + playlist.size());

      for (int i = 0; i < playlist.size(); i++) { // ulangi dari index 0 sampai akhir list
        System.out.println((i + 1) + ": " + playlist.get(i)); // tampilkan nomor urut (i+1) dan nama lagu di index i
      }
    }

    public static void problem2() {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("participant.txt"));

        Set<String> participants = new LinkedHashSet<>(); // pake SET untuk memastikan nama peserta hanya muncul sekali, LinkedHashSet untuk mempertahankan urutan saat dimasukkan jadi kalo mengirimkan nama yg sama dua kali maka yg diabil adalah nama pertama

        int totalDuplikat = 0; 

        while (sc.hasNextLine()) {
        String nama = sc.nextLine(). trim(); // trim untuk menghapus spasi tidak sengaja di awal dan akhir nama
        if (nama.isEmpty()) { // kalau baris kosong (tidak ada isinya)
          continue; // lewati baris ini, lanjut ke baris berikutnya
        }

        if(participants.contains(nama)) { // cek apakah nama sudah pernah ditambahkan sebelumnya
            totalDuplikat = totalDuplikat + 1; // kalau sudah ada, tambahkan jumlah duplikat
        } else {
            participants.add(nama); // kalau belum ada, baru tambahkan ke set
        }
    }

    sc.close();

    System.out.println("===== Problem 2 =====");

    System.out.println("Unique participants: " + participants.size());

    int number = 1; // nomor urut tampilan, mulai dari 1
    for (String name : participants) { // ulangi setiap nama di dalam Set, sesuai urutannya, set tidak punya getIndex
        System.out.println(number + ". " + name);
        number = number + 1; // naikkan nomor urut untuk baris berikutnya
    }

    System.out.println("Duplicate registrations: " + totalDuplikat);
    }

    public static void problem3() {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> stock = new LinkedHashMap<>();

        int barangGagal = 0;

        while (sc.hasNextLine()) {
            String tipe = sc.next();
            String nama = sc.next();
            int jumlah = sc.nextInt();

            if(tipe.equals("ADD")) {
                if (stock.containsKey(nama)) {
                    int current = stock.get(nama); // cek: apakah produk ini sudah ada di Map?
                    stock.put(nama, current + jumlah); // kalau sudah ada, ambil stok yang sekarang
                } else {
                    stock.put(nama, jumlah); // kalau belum ada, buat baru dengan stok awal = jumlah
                }
            } else if (tipe.equals ("SELL")) {
                if (stock.containsKey(nama) && stock.get(nama) >= jumlah) { // produk ada DAN stoknya cukup?
                    int current = stock.get(nama); // ambil stok sekarang
                    stock.put(nama, current - jumlah); // kurangi sesuai jumlah yang terjual
                } else {
                        barangGagal = barangGagal + 1; // kalau tidak cukup, catat sebagai gagal
                }
            }
        }
        
        sc.close();

        System.out.println("===== Problem 3 =====");
        for (String nama : stock.keySet()) { // ambil semua nama produk di Map
            System.out.println(nama + ": " + stock.get(nama));
        }
        System.out.println("Failed sales: " + barangGagal);
    }
}