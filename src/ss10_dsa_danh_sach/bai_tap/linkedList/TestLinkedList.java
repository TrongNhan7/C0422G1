package ss10_dsa_danh_sach.bai_tap.linkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<Student>();
        Student student1 = new Student(1, "a");
        Student student2 = new Student(2, "b");
        Student student3 = new Student(3, "c");
        Student student4 = new Student(4, "d");

        myLinkedList.addFirst(student1);
        myLinkedList.add(1,student2);
        myLinkedList.add(2,student3);
        myLinkedList.addLast(student4);
        myLinkedList.remove(0);
        myLinkedList.remove(student3);

        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
