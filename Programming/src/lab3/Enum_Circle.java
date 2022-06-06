package lab3;
import java.util.Scanner;

//#4____________________________________________
public class Enum_Circle {

    private int m_x;
    private int m_y;
    private int m_R;

    public int GetX() {return m_x;}
    public int GetY() {return m_y;}
    public int GetR() {return m_R;}

    public Enum_Circle(int x, int y, int R) {m_x = x; m_y = y; m_R = R;}

    public enum Case {
        Touch_In_Two_Places, Do_Not_Cross, One_Touch, Touch_The_Second_Circle_In_The_First,
        Touch_The_First_Circle_In_The_Second, Do_Not_Touch_The_Second_Circle_In_The_First,
        Do_Not_Touch_The_First_Circle_In_The_Second
    }

    public Case FindIfCross(Enum_Circle obj2)
    {
        int x2 = obj2.GetX();
        int y2 = obj2.GetY();
        int R2 = obj2.GetR();

        double dis = Math.sqrt((x2-m_x)*(x2-m_x)+(y2- m_y)*(y2- m_y));
        Case res;

        if ((Math.abs(m_R - R2) < dis) && (m_R + R2 > dis))
            {res = Case.Touch_In_Two_Places;}                  //CASE1 - окружности пересекаются в двух точках

        else if (m_R + R2 < dis)       //CASE2 - окружности не пересекаются, располагаются одна вне другой
            {res = Case.Do_Not_Cross;}

        else if (m_R + R2 == dis)     //CASE3 - окружности соприкасаются в одной точке извне
            {res = Case.One_Touch;}

        else if (Math.abs(m_R - R2) == dis)   //окружности соприкасаются в одной точке (но одна вложена в другую)
        {
            if (m_R > R2)
                {res = Case.Touch_The_Second_Circle_In_The_First;}      //CASE4 - окружность с радиусом R2 вложена
            else
                {res = Case.Touch_The_First_Circle_In_The_Second;}      //CASE5 - окружность с радиусом R вложена
        }

        else                  //одна окружность лежит внутри другой не касаясь другой
        {
            if (m_R > R2)
                {res = Case.Do_Not_Touch_The_Second_Circle_In_The_First;}      // CASE6 - окружность с радиусом R2 вложена (Вторая окружность вложена в первую)
            else
                {res = Case.Do_Not_Touch_The_First_Circle_In_The_Second;}      //CASE7 - окружность с радиусом R вложена  (Первая окружность вложена во вторую)
        }

        return res;
    }

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int x1,x2,y1,y2,R1,R2;

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

        Enum_Circle obj1 = new Enum_Circle(0,3,2);
        Enum_Circle obj2 = new Enum_Circle(4,3,2);

        Case case_obj = obj1.FindIfCross(obj2);
        //System.out.println(case_obj);

        //works like a function and returns a string
        String switcher = switch(case_obj) {

            case Touch_In_Two_Places -> "Окружности имеют 2 точки пересечения";
            case Do_Not_Cross -> "Окружности не пересекаются, располагаются одна вне другой";
            case One_Touch -> "Окружности соприкасаются в одной точке извне";
            case Touch_The_Second_Circle_In_The_First -> "Окружности соприкасаются в одной точке (Вторая окружность вложена в первую)";
            case Touch_The_First_Circle_In_The_Second -> "Окружности соприкасаются в одной точке (Первая окружность вложена во вторую)";
            case Do_Not_Touch_The_Second_Circle_In_The_First -> "Вторая окружность вложена в первую";
            case Do_Not_Touch_The_First_Circle_In_The_Second -> "Первая окружность вложена во вторую";
            default -> "Exception";
        };
        System.out.println(switcher);
    }
}
