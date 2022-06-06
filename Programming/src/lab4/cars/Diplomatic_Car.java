package lab4.cars;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Diplomatic_Car extends Car {

    private String m_country_flag;

    public Diplomatic_Car()
    {
        super();
        m_country_flag = "";
    }

    public Diplomatic_Car(String mark,  String colour, Engine engine_obj, int wheels_number,String country_flag)
    {
        super(mark,colour,engine_obj,wheels_number);
        m_country_flag = country_flag;
    }

    @Override
    public boolean CheckRegistrationPlate(String plate)
    {
        Pattern pattern_obj = Pattern.compile("[EUNO] \\d{3} [RXVPSA]{2} ((\\d{2})|(\\d{3}))");
        Matcher matcher_obj = pattern_obj.matcher(plate);
        boolean res = matcher_obj.matches();

        return res;
    }

    @Override
    public void SetRegistrationPlate(String registration_plate)
    {
        while (!CheckRegistrationPlate(registration_plate))
        {
            System.out.println("The diplomatic car can't have this number. Please try again:");
            Scanner keyboard = new Scanner(System.in);
            registration_plate = keyboard.nextLine();
        }

        m_registration_plate = registration_plate;
    }
}
