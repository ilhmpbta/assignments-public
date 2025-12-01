-- buat database "tutorial" kemudian buat tabel "mahasiswa" di dalamnya
CREATE DATABASE IF NOT EXISTS tutorial;
USE tutorial;

CREATE TABLE IF NOT EXISTS mahasiswa (
    nim VARCHAR(10) PRIMARY KEY NOT NULL,
    nama_lengkap VARCHAR(50) NOT NULL,
    tanggal_lahir DATE NOT NULL,
    no_hp VARCHAR(13) NOT NULL
);

-- batch 1: masukkan data ke dalam tabel tersebut
INSERT INTO mahasiswa (nim, nama_lengkap, tanggal_lahir, no_hp) VALUES
('1010101001', 'Andi Wijaya', '1990-01-01', '081234567890'),
('1010101002', 'Budi Santoso', '1991-02-02', '082345678901'),
('1010101003', 'Citra Lestari', '1992-03-03', '083456789012'),
('1010101004', 'Dewi Anggraini', '1993-04-04', '084567890123'),
('1010101005', 'Eko Prasetyo', '1994-05-05', '085678901234');

-- batch 2: tambahkan data lagi ke dalam tabel tersebut
INSERT INTO mahasiswa (nim, nama_lengkap, tanggal_lahir, no_hp) VALUES
('1010101006', 'Lil Bahdalia', '1995-06-06', '086789012345'),
('1010101007', 'Prawanto Subowo', '1996-07-07', '087890123456'),
('1010101008', 'Guming Rakaibran', '1997-08-08', '088901234567'),
('1010101009', 'Lundjak Pandjaihut', '1998-09-09', '089012345678'),
('1010101010', 'Jododo Wiko', '1999-10-10', '080123456789');

-- finalize: bersihkan tabel mahasiswa
TRUNCATE TABLE mahasiswa;