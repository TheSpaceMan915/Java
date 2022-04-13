package lab4.car;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {

    private String m_registration_plate;
    private String m_mark;
    private Auto_type m_type;
    private String m_colour;
    private int m_engine_power;
    private int m_wheels_number;

    public Car(String mark, Auto_type type, String colour, int engine_power, int wheels_number)
    {
        m_registration_plate = "";m_mark = mark; m_type = type; m_colour = colour; m_engine_power = engine_power; m_wheels_number = wheels_number;
    }

    public void SetRegistrationPlate(String registration_plate)
    {
        while (!CheckRegistrationPlate(registration_plate))
            {
                System.out.println("Your registration plate has the wrong format. Please try again:");
                Scanner keyboard = new Scanner(System.in);
                registration_plate = keyboard.nextLine();
            }

        m_registration_plate = registration_plate;
    }
    public void SetColour(String colour) {m_colour = colour;}
    public void SetEnginePower(int engine_power) {m_engine_power = engine_power;}

    public String GetRegistrationPlate() { return m_registration_plate; }


    public enum Auto_type {
        BUS, LEGKOVOI,GRUZOVOI
    }

    private boolean CheckRegistrationPlate(String plate)
    {
        //Should I use Russian letters or English letters in the regex?
        Pattern pattern_obj = Pattern.compile("[ABEKMHOPCTUX]\\s\\d{3}\\s[ABEKMHOPCTUX]{2}\\s((\\d{2})|(\\d{3}))\\sRUS");
        Matcher matcher_obj = pattern_obj.matcher(plate);
        boolean res = matcher_obj.matches();

        return res;
    }


    public static void main(String[] args) {

        Car ferrari = new Car("G324",Auto_type.LEGKOVOI,"Red",350,4);

        String plate1 = "B 433 PX 25 RUS";
        ferrari.SetRegistrationPlate(plate1);
        System.out.println(ferrari.GetRegistrationPlate());
    }

}