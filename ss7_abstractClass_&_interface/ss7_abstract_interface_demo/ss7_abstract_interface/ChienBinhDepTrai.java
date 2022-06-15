package ss7_abstract_interface;

public  class ChienBinhDepTrai extends ChienBinh implements Comparable<ChienBinhDepTrai>{
    private int doDepTrai;

    public ChienBinhDepTrai() {
    }

    public ChienBinhDepTrai(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int doDepTrai) {
        super(ten, tuoi, chieuCao, canNang, vuKhi);
        this.doDepTrai = doDepTrai;
    }

    @Override
    public void chienDau() {
        System.out.println("Chiến đấu bằng nam nhân kế");
    }

    @Override
    public String toString() {
        return "ChienBinhDepTrai{" +
                super.toString()+
                "doDepTrai=" + doDepTrai +
                '}';
    }


    @Override
    public int compareTo(ChienBinhDepTrai o) {
//        if (this.doDepTrai-o.doDepTrai==0){
//            return 0;
//        }else if (this.doDepTrai<o.doDepTrai){
//            return -1;
//        }else {
//            return 1;
//        }
//         so sanh độ đẹp trai
//        return o.doDepTrai-this.doDepTrai;
        // so sanh tên
        return o.getTen().compareTo(this.getTen());
    }
}
