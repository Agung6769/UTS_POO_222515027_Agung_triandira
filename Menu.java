public class Menu {
    private String kode;
    private String nama;
    private double hargaSatuan;
    private boolean siapJual;

    public Menu() {
        kode = "MN00";
        nama = "Belum Ada Nama";
        hargaSatuan = 0;
        siapJual = true;
    }

    public Menu(String kode, String nama, double hargaSatuan, boolean siapJual) {
        this.kode = kode;
        this.nama = nama;
        setHargaSatuan(hargaSatuan);
        this.siapJual = siapJual;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        if (kode != null && !kode.trim().isEmpty()) {
            this.kode = kode.trim();
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama.trim();
        }
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        if (hargaSatuan >= 0) {
            this.hargaSatuan = hargaSatuan;
        }
    }

    public boolean isSiapJual() {
        return siapJual;
    }

    public void setSiapJual(boolean siapJual) {
        this.siapJual = siapJual;
    }

    public void toggleStatus() {
        this.siapJual = !this.siapJual;
    }

    public double hargaPlusPajak() {
        return hargaSatuan * 1.1;
    }

    public String ringkasInfo() {
        String labelStatus = siapJual ? "Ready" : "Habis";
        return kode + " | " + nama + " | Rp" + (long) hargaSatuan + " (" + labelStatus + ")";
    }
}