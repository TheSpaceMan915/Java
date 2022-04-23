package lab4.graph;
import java.util.*;

public class Graph {

    //final private Axis m_os_x;
    //final private Axis m_os_y;

    public static void main(String[] args) {

        //tabulate the function
        Func function_obj = (double x) -> x*x + 2;
        double start = 0.0, end = 5.6, stp = 0.1;
        SortedMap<Double,Double> coordinates_map = Tabulator.Tabulate(start,end,stp,function_obj);

        //create curves and axes
        Curve curve_obj = new Curve(coordinates_map);
        curve_obj.PrintInfo();
    }
}
