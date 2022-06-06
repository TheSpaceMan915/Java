package lab4.graph;

public class Axis {
    private int m_x;
    private int m_y;

    /*private static double min_x = Double.MAX_VALUE;

    private static double min_y = Double.MAX_VALUE;

    private static double max_x = Double.MIN_VALUE;

    private static double max_y = Double.MIN_VALUE;*/

    final private Asis_type m_type;

    public Axis(int x,int y,Asis_type type)
    {
        m_type = type;
        m_x = x;
        m_y = y;
    }

    public void PrintAsis()
    {
        System.out.println("The axis of type " + m_type + " starts at the point (" + m_x + "," + m_y + ")");
    }

    public enum Asis_type {
        HORIZONTAL,VERTICAL
    }

    public static void main(String[] args) {

        
    }
}
