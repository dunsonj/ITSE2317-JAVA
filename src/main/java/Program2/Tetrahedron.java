package Program2;

public class Tetrahedron extends ThreeDimensionalShape{
    private final double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3)  * edge * edge;
    }

    @Override
    public double getVolume() {
        return   (Math.sqrt(2) / 12.0) * ( edge * edge * edge) ;
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
