package lab4.graph;

public class Axis {

    final private int m_x;
    final private int m_y;

    final private Asis_type m_type;

    public Axis(int x, int y, Asis_type type) { m_x = x; m_y = y; m_type = type; }

    public void PrintInfo()
    {
        System.out.println("The axis of type " + m_type + " starts at the point (" + m_x + "," + m_y + ")");
    }

    public enum Asis_type {
        HORIZONTAL,VERTICAL
    }

    public static void main(String[] args) {

        Axis ax = new Axis(0,0,Asis_type.VERTICAL);
        ax.PrintInfo();
    }
}
