public class Pelanggan {
    private String id;
    private String namaLengkap;
    private String kontak;
    private int poinMember;

    public Pelanggan() {
        id = "PL00";
        namaLengkap = "Guest";
        kontak = "-";
        poinMember = 0;
    }

    public Pelanggan(String id, String namaLengkap, String kontak, int poinMember) {
        this.id = id;
        this.namaLengkap = namaLengkap;
        this.kontak = kontak;
        setPoinMember(poinMember);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id.trim();
        }
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        if (namaLengkap != null && !namaLengkap.trim().isEmpty()) {
            this.namaLengkap = namaLengkap.trim();
        }
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        if (kontak != null && !kontak.trim().isEmpty()) {
            this.kontak = kontak.trim();
        }
    }

    public int getPoinMember() {
        return poinMember;
    }

    public void setPoinMember(int poinMember) {
        if (poinMember >= 0) {
            this.poinMember = poinMember;
        }
    }

    public void tambahPoin(int jumlah) {
        if (jumlah > 0) {
            poinMember += jumlah;
        }
    }

    public boolean pakaiPoin(int jumlah) {
        if (jumlah > 0 && poinMember >= jumlah) {
            poinMember -= jumlah;
            return true;
        }
        return false;
    }

    public void cetakData() {
        System.out.println(id + " - " + namaLengkap + " (" + kontak + ") | Poin: " + poinMember);
    }
}