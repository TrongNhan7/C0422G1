package ss5_static_access_modifer;

import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    static int size = 0;
    static Student[] students = new Student[100];

    static {
        students[0] = new Student(1, "chanh", "QN", true, "chanhtv");
        students[1] = new Student(2, "trung", "QN", true, "trungtv");
        students[2] = new Student(3, "cong", "QN", true, "congtv");
        size = 3;
    }

    // CRUD
    public void display() {
        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
            } else {
                break;
            }

        }
    }

    public void add() {
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("nhập giới tính");
        boolean gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("nhập giới email");
        String email = scanner.nextLine();
        Student student = new Student(id, name, address, gender, email);
                students[size] = student;
                size++;

    }

    public void search() {
        System.out.print("Nhập tên học sinh muốn tìm: ");
        String findName = scanner.nextLine();
        int index;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(findName)) {
                index = i;
                System.out.println("Học sinh cần tìm ở vị trí thứ: " + (i + 1));
                System.out.println(students[i].toString());
                break;
            }
        }
    }

    public void deleteStudent() {
        System.out.println("Nhập ID học sinh muốn xóa: ");
        int id = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                index = i;
                System.out.println("Học sinh cần tìm ở vị trí thứ: " + (index + 1));
                System.out.println(students[i].toString());
                break;
            }
        }
        for (int i = index; i < size; i++) {
            students[i] = students[i + 1];
        }
        students[size - 1] = null;
        size--;
        System.out.println(size);
    }

    public void fixStudent() {
        System.out.print("Nhập tên học sinh muốn tìm: ");
        String findName = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(findName)) {
                index = i;
                System.out.println(students[index] + "\nAfter fix: ");
                System.out.println("nhập id");
                students[index].setId(Integer.parseInt(scanner.nextLine()));
                System.out.println("nhập tên");
                students[index].setName(scanner.nextLine());
                System.out.println("nhập địa chỉ");
                students[index].setAddress(scanner.nextLine());
                System.out.println("nhập giới tính");
                students[index].setGender(Boolean.parseBoolean(scanner.nextLine()));
                System.out.println("nhập giới email");
                students[index].setEmail(scanner.nextLine());
                System.out.println(students[index].toString());
                break;
            }
        }

    }
}
