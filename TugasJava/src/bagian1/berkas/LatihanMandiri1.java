package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {

        // ============================================================
        // SOAL 1: Cek keberadaan laporan.txt dan tampilkan ukurannya
        // ============================================================
        System.out.println("=== Soal 1: Cek laporan.txt ===");
        File berkas = new File("laporan.txt");
        if (berkas.exists()) {
            System.out.println("Berkas ada, ukuran: " + berkas.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        // ============================================================
        // SOAL 2: Buat folder baru bernama arsip menggunakan mkdir()
        // ============================================================
        System.out.println("\n=== Soal 2: Buat folder arsip ===");
        File folder = new File("arsip");
        if (folder.mkdir()) {
            System.out.println("Folder 'arsip' berhasil dibuat.");
        } else {
            System.out.println("Folder 'arsip' gagal dibuat (mungkin sudah ada).");
        }

        // ============================================================
        // SOAL 3: Buat sementara.txt lalu hapus, tampilkan status sebelum & sesudah
        // ============================================================
        System.out.println("\n=== Soal 3: Buat lalu hapus sementara.txt ===");
        File sementara = new File("sementara.txt");
        try {
            sementara.createNewFile();
            System.out.println("Sebelum dihapus, ada? " + sementara.exists());
            sementara.delete();
            System.out.println("Sesudah dihapus, ada? " + sementara.exists());
        } catch (IOException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}
