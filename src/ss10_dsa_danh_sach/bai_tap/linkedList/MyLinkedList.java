package ss10_dsa_danh_sach.bai_tap.linkedList;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;

    public MyLinkedList() {
        this.numNodes = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(E element) {
        // Khai báo 1 biến là temp trỏ đến giá trị của head
        Node temp = head;
        // Biến head  sẽ nhận giá trị là 1 node mới
        head = new Node(element);
        //head.next trỏ đến temp
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        // Khai báo biến temp trỏ đến head
        Node temp = head;
        //Cho con trỏ chạy đến phần tử cuối cùng = null
        while (temp.next != null) {
            temp = temp.next;
        }
        // Cho con trỏ trỏ vào vùng nhớ của node mới
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        /* Node newNode = new Node(element);
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            if (count == index) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        numNodes++;
    }
      */

        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        // Cho holder tham chiếu tới vị trí index
        holder = temp.next;
        //node tại vị trí index-1 sẽ trỏ tới node mới
        temp.next = new Node(element);
        //node mới sẽ trỏ tới holder
        temp.next.next = holder;
        numNodes++;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public E remove(int index) {
        Node temp = head;
        Object data;
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index ");
        }
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            // data tại vị trí index
            data = temp.next.data;
            // Trỏ thẳng từ vị trí index-1 đến index+1
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove(E element) {
        // remove đối tượng nếu element là head
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }
}
