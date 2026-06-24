package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Membaca kembali kontak dari berkas ke dalam ArrayList
    // (Latihan Mandiri 3.4 No. 2: memecah 3 bagian termasuk email)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    // Format baru: nama;nomor;email
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                } else if (bagian.length == 2) {
                    // Format lama: nama;nomor (tetap kompatibel)
                    daftar.add(new Kontak(bagian[0], bagian[1]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }

    // ============================================================
    // LATIHAN MANDIRI 3.4 No. 1: Cari kontak berdasarkan nama
    // ============================================================
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return;
            }
        }
        System.out.println("Kontak '" + nama + "' tidak ditemukan.");
    }

    // ============================================================
    // LATIHAN MANDIRI 3.4 No. 3: Hapus kontak berdasarkan nama
    // ============================================================
    public void hapusKontak(String nama) {
        boolean dihapus = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                System.out.println("Kontak '" + nama + "' berhasil dihapus.");
                dihapus = true;
                break;
            }
        }
        if (!dihapus) {
            System.out.println("Kontak '" + nama + "' tidak ditemukan, tidak ada yang dihapus.");
        }
        // Simpan perubahan ke berkas agar penghapusan ikut tersimpan
        simpanKeBerkas();
    }
}
