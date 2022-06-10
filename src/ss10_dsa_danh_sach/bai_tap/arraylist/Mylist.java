package ss10_dsa_danh_sach.bai_tap.arraylist;

import java.util.Arrays;

public class Mylist<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;

    public Mylist() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Mylist(int capacity) {
        size = capacity;
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        int newSize = getSizeOfList() + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public void add(int index, E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = getSizeOfList() - 2; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = e;
    }

    public E remove(int index) {
        E e = (E) elements[index];
        for (int i = index; i < getSizeOfList() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[getSizeOfList() - 1] = null;
        return e;
    }

    public int getSizeOfList() {
        return elements.length;
    }

    public E cloneList() {
        return (E) elements.clone();
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public boolean containsXInElement(Object x) {
        for (Object o : elements) {
            if (o == x) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < getSizeOfList(); i++) {
            if ((E) elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean addObjectNotDuplicate(E e) {
        for (Object o : elements) {
            if ((E) o == e) {
                System.out.printf("%s is duplicate", o);
                return false;
            }
        }
        return true;
    }

    public void clearElements(){
        elements = new Object[0];
    }

    public void getInfo() {
        for (Object o : elements) {
            if (o == null) {
                System.out.print("empty ");
            } else {
                System.out.print(o + " ");
            }
        }
    }

}
