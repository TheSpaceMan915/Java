package lab4.cars;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//все поля в классе engine должны быть final
//показал первые два задания
//сделать проверку состояния авто (поломан, на ремонте) перед оправлением машины в рейс
//сделать просмотр отдельного авто из автобазы
//задание 8:класс ось, класс сетка, класс легенда(описание из массива строк),класс кривая

public abstract class Car {

    protected String m_registration_plate;
    private final String m_mark;
    private String m_colour;
    private Engine m_engine;
    private final int m_wheels_number;

    private Auto_state m_state;
    //убрать её

    public Car(String mark,  String colour, Engine engine_obj, int wheels_number)
    {
        m_registration_plate = "";
        m_mark = mark;
        m_colour = colour;
        m_engine = engine_obj;
        m_wheels_number = wheels_number;
        m_state = Auto_state.AT_THE_PARK;
    }

    public Car()
    {
        m_registration_plate = "";
        m_mark = "BMW";
        m_colour = "White";
        m_engine = null;
        m_wheels_number = 4;
        m_state = Auto_state.AT_THE_PARK;
    }

    public final void SetAutoState(Auto_state obj)
    {
        m_state = obj;
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
    public final void SetColour(String colour) {m_colour = colour;}
    public final void SetEnginePower(Engine engine_obj) {m_engine = engine_obj;}

    public final String GetRegistrationPlate() { return m_registration_plate; }

    public final Auto_state GetAutoState() { return m_state; }

    //enum class
    public enum Auto_state {
        ON_THE_WAY, IN_SERVICE,AT_THE_PARK
    }

    public boolean CheckRegistrationPlate(String plate)
    {
        //Should I use Russian letters or English letters in the regex?
        Pattern pattern_obj = Pattern.compile("[ABEKMHOPCTUX] \\d{3} [ABEKMHOPCTUX]{2} ((\\d{2})|(\\d{3})) RUS");
        Matcher matcher_obj = pattern_obj.matcher(plate);
        boolean res = matcher_obj.matches();

        return res;
    }

    public void PrintCar()
    {
        System.out.printf("%35s %15s %15s",getClass().toString(),m_mark, m_colour);
        System.out.println();
    }

    public static void main(String[] args) {

        Engine test_engine = new Engine(433,380,4.5,10,"Petrol",43);
        Car kia_rio = new Diplomatic_Car("G324","Red",test_engine,4,"Italy");

        String plate1 = "E 433 SX 25";
        kia_rio.SetRegistrationPlate(plate1);
        System.out.println(kia_rio.GetRegistrationPlate());
    }

}