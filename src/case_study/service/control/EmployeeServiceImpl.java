package case_study.service.control;

import case_study.models.Person.Employee;
import case_study.service.IService.IEmployeeService;
import case_study.util.ReadAndWrite;
import case_study.util.Regex;
import case_study.util.TypeInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);

    private static final String PATH_FILE_EMPLOYEE = "src/case_study/data/Employee.csv";


    @Override

    public void display() {
        List<Employee> employeeList;
        employeeList = ReadAndWrite.readFileList(PATH_FILE_EMPLOYEE);
        for (Employee employee : employeeList) {
            System.out.printf(employee.toString() + "\n");
        }
    }

    @Override
    public void add() {
        List<Employee> employeeList = new ArrayList<>();
        System.out.printf("Nhập thông tin theo yêu cầu");
        System.out.println("\nNhập id nhân viên");
        int id = Integer.parseInt(Regex.inputNumber());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        String birthday = Regex.inputBirthday();
        String sex = TypeInformation.getTypeSex();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        String phone = Regex.inputPhone();
        System.out.println("Nhập Email");
        String email = Regex.inputMail();
        String level = TypeInformation.getTypeLevel();
        String position = positions();
        System.out.println("Nhập lương");
        double salary = Double.parseDouble(Regex.inputNumberDouble());

        Employee employee = new Employee(id, name, birthday, sex, idCard, phone, email, level, position, salary);
        employeeList.add(employee);
        ReadAndWrite.writeList(employeeList, PATH_FILE_EMPLOYEE, true);
        System.out.println("Đã thêm thành công");

    }

    @Override
    public void edit() {
        List<Employee> employeeList;
        employeeList = ReadAndWrite.readFileList(PATH_FILE_EMPLOYEE);
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(Regex.inputNumber());
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == inputId) {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi");
                String birthday = Regex.inputBirthday();
                String sex = TypeInformation.getTypeSex();
                System.out.println("Nhập chứng minh");
                String idCard = scanner.nextLine();
                String phone = Regex.inputPhone();
                String email = Regex.inputMail();
                String level = TypeInformation.getTypeLevel();
//                System.out.println("Nhập vị trí");
//                String position = scanner.nextLine();
                String position = positions();
                System.out.println("Nhập lương");
                double salary = Double.parseDouble(Regex.inputNumberDouble());
                employeeList.get(i).setName(name);
                employeeList.get(i).setBirthday(birthday);
                employeeList.get(i).setSex(sex);
                employeeList.get(i).setIdCard(idCard);
                employeeList.get(i).setPhone(phone);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setLevel(level);
                employeeList.get(i).setPosition(position);
                employeeList.get(i).setSalary(salary);
                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }

        ReadAndWrite.writeList(employeeList, PATH_FILE_EMPLOYEE, false);
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }

    public static String positions() {
        String temp = "";
        boolean check = true;
        do {
            System.out.println("Nhập vị trí");
            System.out.println("1. Lễ tân");
            System.out.println("2. phục vụ");
            System.out.println("3. chuyên viên");
            System.out.println("4. giám sát");
            System.out.println("5. quản lý");
            System.out.println("6 .giám đốc");
            System.out.println("Enter your choose");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    temp = "Lễ tân";
                    check = false;
                    break;
                case "2":
                    temp = "phục vụ";
                    check = false;
                    break;
                case "3":
                    temp = "chuyên viên";
                    check = false;
                    break;
                case "4":
                    temp = "giám sát";
                    check = false;
                    break;
                case "5":
                    temp = "quản lý";
                    check = false;
                    break;
                case "6":
                    temp = "giám đốc";
                    check = false;
                    break;
                default:
                    System.out.println("Bạn chọn không đúng thông tin, mời bạn chọn lại");
            }
        } while (check);

        return temp;
    }
}
