import java.util.ArrayList;
import java.util.List;

public class SortedMenuList {
    private List<Menu> list;

    public SortedMenuList() {
        list = new ArrayList<>();
    }

    public void insert(Menu item) {
        if (item == null) {
            return;
        }
        int idx = 0;
        while (idx < list.size() && list.get(idx).getKode().compareToIgnoreCase(item.getKode()) < 0) {
            idx++;
        }
        list.add(idx, item);
    }

    public boolean remove(String kode) {
        if (kode == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKode().equalsIgnoreCase(kode.trim())) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public Menu search(String kode) {
        if (kode == null) {
            return null;
        }
        for (Menu m : list) {
            if (m.getKode().equalsIgnoreCase(kode.trim())) {
                return m;
            }
        }
        return null;
    }

    public Menu get(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void cetakList() {
        if (list.isEmpty()) {
            System.out.println("Daftar menu kosong.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).ringkasInfo());
        }
    }
}