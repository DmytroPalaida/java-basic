package module_7.figures_exercise.task;


import module_7.figures_exercise.main.Circle;
import module_7.figures_exercise.main.Point;
import module_7.figures_exercise.main.Quadrilateral;
import module_7.figures_exercise.main.Triangle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double area;

        area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
        System.out.println(area);

        area = new Quadrilateral(new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 1)).area();
        System.out.println(area);

        area = new Circle(new Point(1,1), 3).area();
        System.out.println(area);

    }
}
//new Point(1, 1)