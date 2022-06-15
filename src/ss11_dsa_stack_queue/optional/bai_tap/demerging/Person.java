package ss11_dsa_stack_queue.optional.bai_tap.demerging;

import java.time.LocalDate;

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
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isMale() {
        return this.isMale;
    }

    public void setMale(boolean male) {
        this.isMale = male;
    }

    public String getGender() {
        return this.isMale ? "Male" : "Female";
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return "Person{fullName='" + this.fullName + '\'' + ", isMale=" + this.isMale + ", birthDate=" + this.birthDate + '}';
    }

    public int compareTo(Person o) {
        int diffGender = this.getGender().compareTo(o.getGender());
        return diffGender != 0 ? diffGender : this.getBirthDate().compareTo(o.getBirthDate());
    }
}
