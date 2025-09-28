public class LocalDB {
    Mahasiswa[] listMahasiswa;
    Dosen[] listDosen;
    MataKuliah[] listMataKuliah;
    Kelas[] listKelas;

    public LocalDB() {
        listMahasiswa = new Mahasiswa[10];
        listMataKuliah = new MataKuliah[10];
        listDosen = new Dosen[10];
        listKelas = new Kelas[10];

        listMahasiswa[0] = new Mahasiswa("5025241152", "Bintang Ilham Pabeta", 1, 3.92);
        listMahasiswa[1] = new Mahasiswa("6025241152", "Bintang von S2", 2, 3.93);
        listMahasiswa[2] = new Mahasiswa("7025241152", "Bintang van S3", 3, 4.0);

        listDosen[0] = new Dosen("0003047405", "Fajar Baskoro, S.Kom, M.T.", "ALPRO");
        listDosen[1] = new Dosen("0001234567", "Dosen mac Kale, S.Si., Ph.D", "PKT");
        listDosen[2] = new Dosen("0002345678", "Dr. Eng Dosen bin Tres, S.T.", "MCI");

        listMataKuliah[0] = new MataKuliah("Pemrograman Web", "EF234301", 3);
        listMataKuliah[1] = new MataKuliah("Teori Graf", "EF234304", 3);
        listMataKuliah[2] = new MataKuliah("Data Mining", "EF234518", 3);

        listKelas[0] = new Kelas('A', 30, listDosen[0], listMataKuliah[0]);
        listKelas[1] = new Kelas('B', 30, listDosen[0], listMataKuliah[0]);
        listKelas[2] = new Kelas('A', 30, listDosen[1], listMataKuliah[1]);
        listKelas[3] = new Kelas('B', 30, listDosen[1], listMataKuliah[1]);
        listKelas[4] = new Kelas('A', 30, listDosen[2], listMataKuliah[2]);
        listKelas[5] = new Kelas('B', 30, listDosen[2], listMataKuliah[2]);
    }
}
