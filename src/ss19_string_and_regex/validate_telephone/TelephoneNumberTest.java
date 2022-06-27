package ss19_string_and_regex.validate_telephone;

import ss19_string_and_regex.bai_tap.validate_class.ClassName;

public class TelephoneNumberTest {
    private static TelephoneNumber telephoneNumber;
    public static final String[] validTelephoneNumber = new String[]{"(84)-(0978489648)", "(25)-(0972397648)"};
    public static final String[] invalidTelephoneNumber = new String[]{"(84)-(097dsda648)", " (8a)-(0978489648)"};

    public static void main(String args[]) {
        telephoneNumber = new TelephoneNumber();
        for (String classname : validTelephoneNumber) {
            boolean isvalid = telephoneNumber.validate(classname);
            System.out.println("Telephone number is " + classname + " is valid: " + isvalid);
        }
        for (String classname : invalidTelephoneNumber) {
            boolean isvalid = telephoneNumber.validate(classname);
            System.out.println("Telephone number " + classname + " is valid: " + isvalid);
        }
    }
}
