package lab4.graph;
import java.util.*;

//platumln  for building UML
public class Graph {

    private ArrayList<Axis> m_arr_axis;

    private ArrayList<Curve> m_arr_curves;

    private Legend m_legend;

    private Grid m_grid;

    public Graph()
    {
        m_arr_axis = new ArrayList<>();
        m_arr_curves = new ArrayList<>();
        m_legend = new Legend();
        m_grid = new Grid();
    }

    public void PrintTemplateGraph()                    //show a template of the graph
    {
        for (Axis os: m_arr_axis)
        { os.PrintAsis(); }
        m_grid.SetVisibility(true);
        m_grid.PrintGrid();
    }

    public void AddCurve(double start, double end, double stp, Func function_obj)
    {
        SortedMap<Double,Double> coordinates_map = Tabulator.Tabulate(start,end,stp,function_obj);
        Curve temp_curve = new Curve(coordinates_map);
        m_arr_curves.add(temp_curve);
        m_legend.AddFuncColour();                       //add the colour of the function to the legend
        temp_curve.PrintCurve();                        //show a curve
    }
    public void ShowGrid(boolean flag) { m_grid.SetVisibility(flag); }

    public void AddAxis(int x, int y, Axis.Asis_type type)
    {
        Axis temp = new Axis(x,y,type);

        m_arr_axis.add(temp);
    }

    public static void main(String[] args) {

        //tabulate the function
        Func function_obj = (double x) -> x*x + 2;
        Func function_obj2 = x -> Math.sin(x)/Math.cos(x);
        double start_x = 1.2, end_x = 5.6, stp_x = 0.3;

        //create a grid
        Graph graph_obj = new Graph();
        graph_obj.AddAxis(0,0, Axis.Asis_type.VERTICAL);
        graph_obj.AddAxis(0,0, Axis.Asis_type.HORIZONTAL);
        graph_obj.PrintTemplateGraph();

        //add two curves to the grid
        graph_obj.AddCurve(start_x,end_x,stp_x,function_obj);
        graph_obj.AddCurve(start_x,end_x,stp_x,function_obj2);

    }
}
