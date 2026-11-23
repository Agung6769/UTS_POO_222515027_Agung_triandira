import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restoran resto = new Restoran("Restoran Mas Chumy");

        while (true) {
            tampilMenuUtama(resto.getNamaTempat());
            int pilih = inputAngkaBulat(sc, "Pilih (1-7): ");

            if (pilih == 1) {
                String kd = inputTeks(sc, "Kode: ");
                String nm = inputTeks(sc, "Nama menu: ");
                double hrg = inputAngkaMinimal(sc, "Harga: ", 0);
                resto.tambahMenu(new Menu(kd, nm, hrg, true));
                System.out.println("Ok, menu masuk.");
            } else if (pilih == 2) {
                String id = inputTeks(sc, "ID pelanggan: ");
                String nm = inputTeks(sc, "Nama: ");
                String hp = inputTeks(sc, "No HP: ");
                resto.tambahPelanggan(new Pelanggan(id, nm, hp, 0));
                System.out.println("Ok, pelanggan tersimpan.");
            } else if (pilih == 3) {
                String kdOrder = inputTeks(sc, "Kode pesanan: ");
                String cari = inputTeks(sc, "ID/Nama pelanggan: ");
                Pelanggan p = resto.cariPelanggan(cari);
                if (p == null) {
                    System.out.println("Pelanggan belum terdaftar.");
                    continue;
                }
                Pesanan order = new Pesanan(kdOrder, p);
                while (true) {
                    resto.getKatalogMenu().cetakList();
                    String kdMenu = inputTeks(sc, "Kode menu ('selesai' untuk tutup): ");
                    if (kdMenu.equalsIgnoreCase("selesai")) {
                        break;
                    }
                    Menu found = resto.getKatalogMenu().search(kdMenu);
                    if (found != null && order.masukkanItem(found)) {
                        System.out.println("+ " + found.getNama());
                    } else {
                        System.out.println("Menu tidak ada atau habis.");
                    }
                }
                if (resto.simpanPesanan(order)) {
                    System.out.println("Subtotal: Rp" + (long) order.subtotal() +
                            " | Total (+10% pajak): Rp" + (long) order.totalBayar());
                } else {
                    System.out.println("Pesanan batal, minimal 1 menu ya.");
                }
            } else if (pilih == 4) {
                String kd = inputTeks(sc, "Cari kode menu: ");
                Menu found = resto.getKatalogMenu().search(kd);
                System.out.println(found != null ? found.ringkasInfo() : "Tidak ketemu.");
            } else if (pilih == 5) {
                resto.getKatalogMenu().cetakList();
            } else if (pilih == 6) {
                resto.cetakRingkasan();
            } else if (pilih == 7) {
                System.out.println("Keluar.");
                break;
            } else {
                System.out.println("Pilih angka 1 sampai 7.");
            }
        }
        sc.close();
    }

    private static void tampilMenuUtama(String namaResto) {
        System.out.println("\n=== " + namaResto + " ===");
        System.out.println("1. Tambah Menu");
        System.out.println("2. Tambah Pelanggan");
        System.out.println("3. Buat Pesanan");
        System.out.println("4. Cari Menu");
        System.out.println("5. Tampilkan Sorted List Menu");
        System.out.println("6. Ringkasan Restoran");
        System.out.println("7. Keluar");
    }

    private static String inputTeks(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Jangan dikosongin.");
        }
    }

    private static int inputAngkaBulat(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Harus angka.");
            }
        }
    }

    private static double inputAngkaMinimal(Scanner sc, String prompt, double min) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = Double.parseDouble(sc.nextLine().trim());
                if (val >= min) {
                    return val;
                }
                System.out.println("Minimal " + (long) min + ".");
            } catch (NumberFormatException e) {
                System.out.println("Harus angka.");
            }
        }
    }
}