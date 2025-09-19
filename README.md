# Object-Oriented_Programming-PostTest3
Nama: Raihan Fariz N


NIM: 2409116083

## Deskripsi Program
Program Sistem TiketPlane adalah program untuk mengelola data tiket penerbangan. Program ini dibuat

dengan bahasa pemrograman Java menggunakan konsep Pemrograman Berorientasi Objek (PBO) dan

memanfaatkan ArrayList sebagai tempat penyimpanan data tiket secara dinamis.

Fitur utama program ini adalah:


- Menampilkan daftar tiket

- Menambahkan tiket baru

- Mengedit tiket yang sudah ada

- Menghapus tiket

- Mencari tiket

- Keluar dari program


Program menggunakan pendekatan berbasis objek dan struktur modular agar mudah dikembangkan dan dipahami.

## Struktur Class dan Fungsinya
Program ini hanya menggunakan satu class utama yaitu , namun di dalamnya terdapat beberapa method modular yang berfungsi sebagai controller dan UI interaktif.

### 1. Main.java
Class utama yang berisi method  dan seluruh logika program.


#### A. Import Package
```bash
    import java.util.Scanner;
    import Service.Service;
```

Scanner digunakan untuk mengambil input dari user.

Service digunakan untuk mengambil kode dari Class Service



#### B. Inisialisasi Data
``` bash
static Scanner Scanner = new Scanner(System.in); 
Service.initDaftarTiket();
```
    

Scanner: objek untuk membaca input user.
Service.initDaftarTiket: untuk mengambil data dari Class Service

#### C. Program untuk Memilih input

```bash
do {
            Service.menuUtama();
            System.out.print("Pilih Menu: ");
            String input = Scanner.nextLine().trim();

            try {
                pilihan = Integer.parseInt(input);
                switch (pilihan) {
                    case 1:
                        Service.lihatTiket();
                        break;
                    case 2:
                        Service.tambahTiket();
                        break;
                    case 3:
                        Service.editTiket();
                        break;
                    case 4:
                        Service.hapusTiket();
                        break;
                    case 5:
                        Service.cariTiket();
                        break;
                    case 6:
                        System.out.println("Keluar dari program...");
                        break;
                    default:
                        System.out.println("Silahkan pilih pilihan yang valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Silahkan pilih pilihan yang valid!");
            }

        } while (pilihan != 6);

        Scanner.close();
```

User akan diarahkan untuk memilih pilihan yang akan diteruskan untuk menjalankan

program selanjutnya, jika user memilih angka 1 - 6 maka program akan bekerja.

Namun, jika user melakukan input asal maka akan ada peringatan untuk memasukkan

input yang valid.



### 2. Service.java


Main.java berisi program untuk mengeksekusi program yang ada di dalam Class Main.java

#### A. Import Package

```bash
import java.util.ArrayList;
import java.util.Scanner;
import Model.Model;
```

- import java.util.ArrayList digunakan untuk memanggil sebuah fungsi yang digunakan sebagai

database sementara.

- Scanner digunakan untuk mengambil input dari user.

- Import Model digunakan untuk memanggil Class Model yang mendeklarasikan Variable.



#### B. Inisialisasi Data

```bash
    static Scanner Scanner = new Scanner(System.in);
    static ArrayList<Model> daftarTiket = new ArrayList<>();
```

- Scanner untuk mengambil input dari user dan ketika ingin melakukan pemanggilan input

programmer akan memanggil Scanner (Mendeklarasikan package Scanner sebagai Scanner)

- ArrayList untuk database sementara, Model tempat variable disimpan dan daftarTiket tempat
database disimpan.



#### C. menuUtama()

```bash
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
```

Method ini menampilkan menu pilihan untuk user dan melakukan input agar user, di antaranya adalah:

1. Lihat Daftar Tiket

2. Tambah Tiket Baru

3. Edit Tiket

4. Hapus Tiket

5. Cari Tiket
   
6. Keluar 

Jika User memilih 1, maka user dapat melihat daftar tiket yang ada.

Jika User memilih 2, maka user dapat menambah tiket sesuai dengan variable input.

Jika user memilih 3, maka user dapat mengupdate (Edit) tiket yang sudah tersedia.

Jika user memilih 4, maka user dapat menghapus tiket yang sudah tersedia.

jika user memilih 5, maka user dapat mencari tiket yang ada di database

Jika user memilih 6, maka user dapat keluar dari program (menghentikan program)




#### D. lihatTiket()

```bash
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

```

Fungsi dari method lihatTiket() adalah untuk menampilkan semua tiket yang sudah ada di dalam sistem.

Jika kosong sistem akan memberi tahu bahwa tiket belum tersedia.




#### E. tambahTiket()

