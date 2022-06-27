package ss19_string_and_regex.bai_tap.validate_class;

public class ClassNameTest {
    private static ClassName className;
    public static final String[] validClassName = new String[]{"C0318G", "A0856H", "P7892L"};
    public static final String[] invalidClassName = new String[]{" M0318G", "P0323A", "P0323A.1232"};

    public static void main(String args[]) {
        className = new ClassName();
        for (String classname : validClassName) {
            boolean isvalid = className.validate(classname);
            System.out.println("Class name is " + classname + " is valid: " + isvalid);
        }
        for (String classname : invalidClassName) {
            boolean isvalid = className.validate(classname);
            System.out.println("Class name is " + classname + " is valid: " + isvalid);
        }
    }
}
