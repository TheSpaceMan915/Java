package com.lab2;
import java.util.*;
//use Ctrl and ? to comment something

public class TestFunc {

    public static void PrintValuesTable()
    {//create a table instead
        System.out.println("№1");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%15s %30s %30s","Type","Min value","Max value" + '\n');
        System.out.println("-----------------------------------------------------------------------------");

        String t_arr[] = {"Byte","Short","Int","Long","Float","Double","Char"};
        String min_val_arr[] = {"-128","-32768","-2147483648","-9223372036854775808","1.4E-45","4.9E-324","0"};
        String max_val_arr[] = {"127","32767","2147483647","9223372036854775807","3.4028235E38","1.7976931348623157E308","65535"};

        for (int i = 0; i < t_arr.length;i++)
        {
            System.out.printf("%15s %30s %30s", t_arr[i],min_val_arr[i], max_val_arr[i] + '\n');
        }
        System.out.println("-----------------------------------------------------------------------------");

    }

    public static double AverageGeometric(int[] obj)
    {
        double res = 1.0;
        int i = 0;

        while (i < obj.length)
        {
            if (obj[i] < 0)
            {res = obj[i] * res;}
            i++;
        }

        if (res < 0)
        {
            res = Math.abs(res);
            res = Math.pow(res,1.0/(double) obj.length) * -1;
        }
        else
        {res = Math.pow(res,1.0/(double) obj.length);}

        return res;
    }

    public static void FindDistance(int x,int y)
    {
        double res = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        double R = 20.5,r = 5.5;

        System.out.println("№3");
        System.out.println("The distance is " + res + "\tr = " + r + "\tR = " + R);
        if (res > R)
        {System.out.println("The object is not found");}

        else if ((res > r) && (res <= R))
        {System.out.println("The object is found");}
        else
        {System.out.println("Attention!");}
    }

    public static void FindDistance2(int x,int y, int R, int r)
    {

        double res = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        System.out.println("№4");
        System.out.println("The distance is " + res + "\tr = " + r + "\tR = " + R);
        if (res > R)
        {System.out.println("The object is not found");}

        else if ((res > r) && (res <= R))
        {System.out.println("The object is found");}
        else
        {System.out.println("Attention!");}
    }

    public static void PrintCommandLine(int number)

    {
        System.out.println("№5");
        System.out.println("A command line argument is " + number);
        System.out.println("In 2 system it is : " + Integer.toBinaryString(number));
        System.out.println("In 8 system it is : " + Integer.toOctalString(number));
        System.out.println("In 16 system it is : " + Integer.toHexString(number));
    }

    public static void PrintUnicodeCharacters(int code, int line, int row)
    {
        System.out.println("");
        char symbol = (char) code;

        for (int j = 0; j < line*row;j++)
        {
            if(j % row == 0 && j != 0)
            {
                System.out.println(symbol);
            }
            else
            {System.out.print(symbol + " ");}

            code++;
            symbol = (char) code;
        }
        System.out.println("");
    }

    public static void FindCharacters(String str)
    {
        System.out.println("№7");
        int big_let_counter = 0,small_let_counter = 0,letter_counter = 0,num_counter = 0,
        arab_num_counter = 0, rom_n_counter = 0, other_counter = 0, general_counter = 0;

        for (int j = 0; j < str.length();j++)
        {
            char symbol = str.charAt(j);
            int n_symb = (int) symbol;

            if ( (Character.isUpperCase(symbol)) && (Character.isLetter(symbol)))
            {
                big_let_counter++;
                letter_counter++;
                general_counter++;
            }

            else if ((Character.isLetter(symbol)) && (Character.isLowerCase(symbol)))
            {
                small_let_counter++;
                letter_counter++;
                general_counter++;
            }

            else if (Character.isDigit(symbol))
            {
                arab_num_counter++;
                num_counter++;
                general_counter++;
            }

            else if ((0x2160 <= n_symb) && (n_symb <= 0x216F))
            {
                rom_n_counter++;
                num_counter++;
                general_counter++;
            }

            else
            {
                other_counter++;
                general_counter++;
            }
        }
        System.out.println("There are " + big_let_counter + " big letters");
        System.out.println("There are " + small_let_counter + " small letters");
        System.out.println("There are " + letter_counter + " letters");
        System.out.println("There are " + arab_num_counter + " arabic numbers");
        System.out.println("There are " + rom_n_counter + " roman numbers");
        System.out.println("There are " + num_counter + " numbers");
        System.out.println("There are " + other_counter + " other symbols");
        System.out.println("Generally, there are " + general_counter + " symbols");
    }

    public static int LookForSubstring(String str,String sub_str)
    {
        System.out.println("№9");
        int sub_counter = 0;
        int index_start = str.indexOf(sub_str);

        if (index_start != -1)
        {sub_counter++;}
        else
        {return index_start;}  //if there are no substrings return -1

        int temp_ind = 0;

        while (temp_ind != -1)
        {
           temp_ind = str.indexOf(sub_str,index_start + 1);
           sub_counter++;
           index_start = temp_ind;
        }

        return sub_counter;
    }

    public static void PrintString(String str)
    {
        System.out.println("№10");
        for(int i = 0; i < str.length();i++)
        {
            for(int k = i; k < str.length();k++)
            {
                System.out.print(str.charAt(k));
            }
            for(int j = 0; j < i; j++)
            {
                System.out.print(str.charAt(j));
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
       /* System.out.println(args[0]);
        System.out.println(args[0]);
        System.out.println(args[0]);*/

        PrintValuesTable();

       int[] arr = {-3,2,-2,6,-8,5,7,8,-3,10,1,-1,6,7,9,5,8,3,9,4};
       System.out.println("№2");
       System.out.println("For " + Arrays.toString(arr) +" average geometric is " + AverageGeometric(arr));

       FindDistance(3,6);

       int x_k = Integer.parseInt(args[0]),y_k = Integer.parseInt(args[1]);
       int r_k = Integer.parseInt(args[2]),R_k= Integer.parseInt(args[3]);

       int x_k2 = Integer.parseInt(args[4]),y_k2 = Integer.parseInt(args[5]);
       int r_k2 = Integer.parseInt(args[6]),R_k2 = Integer.parseInt(args[7]);

       int x_k3 = Integer.parseInt(args[8]),y_k3 = Integer.parseInt(args[9]);
       int r_k3 = Integer.parseInt(args[10]),R_k3 = Integer.parseInt(args[11]);

        FindDistance2(x_k,y_k,R_k,r_k);
        FindDistance2(x_k2,y_k2,R_k2,r_k2);
        FindDistance2(x_k3,y_k3,R_k3,r_k3);


        int com_arg = Integer.parseInt(args[4]);
        PrintCommandLine(com_arg);

        System.out.println("№6");
        PrintUnicodeCharacters(0x0400,16,16);
        PrintUnicodeCharacters(0x20a0,2,16);

        FindCharacters("cd4Ⅳ!EⅧ");

        String main_str = "People think a lot about other people";
        String substring = "people";
        System.out.println("There are " + LookForSubstring(main_str,substring) + " substrings in this string: " + main_str);

        PrintString("Like");
    }
}
