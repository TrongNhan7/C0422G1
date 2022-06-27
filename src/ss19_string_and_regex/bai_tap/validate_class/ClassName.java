package ss19_string_and_regex.bai_tap.validate_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassName {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CLASS_NAME_REGEX="^[CAP][0-9]{4}[GHIKLM]$";
    public ClassName() {
        pattern = Pattern.compile(CLASS_NAME_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
