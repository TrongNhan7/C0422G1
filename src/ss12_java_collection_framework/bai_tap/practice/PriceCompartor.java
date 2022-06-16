package ss12_java_collection_framework.bai_tap.practice;

import java.util.Comparator;

public class PriceCompartor implements Comparator<ss12_java_collection_framework.bai_tap.practice.Product> {
    @Override
    public int compare(ss12_java_collection_framework.bai_tap.practice.Product o1, ss12_java_collection_framework.bai_tap.practice.Product o2) {
        if (o1.getPriceProduct() > o2.getPriceProduct()) {
            return 1;
        } else if (o1.getPriceProduct() > o2.getPriceProduct()) {
            return 0;
        } else {
            return -1;
        }
    }

}
