import java.util.Scanner;
import java.text.DecimalFormat;

public class HitungIP02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        String namaMahasiswa = input.nextLine();

        int jumlahMataKuliah = 0;
        double totalNilai = 0;
        int totalSKS = 0;
        int jumlahPerbaikan = 0;

        boolean lanjutInput = true;
        while (lanjutInput) {
            jumlahMataKuliah++;

            System.out.print("Masukkan nama mata kuliah ke-" + jumlahMataKuliah + ": ");
            String namaMataKuliah = input.nextLine();

            System.out.print("Nilai (A, B+, B, C+, C, D, E) : ");
            String indeksNilai = input.nextLine();

            System.out.print("Masukkan SKS mata kuliah " + namaMataKuliah + ": ");
            int sks = input.nextInt();

            double nilai = konversiIndeksNilai(indeksNilai);
            totalNilai += nilai * sks;
            totalSKS += sks;

            System.out.print("Apakah lanjut input nilai (Y/N)? ");
            String lanjut = input.next();
            input.nextLine();

            if (lanjut.equalsIgnoreCase("N")) {
                lanjutInput = false;
            }
            
            if (indeksNilai.equals("D") || indeksNilai.equals("E")) {
                jumlahPerbaikan++;
            }
        }

        double ip = totalNilai / totalSKS;
        DecimalFormat df = new DecimalFormat("0.00"); // Format dua angka desimal
        String formattedIP = df.format(ip); // Memformat IP dengan dua angka desimal

        System.out.println("\n----------Hasil Perhitungan IP----------");
        System.out.println("Nama Mahasiswa: " + namaMahasiswa);
        System.out.println("Indeks Prestasi (IP): " + formattedIP); // Mencetak IP yang telah diformat
        System.out.println("Jumlah Mata Kuliah: " + jumlahMataKuliah);
        System.out.println("Jumlah SKS: " + totalSKS);
        System.out.println("Jumlah Mata Kuliah yang Harus Perbaikan/Remidi: " + jumlahPerbaikan);
    }

    public static double konversiIndeksNilai(String indeksNilai) {
        double nilai = 0.0;

        switch (indeksNilai) {
            case "A":
                nilai = 4.0;
                break;
            case "B+":
                nilai = 3.5;
                break;
            case "B":
                nilai = 3.0;
                break;
            case "C+":
                nilai = 2.5;
                break;
            case "C":
                nilai = 2.0;
                break;
            case "D":
                nilai = 1.0;
                break;
            case "E":
                nilai = 0.0;
                break;
        }

        return nilai;
    }
}