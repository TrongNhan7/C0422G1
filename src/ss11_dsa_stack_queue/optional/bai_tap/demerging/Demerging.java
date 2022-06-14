package optional.bai_tap.demerging;

import java.time.LocalDate;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.time.LocalDate;

public class Demerging {
    public static void main(String[] args) {
        LinkedList<Person> listPeople = new LinkedList<>();
        listPeople.add(new Person("Thuy", false, LocalDate.of(2000, 5, 2)));
        listPeople.add(new Person("Huy", true, LocalDate.of(1994, 7, 7)));
        listPeople.add(new Person("Trung", true, LocalDate.of(2005, 1, 25)));
        listPeople.add(new Person("Hằng", false, LocalDate.of(1980, 6, 20)));
        for (Person x : listPeople) {
            System.out.println(x);
        }
        Collections.sort(listPeople);
        System.out.println("--------------------");
        for (Person x:listPeople){
            System.out.println(x);
        }

    }
}
