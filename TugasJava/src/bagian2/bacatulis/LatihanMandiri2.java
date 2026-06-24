package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {

        // ============================================================
        // SOAL 1: Tulis 5 nama hari ke hari.txt, lalu baca dan tampilkan
        // ============================================================
        System.out.println("=== Soal 1: Tulis 5 nama hari ke hari.txt ===");
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        System.out.println("\nIsi hari.txt setelah ditulis:");
        bacaBerkas("hari.txt");

        // ============================================================
        // SOAL 2: Tambah (append) 2 nama hari lagi, lalu tampilkan semua
        // ============================================================
        System.out.println("\n=== Soal 2: Tambah Sabtu dan Minggu (append) ===");
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("2 nama hari berhasil ditambahkan.");
        } catch (IOException e) {
            System.out.println("Gagal menambah: " + e.getMessage());
        }

        System.out.println("\nIsi hari.txt setelah ditambah:");
        bacaBerkas("hari.txt");

        // ============================================================
        // SOAL 3: Hitung jumlah baris di hari.txt
        // ============================================================
        System.out.println("\n=== Soal 3: Hitung jumlah baris ===");
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
        System.out.println("Jumlah baris di hari.txt: " + jumlah);
    }

    // Method bantu: baca dan tampilkan isi berkas
    private static void bacaBerkas(String namaBerkas) {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            int nomor = 1;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println("  " + nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }
}
