package lab4.graph;
import java.util.*;

public class Tabulator {

    public static SortedMap<Double,Double> Tabulate(double x_start, double x_end, double step, Func obj)
    {
        SortedMap<Double,Double> res_map = new TreeMap<>();

        double x = x_start;
        double res = 0.0;

        while (x <= x_end)
        {
            res = obj.CalcFunc(x);
            res_map.put(x,res);         //add an entry to the map
            x += step;
        }
        return res_map;
    }
}
