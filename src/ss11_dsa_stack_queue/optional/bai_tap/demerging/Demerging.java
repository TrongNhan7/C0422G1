package ss11_dsa_stack_queue.optional.bai_tap.demerging;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

public class Demerging {
    public Demerging() {
    }

    public static void main(String[] args) {
        LinkedList<Person> listPeople = new LinkedList();
        listPeople.add(new Person("Thuy", false, LocalDate.of(2000, 5, 2)));
        listPeople.add(new Person("Huy", true, LocalDate.of(1994, 7, 7)));
        listPeople.add(new Person("Trung", true, LocalDate.of(2005, 1, 25)));
        listPeople.add(new Person("Hằng", false, LocalDate.of(1980, 6, 20)));
        listPeople.add(new Person("My", false, LocalDate.of(1999, 6, 20)));
        listPeople.add(new Person("Nghia", true, LocalDate.of(1985, 9, 21)));
        listPeople.add(new Person("Phu", true, LocalDate.of(1975, 1, 15)));


        for (Person people : listPeople) {
            System.out.println(people);
        }

        Collections.sort(listPeople);
        System.out.println("--------------------");
        for (Person people : listPeople) {
            System.out.println(people);
        }

    }

}
