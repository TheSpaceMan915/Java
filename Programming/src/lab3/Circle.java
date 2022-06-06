package lab3;
import java.util.Scanner;

//#4____________________________________________
public class Circle {

    private int m_x;
    private int m_y;
    private int m_R;

    public int GetX() {return m_x;}
    public int GetY() {return m_y;}
    public int GetR() {return m_R;}

    public Circle(int x,int y,int R) {m_x = x; m_y = y; m_R = R;}

    public int FindIfCross(Circle obj2)
    {
        int x2 = obj2.GetX();
        int y2 = obj2.GetY();
        int R2 = obj2.GetR();

        double dis = Math.sqrt((x2-m_x)*(x2-m_x)+(y2- m_y)*(y2- m_y));
        int res = 0;

        if ((Math.abs(m_R - R2) < dis) && (m_R + R2 > dis))
            {res = 1;}                //окружности пересекаются в двух точках

        else if (m_R + R2 < dis)       //окружности не пересекаются, располагаются одна вне другой
            {res = 2;}

        else if (m_R + R2 == dis)     //окружности соприкасаются в одной точке извне
            {res = 3;}

        else if (Math.abs(m_R - R2) == dis)   //окружности соприкасаются в одной точке (но одна вложена в другую)
        {
            if (m_R > R2)
                {res = 4;}      //окружность с радиусом R2 вложена
            else
                {res = 5;}      //окружность с радиусом R вложена
        }

        else                  //одна окружность лежит внутри другой не касаясь другой
        {
            if (m_R > R2)
                {res = 6;}      //окружность с радиусом R2 вложена (Вторая окружность вложена в первую)
            else
                {res = 7;}      //окружность с радиусом R вложена  (Первая окружность вложена во вторую)
        }

        return res;
    }

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int x1,x2,y1,y2,R1,R2;

        //using keyboard input
        /*System.out.println("Enter x1:");
        x1 = keyboard.nextInt();
        System.out.println("Enter x2:");
        x2 = keyboard.nextInt();
        System.out.println("Enter y1:");
        y1 = keyboard.nextInt();
        System.out.println("Enter y2:");
        y2 = keyboard.nextInt();
        System.out.println("Enter R1:");
        R1 = keyboard.nextInt();
        System.out.println("Enter R2:");
        R2 = keyboard.nextInt();*/

        Circle obj1 = new Circle(0,3,2);
        Circle obj2 = new Circle(4,3,2);

        int number = obj1.FindIfCross(obj2);
        //System.out.println(number);

        //works like a function and returns a string
        String switcher = switch(number) {

            case 1 -> "Окружности имеют 2 точки пересечения";
            case 2 -> "Окружности не пересекаются, располагаются одна вне другой";
            case 3 -> "Окружности соприкасаются в одной точке извне";
            case 4 -> "Окружности соприкасаются в одной точке (Вторая окружность вложена в первую)";
            case 5 -> "Окружности соприкасаются в одной точке (Первая окружность вложена во вторую)";
            case 6 -> "Вторая окружность вложена в первую";
            case 7 -> "Первая окружность вложена во вторую";
            default -> "Exception";
        };
        System.out.println(switcher);
    }
}
