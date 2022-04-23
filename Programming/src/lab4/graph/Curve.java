package lab4.graph;
import java.util.*;

public class Curve {

    private final SortedMap<Double,Double> m_points;

    public Curve(SortedMap<Double,Double> points) { m_points = points; }

    public void PrintCurve()
    {
        double length = m_points.lastKey() - m_points.firstKey();
        System.out.println("The length of the curve is " + length);
    }
}
