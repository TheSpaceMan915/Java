package com.lab2;
import java.util.*;

public class TestFunc {

    public static void PrintValuesTable()
    {//create a table instead
        System.out.println("№1");
        System.out.println("Byte: -128 to 127");
        System.out.println("Short: -32768 to 32767");
        System.out.println("Int: -2147483648 to 2147483647");
        System.out.println("Long: -9223372036854775808 to 9223372036854775807");
        System.out.println("Float: " + 1.4E-45 + " to " + 3.4028235E38);
        System.out.println("Double: 4.9E-324 to 1.7976931348623157E308");
        System.out.println("Char: 0 to 65535");
    }

    public static void PrintTable()
    {

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
        System.out.println("The distance is " + res);
        if (res > R)
        {System.out.println("The object is not found");}

        else if ((res > r) && (res <= R))
        {System.out.println("The object is found");}
        else
        {System.out.println("Attention!");}
    }

    public static void FindDistance2(int x,int y)
    {
        Scanner keyboard = new Scanner(System.in);
        int R = 0,r = 0;

        try {
        System.out.println("Enter R");
        R = keyboard.nextInt();
        System.out.println("Enter r");
        r = keyboard.nextInt();}
        catch (InputMismatchException exp)
        {
            System.err.println("Invalid input. Try again");
            exp.printStackTrace();
            System.exit(3);
        }
        double res = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        System.out.println("№4");
        System.out.println("The distance is " + res);
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
                //System.out.print(i);
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

    public static void SearchForLetters(String str,int position,char symbol)
    {
        System.out.println("The word " + str + "starts with the index " + str.indexOf("you"));
        System.out.println("After the index " + position + "the word you starts with the index " + str.indexOf("you",position));
        System.out.println("The index of symbol " + symbol + " is " + str.indexOf(symbol));
    }

    public static void main(String[] args) {

       PrintValuesTable();

       int[] arr = {-3,2,-2,6,-8,5};
       System.out.println("№2");
       System.out.println("For " + Arrays.toString(arr) +" average geometric is " + AverageGeometric(arr));

       FindDistance(3,6);
       Scanner keyboard_m = new Scanner(System.in);
       int x_k = 0,y_k = 0;

      /* try {
           System.out.println("Enter x coordinate");
           x_k = keyboard_m.nextInt();
           System.out.println("Enter y coordinate");
           y_k = keyboard_m.nextInt();
       }
       catch (InputMismatchException exp)
       {
           System.err.println("Invalid input. Try again");
           exp.printStackTrace();
           System.exit(3);
       }
       FindDistance2(x_k,y_k);*/

        int com_arg = Integer.parseInt(args[0]);
        PrintCommandLine(com_arg);

        System.out.println("№6");
        PrintUnicodeCharacters(0x0400,16,16);
        PrintUnicodeCharacters(0x20a0,2,16);


        FindCharacters("cd4!E");

//      SearchForLetters("where are you");  Ctrl and ?
    }
}
