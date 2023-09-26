package Program2;

public class Square extends TwoDimensionalShape{
    private final double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
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
