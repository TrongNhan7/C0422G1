package Controller;

import model.Manufacture.Manufacture;

import java.util.ArrayList;
import java.util.List;

public class ManufactureController {
    static List<Manufacture> manufactures;

    // yeu cau du lieu cho san

    static {
        manufactures = new ArrayList<>();
        manufactures.add(new Manufacture("Mẹt", "Xot", "Germany"));
        manufactures.add(new Manufacture("KIA", "Xta", "KoreaFake"));
        manufactures.add(new Manufacture("Supercup", "Xma", "VietNam"));
    }

    public static void add(String name, String id, String nation) {
        manufactures.add(new Manufacture(name, id, nation));
    }
}
