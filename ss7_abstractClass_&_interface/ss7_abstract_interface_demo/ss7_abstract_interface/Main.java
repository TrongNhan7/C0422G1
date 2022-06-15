package ss7_abstract_interface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        dietRong();
        //  thiSacDep();
    }

    public static void dietRong() {
        // khởi tạo vua
        Vua vua = new Vua();
        // vua ra lênh
        vua.raLenh("Họp triều định");
        ChienBinhDepTrai chienBinhDepTrai = new ChienBinhDepTrai("Huy", 20, 1.9f, 75, "miệng", 10);
        ChienBinhThongThai chienBinhThongThai = new ChienBinhThongThai("Trung", 18, 1.70f, 60, "Quạt", 10);
        ChienBinhAnhDung chienBinhAnhDung = new ChienBinhAnhDung("Phi Hùng", 20, 1.8f, 70, "Kiếm", 100);
        vua.raLenh("Chiến binh đẹp trai đi chiến đầu");
        chienBinhDepTrai.lamNhiemVu("Diệt rông");
        chienBinhDepTrai.chienDau();
        // thất bại trở về
        vua.raLenh("Chiến binh đẹp trai đi chơi với công chúa");
        vua.raLenh("Chiến bin thông thái đi diệt rông");
        chienBinhThongThai.lamNhiemVu("Diệt rông");
        chienBinhThongThai.hoMuaGoiGio();
        chienBinhThongThai.chienDau();
        // vẫn thất bại
        // vua ra lệnh cho chiến binh anh dung
        vua.raLenh("chiến binh anh dung diệt rộng");
        chienBinhAnhDung.lamNhiemVu("diêt rồng");
        chienBinhAnhDung.hoMuaGoiGio();
        chienBinhAnhDung.luyenCong();
        chienBinhAnhDung.chienDau();
        System.out.println(chienBinhDepTrai.toString());
        // diệt được rồng


    }


    public static void thiSacDep() {
//        // danh sách thi sắc đẹp
        ChienBinhDepTrai[] chienBinhDepTrais = new ChienBinhDepTrai[5];
        chienBinhDepTrais[0] = new ChienBinhDepTrai("Sơn", 18, 1.8f, 70, "Son", 10);
        chienBinhDepTrais[1] = new ChienBinhDepTrai("Minh", 25, 1.8f, 70, "Son", 8);
        chienBinhDepTrais[2] = new ChienBinhDepTrai("Hai", 18, 1.8f, 70, "Son", 9);
        chienBinhDepTrais[3] = new ChienBinhDepTrai("Tiến", 18, 1.8f, 70, "Son", 8);
        chienBinhDepTrais[4] = new ChienBinhDepTrai("Trung", 18, 1.8f, 70, "Son", 6);
        //danh sách
        System.out.println("danh sách -----------------------------------");
        for (ChienBinhDepTrai c : chienBinhDepTrais) {
            System.out.println(c);
        }
        // sắp xếp
        Arrays.sort(chienBinhDepTrais);
//         kết quả
        System.out.println("Kết quả-------------------------------------");
        for (ChienBinhDepTrai c : chienBinhDepTrais) {
            System.out.println(c);
        }

    }
}
