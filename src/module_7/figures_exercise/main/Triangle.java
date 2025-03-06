package module_7.figures_exercise.main;

public class Triangle extends Figure {
    private final double x;
    private final double x1;
    private final double x2;
    private final double y;
    private final double y1;
    private final double y2;

    public Triangle(Point point, Point point1, Point point2) {
        super();
        this.x = point.getX();
        this.x1 = point1.getX();
        this.x2 = point2.getX();
        this.y = point.getY();
        this.y1 = point1.getY();
        this.y2 = point2.getY();
    }

    @Override
    public double area() {
        return 0.5 * Math.abs((x * y1) - (x1 * y) + (x1 * y2)
                - (x2 * y1) + (x2 * y) - (x * y2));
    }

    @Override
    public String pointsToString() {
        return "(" + x + "," + y + ")(" + x1 + "," + y1 + ")(" + x2 + "," + y2 + ")";
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[(" + x + "," + y + ")(" + x1 + "," + y1 +
                ")(" + x2 + "," + y2 + ")]";
    }

    @Override
    public Point leftmostPoint() {
        double minX = Math.min(x, Math.min(x1, x2));

        if (minX == x) {
            return new Point(x, y);
        } else if (minX == x1) {
            return new Point(x1, y1);
        } else {
            return new Point(x2, y2);
        }
    }
}
