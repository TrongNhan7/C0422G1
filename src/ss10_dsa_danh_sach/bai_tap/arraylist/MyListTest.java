package ss10_dsa_danh_sach.bai_tap.arraylist;

import ss10_dsa_danh_sach.bai_tap.arraylist.Mylist;

public class MyListTest {
    public static void main(String[] args) {
        Mylist<Integer> listInteger = new Mylist<Integer>();
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(6);
        listInteger.add(3, 5);
        listInteger.remove(2);
        System.out.println(listInteger.cloneList());
        System.out.println(listInteger.get(2));
        listInteger.getInfo();
        System.out.println("\n" + listInteger.containsXInElement(7));
        System.out.println(listInteger.indexOf(3));
        listInteger.clearElements();
        listInteger.getInfo();
    }
}
