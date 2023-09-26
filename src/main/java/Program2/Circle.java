package Program2;

public class Circle extends TwoDimensionalShape{
private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius ;
    }

    @Override
    public String toString() {
        return String.format
                ("Shape:     %s%n" +
                                "%s%n" +
                                "Area:       %,.2f%n" +
                                "=====================",
                        this.getClass().getSimpleName(),
                        super.toString(),
                        getArea());
    }
}