```bash
    public static void tambahTiket() {
        System.out.println("=== TAMBAH TIKET ===");

        System.out.print("Kode Penerbangan: ");
        String kodePenerbangan = Scanner.nextLine();

        System.out.print("Maskapai: ");
        String Maskapai = Scanner.nextLine();

        System.out.print("Tujuan: ");
        String asal = Scanner.nextLine();
        
        System.out.print("Tujuan: ");
        String tujuan = Scanner.nextLine();

        System.out.print("Armada Pesawat: ");
        String Armada = Scanner.nextLine();

        Model tiketBaru = new Model(kodePenerbangan, Maskapai, asal, tujuan, Armada);

        daftarTiket.add(tiketBaru);

        System.out.println("Tiket berhasil ditambahkan!");
        System.out.println("Tekan Enter untuk kembali...");
       Scanner.nextLine();
    }
``` 


Method ini memungkinkan user menambahkan tiket baru dengan memasukkan kode penerbangan, maskapai, tujuan, terminal, dan armada.




#### F. editTiket()


```bash
    public static void editTiket() {
        System.out.println("========= EDIT TIKET ==========");
        
        if (daftarTiket.isEmpty()) {
            System.out.println("Tiket Tidak Tersedia!");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }
        
        for (int i = 0; i < daftarTiket.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTiket.get(i));
        }
        
        System.out.println("Pilih tiket yang ingin diedit: ");
        int nomor = Scanner.nextInt();
        Scanner.nextLine();
        
        if (nomor < 1 || nomor > daftarTiket.size()) {
            System.out.println("Nomor tiket tidak valid");
            System.out.println("Tekan Enter untuk kembali...");
            Scanner.nextLine();
            return;
        }       
        
        System.out.println("========= Edit Data Tiket ============");
        
        System.out.print("Kode Penerbangan Baru: ");
        String kodeBaru = Scanner.nextLine();
        
        System.out.print("Maskapai Baru: ");
        String maskapaiBaru = Scanner.nextLine();
        
        System.out.print("Tujuan Baru: ");
        String asalBaru =Scanner.nextLine();
        
        System.out.print("Tujuan Baru: ");
        String tujuanBaru =Scanner.nextLine();
        
        System.out.print("Armada Baru: ");
        String armadaBaru = Scanner.nextLine();

        
        Model tiketBaru = new Model(kodeBaru, maskapaiBaru, tujuanBaru, asalBaru, armadaBaru);

        daftarTiket.set(nomor - 1, tiketBaru);

        System.out.println("Tiket berhasil diupdate.");
        System.out.println("Tekan Enter untuk kembali...");
        Scanner.nextLine();
        menuUtama();
    }
```

Fungsi dari method editTiket() ini adalah user dapat mengedit data tiket yang sudah ada.

User dapat mengganti informasi penerbangan dengan data baru.




#### G. hapusTiket()

```bash
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
```

Fungsi dari method hapusTiket() adalah untuk menghapus tiket yang dipilih dari daftar.

User dapat menghapus tiket yang sudah ada di dalam daftar tiket sebelumnya.


#### H. Cari Tiket

```bash
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
```

Method cariTiket digunakan supaya user dapat mencari tiket ketika database sudah masuk ke

dalam database yang lebih kompleks

#### I. Inisialisasi Daftar Tiket

```bash
    public static void initDaftarTiket() {
        daftarTiket.add(new Model("JT123", "Garuda Indonesia", "Balikpapan", "Jakarta", "Boeing 737"));
        daftarTiket.add(new Model("JT456", "Lion Air", "Balikpapan", "Surabaya", "Airbus A320"));
        daftarTiket.add(new Model("JT789", "Citilink", "Balikpapan", "Bali", "ATR 72"));
        daftarTiket.add(new Model("JT012", "AirAsia", "Balikpapan", "Yogyakarta", "Airbus A320neo"));
        daftarTiket.add(new Model("JT345", "Super Air Jet", "Balikpapan", "Medan", "Boeing 737-800"));
    }
```

Method ini berfungsi untuk menambahkan beberapa data tiket default ke dalam sistem agar user langsung bisa mencoba fitur-fitur program.

Namun, Inisialisasi Daftar Tiket ini tidak mengubah database ketika user menjalankan program, yang artinya seluruh hal yang dilakukan user,

tidak akan mengubah apapun, walau jika user menambah, mengedit, dan menghapus. Perubahan hanya terjadi jika program tersebut masih berjalan.

Namun, jika program tersebut telah berhenti maka seluruh perubahan akan kembali seperti semula.


### 3. Model.java

Class Model.java berfungsi sebagai Class untuk mendeklarasikan sebuah Variabel yang akan digunakan pada class Service.

#### A. Import Package

```bash
import java.util.ArrayList;
```

ArrayList berfungsi sebagai database sementara (Static)

#### B. Deklarasi Variabel dan Tipe Data

```bash
public class Model {
    private String kodePenerbangan;
    private String maskapai;
    private String asal;
    private String tujuan;
    private String armada;
```

Variable yang dideklarasikan mempunyai tipe data String dan Private agar hanya bisa diakses pada beberapa Class tertantu saja.


#### C. Construct

