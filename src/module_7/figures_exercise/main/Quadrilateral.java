package module_7.figures_exercise.main;

public class Quadrilateral extends Figure {
    private final double x;
    private final double x1;
    private final double x2;
    private final double x3;
    private final double y;
    private final double y1;
    private final double y2;
    private final double y3;

    public Quadrilateral(Point point, Point point1, Point point2, Point point3) {
        super();
        this.x = point.getX();
        this.x1 = point1.getX();
        this.x2 = point2.getX();
        this.x3 = point3.getX();
        this.y = point.getY();
        this.y1 = point1.getY();
        this.y2 = point2.getY();
        this.y3 = point3.getY();
    }

    //Формула площі Гаусса
    @Override
    public double area() {
        return 0.5 * Math.abs(x * y1 + x1 * y2 + x2 * y3 + x3 * y - x1 * y
                - x2 * y1 - x3 * y2 - x * y3);

    }

    @Override
    public String pointsToString() {
        return "(" + x + "," + y + ")(" + x1 + "," + y1 +
                ")(" + x2 + "," + y2 + ")(" + x3 + "," + y3 + ")";
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[(" + x + "," + y + ")(" + x1 + "," + y1 +
                ")(" + x2 + "," + y2 + ")(" + x3 + "," + y3 + ")]";
    }

    @Override
    public Point leftmostPoint() {
        double minX = Math.min(Math.min(x, x1), Math.min(x2, x3));

        if (minX == x) {
            return new Point(x, y);
        }
        if (minX == x1) {
            return new Point(x1, y1);
        }
        if (minX == x2) {
            return new Point(x2, y2);
        }
        return new Point(x3, y3);
    }

}
