package optional.bai_tap.demerging;

import java.time.LocalDate;
import java.util.Date;


public class Person implements Comparable<Person> {
    private String fullName;
    private boolean isMale;
    private LocalDate birthDate;

    public Person() {

    }

    public Person(String fullName, boolean isMale, LocalDate birthDate) {
        this.fullName = fullName;
        this.isMale = isMale;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getGender() {
        return this.isMale ? "Male" : "Female";
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", isMale=" + isMale +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        int diffGender = this.getGender().compareTo(o.getGender());
        if (diffGender != 0) {
            return diffGender;
        } else {
           return this.getBirthDate().compareTo(o.getBirthDate());
        }
    }
}
