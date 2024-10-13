package Modul101;
import java.util.ArrayList;
import java.util.Scanner;
public class Pembelian {
    private static Penumpang penumpang;
    private static Penerbangan penerbanganTerpilih;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        
        // Tambahkan beberapa data penerbangan untuk simulasi
        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

        boolean running = true;

        while (running) {
            System.out.println("================ EAD Ticket Booking System ================");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");
            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    tampilkanDaftarPenerbangan(daftarPenerbangan);
                    break;

                case 2:
                    beliTiket(input, daftarPenerbangan);
                    break;

                case 3:
                    tampilkanPesanan();
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        input.close();
    }

    private static void tampilkanDaftarPenerbangan(ArrayList<Penerbangan> daftarPenerbangan) {
        System.out.println("Daftar Penerbangan:");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.println((i + 1) + ".");
            daftarPenerbangan.get(i).tampilDaftarPenerbangan();
        }
    }

    private static void beliTiket(Scanner input, ArrayList<Penerbangan> daftarPenerbangan) {
        if (penumpang == null) {
            System.out.println("Silakan isi data diri anda terlebih dahulu");
            System.out.println("--------------------------------");
            System.out.print("Masukan NIK: ");
            String nik = input.nextLine();
            System.out.print("Masukan Nama Depan: ");
            String namaDepan = input.nextLine();
            System.out.print("Masukan Nama Belakang: ");
            String namaBelakang = input.nextLine();
            penumpang = new Penumpang(nik, namaDepan, namaBelakang);
            System.out.println("Terima Kasih telah Mengisi Data Pelanggan. Silakan Pilih Tiket Penerbangan Yang Tersedia");
            System.out.println("--------------------------------");
            tampilkanDaftarPenerbangan(daftarPenerbangan);
        }

        System.out.print("Pilih nomor penerbangan (ex: 1): ");
        int index = input.nextInt() - 1;

        if (index >= 0 && index < daftarPenerbangan.size()) {
            penerbanganTerpilih = daftarPenerbangan.get(index);
            System.out.println("Pemesanan Tiket Berhasil Dilakukan, Cek Pesanan Tiket pada Menu (3)");
        } else {
            System.out.println("Nomor penerbangan tidak valid.");
        }
    }

    private static void tampilkanPesanan() {
        if (penumpang == null || penerbanganTerpilih == null) {
            System.out.println("Pembelian Tiket Tidak Ada");
        } else {
            System.out.println("============= Detail Tiket Penerbangan =============");
            penumpang.tampilDaftarPenumpang();
            System.out.println("Nomor Penerbangan: " + penerbanganTerpilih.getNomorPenerbangan());
            System.out.println("Bandara Keberangkatan: " + penerbanganTerpilih.getBandaraKeberangkatan() + 
                               " --> Bandara Tujuan: " + penerbanganTerpilih.getBandaraTujuan());
            System.out.println("Waktu Keberangkatan: " + penerbanganTerpilih.getWaktuKeberangkatan() + 
                               " --> Waktu Kedatangan: " + penerbanganTerpilih.getWaktuKedatangan());
            System.out.println("Harga Tiket: Rp." + penerbanganTerpilih.getHargaTiket());
        }
    }
}
