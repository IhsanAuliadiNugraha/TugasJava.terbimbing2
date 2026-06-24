// Nama  : IHSAN AULIADI NUGRAHA
// NPM   : 2210010026

package tugas;

public class MainTugas {
    public static void main(String[] args) {

        // ============================================================
        // 1. Array kategori (ukuran tetap, minimal 3)
        // ============================================================
        String[] kategori = {"Elektronik", "Makanan & Minuman", "Pakaian", "Peralatan Rumah"};
        System.out.println("=== Kategori Barang ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("  " + (i + 1) + ". " + kategori[i]);
        }

        // ============================================================
        // 2. Buat objek Gudang, tambah minimal 5 barang
        // ============================================================
        System.out.println("\n=== Mengisi Data Gudang ===");
        Gudang gudang = new Gudang("barang.txt");

        gudang.tambahBarang(new Barang("Laptop Asus",   8500000.0, 10));
        gudang.tambahBarang(new Barang("Mouse Wireless",  150000.0, 50));
        gudang.tambahBarang(new Barang("Kaos Polos",      75000.0, 100));
        gudang.tambahBarang(new Barang("Mie Instan",       3500.0, 200));
        gudang.tambahBarang(new Barang("Sapu Lantai",     45000.0, 30));

        // ============================================================
        // 3. Tampilkan semua barang dan simpan ke berkas
        // ============================================================
        gudang.tampilkanSemua();
        System.out.println("\nTotal nilai persediaan: Rp" 
                + String.format("%,.0f", gudang.totalNilai()));

        System.out.println();
        gudang.simpanKeBerkas();

        // ============================================================
        // 4. Buat objek Gudang baru, muat dari berkas, buktikan data tersimpan
        // ============================================================
        System.out.println("\n=== Memuat Ulang dari Berkas (objek baru) ===");
        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();
        System.out.println("\nJumlah barang dimuat : " + gudangBaru.jumlahBarang());
        System.out.println("Total nilai persediaan: Rp"
                + String.format("%,.0f", gudangBaru.totalNilai()));
    }
}
