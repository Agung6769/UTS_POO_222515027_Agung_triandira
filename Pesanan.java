import java.util.ArrayList;
import java.util.List;

public class Pesanan {
    private String kodeOrder;
    private Pelanggan pembeli;
    private List<Menu> itemDipesan;
    private boolean lunas;

    public Pesanan() {
        kodeOrder = "ORD00";
        pembeli = new Pelanggan();
        itemDipesan = new ArrayList<>();
        lunas = false;
    }

    public Pesanan(String kodeOrder, Pelanggan pembeli) {
        this.kodeOrder = kodeOrder;
        this.pembeli = pembeli;
        this.itemDipesan = new ArrayList<>();
        this.lunas = false;
    }

    public String getKodeOrder() {
        return kodeOrder;
    }

    public Pelanggan getPembeli() {
        return pembeli;
    }

    public List<Menu> getItemDipesan() {
        return itemDipesan;
    }

    public boolean isLunas() {
        return lunas;
    }

    public boolean masukkanItem(Menu item) {
        if (item == null || !item.isSiapJual()) {
            return false;
        }
        itemDipesan.add(item);
        return true;
    }

    public double subtotal() {
        double sum = 0;
        for (Menu item : itemDipesan) {
            sum += item.getHargaSatuan();
        }
        return sum;
    }

    public double totalBayar() {
        if (itemDipesan.isEmpty()) {
            return 0;
        }
        return subtotal() * 1.1;
    }

    public boolean prosesBayar() {
        if (itemDipesan.isEmpty()) {
            return false;
        }
        lunas = true;
        if (pembeli != null) {
            pembeli.tambahPoin((int) (totalBayar() / 10000));
        }
        return true;
    }
}