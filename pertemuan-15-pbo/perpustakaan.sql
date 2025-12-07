CREATE DATABASE perpustakaan;
USE perpustakaan;

CREATE TABLE buku (
  id_buku INT AUTO_INCREMENT PRIMARY KEY,
  judul VARCHAR(45) NOT NULL,
  pengarang VARCHAR(45) NOT NULL
);
