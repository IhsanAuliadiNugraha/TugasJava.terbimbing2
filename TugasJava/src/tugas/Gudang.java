package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftar = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah satu barang ke koleksi
    public void tambahBarang(Barang barang) {
        daftar.add(barang);
    }

    // Menampilkan seluruh barang beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Barang Toko ==");
        if (daftar.isEmpty()) {
            System.out.println("  (Belum ada barang)");
            return;
        }
        for (int i = 0; i < daftar.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + daftar.get(i).info());
        }
    }

    // Menyimpan seluruh barang ke berkas, satu barang per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftar) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Membaca kembali barang dari berkas ke dalam ArrayList
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftar.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    // Menjumlahkan harga x stok dari seluruh barang
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftar) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }

    public int jumlahBarang() {
        return daftar.size();
    }
}
