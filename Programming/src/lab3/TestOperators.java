package lab3;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //#6______________________________________________
   public class TabValue {
        public double m_x;              //point x
        public double m_value;          //f(x)

        public TabValue(double x,double value) {m_x = x; m_value = value;}
    }

    public ArrayList<TabValue> TabulateFunc(final double x_start, final double x_end, final int n_inter)
    {
        ArrayList<TabValue> values_arr = new ArrayList<>();
        double x = x_start;
        double res = 0;
        final double step = (x_end-x_start)/n_inter;
                                    //check if it works with negatives
        while (x <= x_end)
        {
            res = Math.exp(x) - x*x*x;                  //the function
            values_arr.add(new TabValue(x,res));
            x += step;
        }
        return values_arr;
    }

    public static double LeftRiemannSum(final double x_start, final double x_end,final ArrayList<TabValue> arr,final int dots_number)
    {
        double res =  0.0;
        int fractions_number = dots_number - 1;             //номер отрезков
        final double step = (x_end-x_start)/fractions_number;

        for (int i = 0; i < dots_number; i++)         //get through all except the last one
        {
            res += arr.get(i).m_value;
        }
        res *= step;

        return res;
    }

    public static double CheckIntegral()
    {
        double res = Math.exp(4) - 65;
        return res;
    }

    public static void PrintArrayList(final ArrayList<TabValue> arr)
    {
        System.out.println("-------------------------------");
        System.out.printf("%10.5s %15.7s","x","f(x)" + '\n');
        System.out.println("-------------------------------");
        for (TabValue temp : arr)
        {
            System.out.printf("%10.5f %15.7f",temp.m_x,temp.m_value);
            System.out.println();
        }
        System.out.println();
    }

    //#7______________________________________________
    public static StringBuilder ConvertToNumeralSystem(int value,int base)
    {
        StringBuilder str = new StringBuilder();
        int number = value;
        int remainder = 0;

        while (number != 0)
        {
            remainder = number % base;     //вычисляю остаток числа
            str.insert(0,remainder);
            number /= base;                //вычисляю целую часть числа
        }

        //str.reverse();
        return str;
    }

    //#8______________________________________________
    public static int HornerMethod(int[] arr, int x)
    {
        int res = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            res = res * x + arr[i];
        }
        return res;
    }

    //#9______________________________________________      using regex
    public static boolean CheckFederalNumber(String str)
    {
        Pattern patter_obj = Pattern.compile("((\\+7)|(8)\\s?[(]\\d{3}[)]\\s?\\d{7})|((\\+7)|(8)[-\\s]?\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2})");

       // Pattern patter_obj = Pattern.compile("(\\+7\\s?[(]\\d{3}[)]\\s?\\d{7})|(8\\s?[(]\\d{3}[)]\\s?\\d{7})|(\\+7[-\\s]?\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2})|(8[-\\s]?\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2})");
        Matcher matcher_obj = patter_obj.matcher(str);
        boolean res = matcher_obj.matches();

        return res;
    }

    public static boolean CheckRostovNumber(String str)
    {
        Pattern patter_obj = Pattern.compile("[23][\\s-]?\\d{2}[\\s-]?\\d{2}[\\s-]?\\d{2}[\\s-]?");
        Matcher matcher_obj = patter_obj.matcher(str);
        boolean res = matcher_obj.find();

        return res;
    }

    public static ArrayList<String> GetSubStr(String str)
    {
        Pattern patter_obj = Pattern.compile("([23][\\s-]?\\d{2}[\\s-]?\\d{2}[\\s-]?\\d{2}[\\s-]?)|((\\+7)|(8)\\s?[(]\\d{3}[)]\\s?\\d{7})|((\\+7)|(8)[-\\s]?\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2})");
        Matcher matcher_obj = patter_obj.matcher(str);
        ArrayList<String> arr_str = new ArrayList<>();
        int beginning = 0, end = 0;
        String temp_str = "";

        while (matcher_obj.find())
        {
            beginning = matcher_obj.start();
            end = matcher_obj.end();
            temp_str = str.substring(beginning,end);
            arr_str.add(temp_str);
        }
        return arr_str;
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

        //#6______________________________________________
        //using keyboard input
       /* Scanner keybord = new Scanner(System.in);
        final double start = keybord.nextDouble();
        final double end = keybord.nextDouble();*/

        double start =0 ,end = 4;
        TestOperators test_obj = new TestOperators();
        final int intervals_number = 100;
        ArrayList<TabValue> arr_obj =test_obj.TabulateFunc(start,end,intervals_number);
        PrintArrayList(arr_obj);
        double aprox_res = LeftRiemannSum(start,end,arr_obj,intervals_number);
        System.out.println("Aprox res is " + aprox_res);
        double checking = CheckIntegral();
        System.out.println("The exact value of the integral is " + checking);

        //#7______________________________________________
        int converting_value = 348;
        int numeral_system = 3;
        StringBuilder result_str = ConvertToNumeralSystem(converting_value,numeral_system);
        System.out.println("The number: " + converting_value +" in numeral system: " + numeral_system+ " is " + result_str);
        System.out.println("Checking: " + Integer.toString(converting_value,numeral_system));

        //#8______________________________________________
       //using keyboard input
       /* System.out.println("How many elements would you like to have in the array?");
        final int arr_size = keybord.nextInt();
        int[] cof_arr2 = new int[arr_size];
        System.out.println("Enter your elements");
        for (var ref : cof_arr2)
        {
            ref = keybord.nextInt();
        }*/

        int[] cof_arr = {2,-3,1,-2,3};
        int x_number = 2;
        int res_value = HornerMethod(cof_arr,x_number);
        System.out.println("The result of Horner's Method is " + res_value);

        //#9______________________________________________
        String feder_numb1 = "+79043781661";                                 //true
        String feder_numb2 = "89043781661";                                 //true
        String feder_numb_brackets1 = "+7(904)3781661";                    //true
        String feder_numb_brackets2 = "8(904)3781661";                    //true
        String feder_numb_brackets3 = "+7 (324) 3781661";               //true
        String feder_numb_spaces1 = "+7904 378 16 61";                  //true
        String feder_numb_hyphen1 = "+7434-378-16 61";                  //true
        String feder_numb_fake = "8434-378-16&61";                  //false

        String rost_numb = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";     //true

        boolean check_str = CheckFederalNumber(feder_numb_fake);
        System.out.println("Federal number is " + check_str);

        boolean check_str2 = CheckRostovNumber(rost_numb);
        System.out.println("Rostov number is " + check_str2);

        //#10______________________________________________
        ArrayList<String> arr_numb = GetSubStr(rost_numb);
        System.out.println("The main string: " + rost_numb);
        System.out.println("Substrings: ");
        for (String str : arr_numb)
        {
            System.out.println(str);
        }
    }
}
