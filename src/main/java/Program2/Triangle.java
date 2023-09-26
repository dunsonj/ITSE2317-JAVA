package Program2;

public class Triangle extends TwoDimensionalShape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return ((0.5)* base * height);
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
