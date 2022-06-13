public class Student {
    private String name = "John";
    private String classes = "Co2";
    Student(){
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void getR(){
        System.out.println("Name: " + name + "\nClass: " + classes);
    }
}
