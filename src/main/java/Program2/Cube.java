package Program2;

public class Cube extends ThreeDimensionalShape{
    private final double edge;

    public Cube(double edge) {
        this.edge = edge;
    }


    @Override
    public double getArea() {
        return 6* edge * edge;
    }

    @Override
    public double getVolume() {
        return edge * edge * edge;
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
                        getArea(),getVolume());
    }
}
