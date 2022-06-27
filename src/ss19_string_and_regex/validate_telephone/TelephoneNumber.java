package ss19_string_and_regex.validate_telephone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneNumber {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String TELEPHONE_NUM_REGEX="^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public TelephoneNumber() {
        pattern = Pattern.compile(TELEPHONE_NUM_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
