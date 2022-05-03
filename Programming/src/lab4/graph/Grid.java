package lab4.graph;

public class Grid {

    private final double m_interval_x = 10.0;

    private final double m_interval_y = 5.0;

    private boolean m_visibility_flag;

    public void PrintGrid()
    {
        System.out.println("The intervals between grids are ox: " + m_interval_x + " and oy: " + m_interval_y);
    }

    public void SetVisibility(boolean visibility_flag) { m_visibility_flag=visibility_flag; }
}
