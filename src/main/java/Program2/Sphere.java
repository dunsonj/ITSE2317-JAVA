package Program2;

public class Sphere extends ThreeDimensionalShape{
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return ((1.33333)* PI * radius * radius *radius);
    }

    @Override
    public String toString() {
        return String.format
                ("Shape:     %s%n" +
                                "%s%n" +
                                "Area:       %,.2f%n" +
                                "Volume:     %,.2f%n" +
                                "=====================",
                        this.getClass().getSimpleName(),
                        super.toString(),
                        getArea(), getVolume());
    }
}
