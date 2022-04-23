package lab4.graph;

public class Axis {

    final private int m_x = 0;
    final private int m_y = 0;

    final private Asis_type m_type;

    public Axis(Asis_type type) {m_type = type; }

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