```bash
    public Model(String kodePenerbangan, String Maskapai, String asal, String tujuan, String Armada){
        this.kodePenerbangan = kodePenerbangan;
        this.maskapai = Maskapai;
        this.asal = asal;
        this.tujuan = tujuan;
        this.armada = Armada;
    }
```

Construct digunakan untuk menginisialisasi nilai awal dari sebuah variable.


#### D. Getter

```bash
    public String getkodePenerbangan() {
    return kodePenerbangan;
    }
    
    public String getMaskapai() {
    return maskapai;
    }
    
    public String getasal() {
    return asal;
    }
    
    public String gettujuan() {
    return tujuan;
    }
    
    public String getArmada() {
    return armada;
    }
```

Getter adalah method yang dipakai untuk mengambil atau membaca nilai variabel (field) private dari sebuah class.

#### Override

```bash
    @Override
    public String toString() {
        return "Kode Penerbangan: " + kodePenerbangan +
           ", Maskapai: " + maskapai +
           ", Asal: " + asal +
           ", Tujuan: " + tujuan +
           ", Armada: " + armada;
    }
```


Method Override berfungsi untuk mengubah tampilan default objek menjadi lebih informatif sesuai kebutuhan, sehingga memudahkan saat dicetak atau di-debug.




## Alur Program Sederhana

#### 1. Inisialisasi Data

Saat program dijalankan, sistem langsung menambahkan beberapa data tiket default ke dalam daftar tiket

hal ini agar user bisa langsung mencoba fitur tanpa harus menambahkan data terlebih dahulu

Jadi singkatnya adalah, ketika program dijalankan, maka user dapat langsung melihat daftar tiket

yang sudah ada di dalam program, user tidak perlu menambah satu per satu.

#### 2. Menu Utama

Saat program berjalan, maka program akan langsung menampilkan menu pilihan:

1. Lihat Daftar Tiket

2. Tambah Tiket Baru

3. Edit Tiket

4. Hapus Tiket

5. Cari Tiket

6. Keluar

Alur Interaksi User

Jika memilih 1 (Lihat Tiket) maka program akan menampilkan daftar tiket yang ada. Jika kosong, sistem akan memberi tahu bahwa tiket belum tersedia.

Jika memilih 2 (Tambah Tiket) maka user akan diminta memasukkan detail penerbangan (kode, maskapai, tujuan, terminal, armada). Data tiket baru akan tersimpan ke dalam ArrayList.

Jika memilih 3 (Edit Tiket) maka user akan melihat daftar tiket, memilih nomor tiket yang ingin diubah, lalu memasukkan data baru. Data lama akan diganti dengan data baru.

Jika memilih 4 (Hapus Tiket) maka user akan memilih tiket berdasarkan nomor urut, lalu sistem akan menghapus tiket tersebut dari daftar.

Jika memilih 5 (Cari Tiket) maka user akan input tiket yang dicari, jika tidak ada maka program
akan kembali ke menuUtama

Jika memilih 6 (Keluar) maka program akan berhenti.

#### 3. Validasi Input

Jika user memasukkan pilihan yang tidak valid, sistem akan menampilkan pesan error dan kembali ke menu utama.




### 4. Penerapan MVC

Apa itu MVC? MVC atau Model View Control adalahsalah satu pola arsitektur (design pattern) yang digunakan dalam pengembangan perangkat lunak.
Tujuan utama MVC adalah memisahkan logika program menjadi tiga bagian utama agar kode lebih rapi, terstruktur, mudah dipelihara, dan fleksibel untuk dikembangkan.

di dalam program ini, penulis juga menerapkan MVC

#### A. Model

Pada Bagian model berisi sebuah kode untuk menyimpan data sementara dan melakukan deklarasi variabel, berikut adalah list hal yang Class model dapat lakukan:


1. Bagian yang berhubungan dengan data dan aturan bisnis.

2. Menyimpan, mengambil, dan memproses data.

3. Tidak tahu soal tampilan (UI), hanya fokus pada logika data.

   

#### B. View

View sendiri diterapkan pada Class Service yang berfungsi untuk menyimpan hal yang berhubungan dengan logika program, View sendiri akan berhubungan dengan Control

dimana user dapat melakukan control terhadap program, berikut adalah hal yang dapat dilakukan oleh View:

1. Bagian yang berhubungan dengan tampilan ke user (UI/UX).

2. Menampilkan data ke layar atau menerima input.

3. Tidak tahu cara data disimpan, hanya menampilkan hasil.


#### C. Control

Control adalah bagian paling depan yang berhubungan langsung dengan user dapat dilihat pada Package PostTest2 dengan
Class Main yang dimana kodenya sendiri digunakan untuk run dan sebagai kode inti
agar program bisa berjalan, berikut adalah hal yang dapat dilakukan oleh control

1. Bagian yang menghubungkan View dan Model.

2. Menerima input dari user (dari View), lalu memerintahkan Model untuk memproses data, dan mengembalikan hasil ke View.

Pada Penjelesan MVC diatas, pembuktian dalam penggunaan MVC adalah terdapat pada package yang berbeda beda, namun kodenya tetap bisa berjalan.

