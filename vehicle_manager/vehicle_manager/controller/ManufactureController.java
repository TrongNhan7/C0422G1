package vehicle_manager.controller;

import vehicle_manager.models.Manufacturer.Manufacture;

import java.util.ArrayList;
import java.util.List;

public class ManufactureController {
    static List<Manufacture> manufactures;

    // yeu cau du lieu cho san

    static {
        manufactures = new ArrayList<>();
        manufactures.add(new Manufacture("SSG-144", "Samsung", "Japan"));
        manufactures.add(new Manufacture("KIA-144", "Kia", "Korea"));
        manufactures.add(new Manufacture("THC-144", "Thaco", "VietNam"));
    }

   public static Manufacture searchByName(String name) {
        return manufactures.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static String getAllNameManufacturer() {
        StringBuilder str = new StringBuilder();
        str.append("All Manufacturer: ");
        for (Manufacture manufacture : manufactures) {
            str.append(manufacture.getName().toUpperCase()).append(". ");
        }
        return str.toString();
    }

    public static String getNation(String name) {
        return searchByName(name).getNation();
    }

   public static String getProductId(String name) {
        return searchByName(name).getProductId();
    }
}
