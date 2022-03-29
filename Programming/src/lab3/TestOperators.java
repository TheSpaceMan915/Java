package lab3;

import java.util.concurrent.ThreadLocalRandom;

//показал первые 3 задания

public class TestOperators
{

    interface FuncInterface                 //an interface to use lambda expression
    {
        double CalcFunc(double value);
    }

    //#1______________________________________________
    public static void Tabulate(double x_start,double x_end,double step,FuncInterface obj)
    {

        System.out.println("-------------------------------");
        System.out.printf("%10.5s %15.7s","x","f(x)" + '\n');
        System.out.println("-------------------------------");
        double x = x_start;
        double res = 0.0;

        while (x <= x_end)
        {
            res = obj.CalcFunc(x);
            System.out.printf("%10.5f %15.7e",x,res);
            System.out.println();
            x += step;
        }
        System.out.println();
    }

    //#2__________________________________________________
    public static int[][] CreateRandom2DArray()
    {
        final int min = 2, max = 10;
        int row_numb = ThreadLocalRandom.current().nextInt(min,max +1);   //create a random number of rows
        int arr2D[][] = new int[row_numb][];

        final int min_elem_num = 1,max_elem_num = 10;   //min/max number of elements in a row
        final int min_elem = -20,max_elem = 20;     //max and min of elements
        for (int i = 0; i < row_numb; i++)
        {
            int elem_num = ThreadLocalRandom.current().nextInt(min_elem_num,max_elem_num +1);
            arr2D[i] = new int[elem_num];   //create a raw with a random number of elements

            for (int j = 0; j < arr2D[i].length; j++)
            {
                arr2D[i][j] = ThreadLocalRandom.current().nextInt(min_elem,max_elem +1);
            }
        }
        return arr2D;
    }

    public static int FindMaxNegativeElem(int[][] arr2D)
    {
        int max_negative = Integer.MIN_VALUE;

        for (int i=0; i< arr2D.length;i++)
        {
            for (int j=0;j < arr2D[i].length;j++)
            {
                if (arr2D[i][j] < 0)
                {
                    if (arr2D[i][j] > max_negative)
                    {max_negative = arr2D[i][j];}
                }
            }
        }

        return max_negative;
    }

    //#3______________________________________________
   public static void Print2DArray(int[][] obj)
    {
        for (int s=0;s< obj.length;s++)
        {
            for (int c=0;c<obj[s].length;c++)
            {
                System.out.print(obj[s][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] BubbleSort(int[][] arr)
    {
        int temp = 0;
        boolean flag = false;

        for (int j = 0; j<arr.length; j++)
        {
            int i = arr[j].length - 1;
            while (i > 0)
            {
                int k = 0;
                while (k < i)
                {
                    if (arr[j][k] > arr[j][k + 1])
                    {
                        temp = arr[j][k];
                        arr[j][k] = arr[j][k + 1];
                        arr[j][k+1] = temp;
                        flag = true;
                    }
                    k++;
                }
                if (flag == false)          //Iverson's condition
                {break;}
                i--;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        FuncInterface func1 = (double x) -> Math.sin(x);            //the lambda expressions
        FuncInterface func2 = x -> Math.exp(x)/x * Math.log10(x);
        //FunctionalInterface obj;        could use this one too

        System.out.println("№1");
        System.out.println("Tabulation of sin(x)");
        Tabulate(Math.PI,15*Math.PI,Math.PI/15,func1);

        System.out.println("Tabulation of exp(x)/x * Lg(x)");
        Tabulate(Math.PI,15*Math.PI,Math.PI/15,func2);

        int arr2D[][] = {{4,3,9},{5,2,7},{10,20,1}};
        Print2DArray(arr2D);
        BubbleSort(arr2D);
        Print2DArray(arr2D);

        int[][] random_2D_arr = CreateRandom2DArray();
        Print2DArray(random_2D_arr);

        int max_elem = FindMaxNegativeElem(random_2D_arr);

        if (max_elem != Integer.MIN_VALUE)
            System.out.println("The max negative elem is " + max_elem);
        else
            System.out.println("There are no negative elements");
    }
}
