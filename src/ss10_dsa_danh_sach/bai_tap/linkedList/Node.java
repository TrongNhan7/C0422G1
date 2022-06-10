package ss10_dsa_danh_sach.bai_tap.linkedList;

public class Node {
    public Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node tail) {
        this.data = data;
        this.next = tail;
    }


    public Object getData() {
        return this.data;
    }
}
