package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {

        // ============================================================
        // LATIHAN UTAMA: Buat, isi, simpan, muat buku kontak
        // ============================================================
        System.out.println("=== LATIHAN UTAMA ===");
        BukuKontak buku = new BukuKontak("kontak.txt");

        // Menambah kontak dengan nama, nomor, dan email
        buku.tambahKontak(new Kontak("ihsan", "0811111", "ihsan@email.com"));
        buku.tambahKontak(new Kontak("budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));

        buku.tampilkanSemua();
        buku.simpanKeBerkas();

        System.out.println();

        // Objek baru yang kosong, lalu memuat dari berkas
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak: " + bukuLain.jumlahKontak());

        // ============================================================
        // LATIHAN MANDIRI 3.4 No. 1: Cari kontak
        // ============================================================
        System.out.println("\n=== Latihan Mandiri No. 1: Cari Kontak ===");
        bukuLain.cariKontak("Budi");
        bukuLain.cariKontak("Doni"); // tidak ada

        // ============================================================
        // LATIHAN MANDIRI 3.4 No. 3: Hapus kontak
        // ============================================================
        System.out.println("\n=== Latihan Mandiri No. 3: Hapus Kontak ===");
        bukuLain.hapusKontak("Ihsan");
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak setelah dihapus: " + bukuLain.jumlahKontak());
    }
}
