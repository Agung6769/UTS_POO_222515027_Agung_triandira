import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private String namaTempat;
    private SortedMenuList katalogMenu;
    private List<Pelanggan> dataPelanggan;
    private List<Pesanan> riwayatOrder;

    public Restoran() {
        namaTempat = "Resto Lokal";
        katalogMenu = new SortedMenuList();
        dataPelanggan = new ArrayList<>();
        riwayatOrder = new ArrayList<>();
    }

    public Restoran(String namaTempat) {
        this.namaTempat = namaTempat;
        katalogMenu = new SortedMenuList();
        dataPelanggan = new ArrayList<>();
        riwayatOrder = new ArrayList<>();
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public SortedMenuList getKatalogMenu() {
        return katalogMenu;
    }

    public void tambahMenu(Menu m) {
        katalogMenu.insert(m);
    }

    public void tambahPelanggan(Pelanggan p) {
        if (p != null) {
            dataPelanggan.add(p);
        }
    }

    public Pelanggan cariPelanggan(String keyword) {
        for (Pelanggan p : dataPelanggan) {
            if (p.getId().equalsIgnoreCase(keyword) || p.getNamaLengkap().equalsIgnoreCase(keyword)) {
                return p;
            }
        }
        return null;
    }

    public boolean simpanPesanan(Pesanan order) {
        if (order == null || order.getItemDipesan().isEmpty()) {
            return false;
        }
        order.prosesBayar();
        riwayatOrder.add(order);
        return true;
    }

    public double omzetKotor() {
        double total = 0;
        for (Pesanan p : riwayatOrder) {
            total += p.totalBayar();
        }
        return total;
    }

    public double totalSubtotal() {
        double sub = 0;
        for (Pesanan p : riwayatOrder) {
            sub += p.subtotal();
        }
        return sub;
    }

    public double totalPajak() {
        return totalSubtotal() * 0.1;
    }

    public void cetakRingkasan() {
        double sub = totalSubtotal();
        double pajak = totalPajak();
        double total = omzetKotor();

        System.out.println("========================================");
        System.out.println("RINGKASAN " + namaTempat.toUpperCase());
        System.out.println("========================================");
        System.out.println("Jumlah Menu      : " + katalogMenu.size() + " item");
        System.out.println("Jumlah Pelanggan : " + dataPelanggan.size() + " orang");
        System.out.println("Jumlah Pesanan   : " + riwayatOrder.size() + " transaksi");
        System.out.println("Subtotal         : Rp" + (long) sub);
        System.out.println("Pajak (10%)      : Rp" + (long) pajak);
        System.out.println("Total Pendapatan : Rp" + (long) total);
        System.out.println("========================================");
    }}