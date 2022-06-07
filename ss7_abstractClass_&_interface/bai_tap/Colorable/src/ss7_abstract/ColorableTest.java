package ss7_abstract;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2.0, "yellow", false);
        shapes[1] = new Rectangle(3.0, 5.0, "infinity", true);
        shapes[2] = new Square(4.5, "black", true);
        for (Shape a : shapes) {
            System.out.println(a + "\nArea = "+a.getArea());
            if(a instanceof Square){
                Colorable colorable = (Square) a;
                colorable.howToColor();
            }
        }

    }
}
