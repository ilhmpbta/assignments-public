public class Kelas {
    public char kodeKelas;
    public Dosen dataDosen;
    public MataKuliah dataMK;
    public int kapasitasBatas;
    public int kapasitasSekarang;

    public Kelas(char kodeKelas, int kapasitas, Dosen dataDosen, MataKuliah dataMK){
        this.kodeKelas = kodeKelas;
        this.kapasitasBatas = kapasitas;
        this.kapasitasSekarang = 0;
        this.dataDosen = dataDosen;
        this.dataMK = dataMK;
    }

    public Kelas(){

    }   
}
