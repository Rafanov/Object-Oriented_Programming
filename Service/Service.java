
package Service;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Model;
import Model.TiketDomestik;
import Model.TiketInternasional;

public class Service {
    static Scanner Scanner = new Scanner(System.in);
    static ArrayList<Model> daftarTiket = new ArrayList<>();
    
    public static void menuUtama() {
        System.out.println("\n======= SELAMAT DATANG DI SISTEM TIKETPLANE ========");
        System.out.println("1. Lihat Daftar Tiket");
        System.out.println("2. Tambah Tiket Baru");
        System.out.println("3. Edit Tiket");
        System.out.println("4. Hapus Tiket");
        System.out.println("5. Cari Tiket");
        System.out.println("6. Keluar");
        System.out.println("=====================================================");
    }

    public static void lihatTiket() {
        System.out.println("=== DAFTAR TIKET ===");
        if (daftarTiket.isEmpty()) {
            System.out.println("Belum ada tiket.");
        } else {
            for (int i = 0; i < daftarTiket.size(); i++) {
                System.out.println((i + 1) + ". " + daftarTiket.get(i));
            }
        }
        System.out.println("Tekan Enter untuk kembali...");
        Scanner.nextLine();
    }

    public static void tambahTiket() {
        System.out.println("=== TAMBAH TIKET ===");
        System.out.print("Jenis Tiket (1 = Domestik, 2 = Internasional): ");
        String jenis = Scanner.nextLine().trim();

        System.out.print("Kode Penerbangan: ");
        String kode = Scanner.nextLine();

        System.out.print("Maskapai: ");
        String maskapai = Scanner.nextLine();

        System.out.print("Bandara Asal: ");
        String asal = Scanner.nextLine();

        System.out.print("Bandara Tujuan: ");
        String tujuan = Scanner.nextLine();

        System.out.print("Armada Pesawat: ");
        String armada = Scanner.nextLine();

        Model tiketBaru;

        if (jenis.equals("2")) {
            System.out.print("Negara Tujuan: ");
            String negara = Scanner.nextLine();
            tiketBaru = new TiketInternasional(kode, maskapai, asal, tujuan, armada, negara);
        } else {
            tiketBaru = new TiketDomestik(kode, maskapai, asal, tujuan, armada);
        }

        daftarTiket.add(tiketBaru);
        System.out.println("Tiket berhasil ditambahkan!");
        System.out.println("Tekan Enter untuk kembali...");
        Scanner.nextLine();
    }
    
    public static void editTiket() {
        System.out.println("========= EDIT TIKET ==========");

        if (daftarTiket.isEmpty()) {
            System.out.println("Belum ada tiket yang bisa diedit.");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }

        for (int i = 0; i < daftarTiket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTiket.get(i));
        }

        System.out.print("Pilih nomor tiket yang ingin diedit: ");
        int nomor = Scanner.nextInt();
        Scanner.nextLine();

        if (nomor < 1 || nomor > daftarTiket.size()) {
            System.out.println("Nomor tidak valid.");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }

        Model tiketLama = daftarTiket.get(nomor - 1);
        System.out.println("Jenis Tiket Lama: " + tiketLama.getJenis());

        System.out.print("Jenis Tiket Baru (1 = Domestik, 2 = Internasional): ");
        String jenis = Scanner.nextLine().trim();

        System.out.println("=== Masukkan Data Baru ===");
        System.out.print("Kode Penerbangan: ");
        String kode = Scanner.nextLine();

        System.out.print("Maskapai: ");
        String maskapai = Scanner.nextLine();

        System.out.print("Bandara Asal: ");
        String asal = Scanner.nextLine();

        System.out.print("Bandara Tujuan: ");
        String tujuan = Scanner.nextLine();

        System.out.print("Armada: ");
        String armada = Scanner.nextLine();

        Model tiketBaru;

        if (jenis.equals("2")) {
            System.out.print("Negara Tujuan: ");
            String negara = Scanner.nextLine();
            tiketBaru = new TiketInternasional(kode, maskapai, asal, tujuan, armada, negara);
        } else {
            tiketBaru = new TiketDomestik(kode, maskapai, asal, tujuan, armada);
        }

        daftarTiket.set(nomor - 1, tiketBaru);

        System.out.println("Tiket berhasil diedit!");
        System.out.println("Jenis Tiket Baru: " + tiketBaru.getJenis());
        System.out.println("Tekan Enter untuk kembali...");
        Scanner.nextLine();


    }
    
    public static void hapusTiket() {
            System.out.println("========= HAPUS TIKET ==========");

        if (daftarTiket.isEmpty()) {
            System.out.println("Tiket Tidak Tersedia!");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }

        for (int i = 0; i < daftarTiket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTiket.get(i));
        }

        System.out.print("Pilih nomor tiket yang ingin dihapus: ");
        int nomor = Scanner.nextInt();
        Scanner.nextLine();

        if (nomor < 1 || nomor > daftarTiket.size()) {
            System.out.println("Nomor tiket tidak valid");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }

        Model tiketDihapus = daftarTiket.remove(nomor - 1);
        System.out.println("Tiket \"" + tiketDihapus + "\" berhasil dihapus.");
        System.out.println("Tekan Enter untuk kembali...");
        Scanner.nextLine();

    }
    
    public static void cariTiket() {
        System.out.println("============ CARI TIKET =============");
        System.out.print("Masukkan kata kunci (kode atau maskapai): ");
        String cari = Scanner.nextLine().trim().toLowerCase();

        boolean ditemukan = false;
        for (Model tiket : daftarTiket) {
            if (tiket.getkodePenerbangan().toLowerCase().contains(cari) ||
            tiket.getMaskapai().toLowerCase().contains(cari)) {
            System.out.println(tiket);
            ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tiket tidak ditemukan.");
        }
        
        System.out.println("Tekan Enter Untuk Kembali....");
        Scanner.nextLine();
    }
        
    public static void initDaftarTiket() {
        daftarTiket.add(new TiketDomestik("JT123", "Garuda Indonesia", "Balikpapan", "Jakarta", "Boeing 737"));
        daftarTiket.add(new TiketDomestik("JT456", "Lion Air", "Balikpapan", "Surabaya", "Airbus A320"));
        daftarTiket.add(new TiketDomestik("JT789", "Citilink", "Balikpapan", "Bali", "ATR 72"));
        daftarTiket.add(new TiketInternasional("JT012", "AirAsia", "Balikpapan", "Kuala Lumpur", "Airbus A320neo", "Malaysia"));
        daftarTiket.add(new TiketDomestik("JT345", "Super Air Jet", "Balikpapan", "Medan", "Boeing 737-800"));
        daftarTiket.add(new TiketDomestik("JT123", "Garuda Indonesia", "Balikpapan", "Jakarta", "Boeing 737"));
        daftarTiket.add(new TiketInternasional("INT456", "Singapore Airlines", "Jakarta", "Singapore", "Airbus A350", "Singapura"));



    }
}
