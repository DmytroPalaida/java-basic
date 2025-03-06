package module_7.figures_exercise.main;

public class Circle extends Figure {

    private static final double PI = Math.PI;
    private final double x;
    private final double y;
    private final double radius;

    public Circle(Point point, double i) {
        super();
        this.x = point.getX();
        this.y = point.getY();
        this.radius = i;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return "(" + x + "," + y + ")";
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[(" + x + "," + y + ")" + radius + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(x - radius, y);
    }
}
