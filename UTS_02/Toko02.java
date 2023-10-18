import java.util.Scanner;

public class Toko02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama anda: ");
        String namaPelanggan = input.nextLine();

        System.out.print("Masukkan tipe pelanggan (member/bukan member): ");
        String tipePelanggan = input.nextLine();

        int totalItem = 0;
        double subtotal = 0;
        double totalDiskon = 0;

        boolean tambahProduk = true;

        while (tambahProduk) {
            System.out.print("Masukkan nama produk yang anda beli: ");
            String namaProduk = input.nextLine();

            System.out.print("Banyaknya: ");
            int kuantitas = input.nextInt();

            System.out.print("Harga: ");
            double hargaSatuan = input.nextDouble();

            System.out.print("Diskon produk (%): ");
            double diskonProduk = input.nextDouble();

            totalItem += kuantitas;
            double hargaProduk = kuantitas * hargaSatuan;
            double diskon = diskonProduk / 100 * hargaProduk;
            subtotal += hargaProduk;
            totalDiskon += diskon;

            System.out.print("Apakah anda mau menambahkan produk lagi (Y/N)? ");
            String tambah = input.next();

            if (tambah.equalsIgnoreCase("N")) {
                tambahProduk = false;
            }
            input.nextLine();
        }

        double diskonMember = 0;
        if (tipePelanggan.equalsIgnoreCase("member") && subtotal >= 200000) {
            diskonMember = 0.1 * subtotal;
        } else if (tipePelanggan.equalsIgnoreCase("member")) {
            diskonMember = 0.05 * subtotal;
        }

        double totalAkhir = subtotal - totalDiskon - diskonMember;

        System.out.println("\n----------Total Pembelian----------");
        System.out.println("Nama Pelanggan: " + namaPelanggan);
        System.out.println("Tipe Pelanggan: " + tipePelanggan);
        System.out.println("Total Item Barang: " + totalItem);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total Diskon: " + (totalDiskon + diskonMember));
        System.out.println("Total Akhir yang Harus Dibayar: " + totalAkhir);
    }
}