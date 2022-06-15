package ss7_abstract;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0, "yellow", false);
        shapes[1] = new Rectangle(3.0, 5.0, "infinity", true);
        shapes[2] = new Square(4.5, "black", true);
        for (Shape a : shapes) {
            System.out.println(a);
        }
        System.out.println("After Resize");
        for (Shape a : shapes) {
            a.resize(Math.random() * 100);
            System.out.println(a);
        }

    }
}
