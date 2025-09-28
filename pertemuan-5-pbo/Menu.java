import java.util.Scanner;

public class Menu {
    private LocalDB db;
    private Scanner scanner;

    public Menu(LocalDB db) {
        this.db = db;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Ambil Kelas");
            System.out.println("2. Lihat Data Kelas");
            System.out.println("3. Lihat Data Mahasiswa");
            System.out.println("4. Lihat Data Dosen");
            System.out.println("5. Lihat Data Mata Kuliah");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline, menghindari error

            switch (pilihan) {
                case 1: ambilKelas(); break;
                case 2: lihatKelas(); break;
                case 3: lihatMahasiswa(); break;
                case 4: lihatDosen(); break;
                case 5: lihatMatkul(); break;
                case 6: System.out.println("Terima kasih!"); return;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void ambilKelas() {
        System.out.print("Masukkan NRP Mahasiswa: ");
        String nrp = scanner.nextLine();

        Mahasiswa mhs = null;
        for (Mahasiswa m : db.listMahasiswa) {
            if (m != null && m.nrp.equals(nrp)) {
                mhs = m;
                break;
            }
        }

        if (mhs == null) {
            System.out.println("Mahasiswa tidak ditemukan.");
            return;
        }

        System.out.println("Daftar Kelas Tersedia:");
        for (int i = 0; i < db.listKelas.length; i++) {
            Kelas k = db.listKelas[i];
            if (k != null && k.dataMK != null && k.dataDosen != null) {
                System.out.println(i + ". Kelas " + k.kodeKelas + " - " + k.dataMK.nama + " | Dosen: " + k.dataDosen.nama + " | Kapasitas: " + k.kapasitasSekarang + "/" + k.kapasitasBatas);
            }
        }

        System.out.print("Pilih nomor kelas: ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        if (pilih < 0 || pilih >= db.listKelas.length || db.listKelas[pilih] == null) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Kelas kelasDipilih = db.listKelas[pilih];

        if (kelasDipilih.kapasitasSekarang >= kelasDipilih.kapasitasBatas) {
            System.out.println("Kelas penuh.");
            return;
        }

        // Cek apakah mahasiswa sudah mencapai batas SKS
        int sksKelas = kelasDipilih.dataMK.sks;
        int sksBatas = mhs.batas_sks(mhs.ipk);

        if (mhs.sks_ambil + sksKelas > sksBatas) {
            System.out.println("Gagal mengambil kelas. SKS melebihi batas.");
            return;
        }

        // Ambil kelas
        kelasDipilih.kapasitasSekarang++;
        mhs.sks_ambil += sksKelas;

        System.out.println("Kelas berhasil diambil!");
    }

    private void lihatKelas() {
        System.out.println("\n=== DATA KELAS ===");
        for (Kelas k : db.listKelas) {
            if (k != null && k.dataMK != null && k.dataDosen != null) {
                System.out.println(k.dataMK.nama + "(" + k.kodeKelas + ")");
                System.out.println("  Dosen: " + k.dataDosen.nama);
                System.out.println("  Kapasitas: " + k.kapasitasSekarang + "/" + k.kapasitasBatas);
            }
        }
    }

    private void lihatMahasiswa() {
        System.out.println("\n=== DATA MAHASISWA ===");
        for (Mahasiswa m : db.listMahasiswa) {
            if (m != null) {
                m.dataMahasiswa();
                System.out.println();
            }
        }
    }

    private void lihatDosen() {
        System.out.println("\n=== DATA DOSEN ===");
        for (Dosen d : db.listDosen) {
            if (d != null) {
                d.dataDosen();
                System.out.println();
            }
        }
    }

    private void lihatMatkul() {
        System.out.println("\n=== DATA MATA KULIAH ===");
        for (MataKuliah mk : db.listMataKuliah) {
            if (mk != null) {
                System.out.println("Kode: " + mk.kode + " | Nama: " + mk.nama + " | SKS: " + mk.sks);
            }
        }
    }
}
