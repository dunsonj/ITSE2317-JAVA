package Program2;

public abstract class ThreeDimensionalShape extends Shape {
    public abstract double getArea();
    public abstract double getVolume();

    @Override
    public String toString() {
        return String.format("Dimension: Three-Dimensional");
    }
}