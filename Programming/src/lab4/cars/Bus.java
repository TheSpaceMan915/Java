package lab4.cars;

public final class Bus extends Car {

    private final int m_seats_number;

    public Bus()
    {
        super();
        m_seats_number = 30;
    }

    public Bus(String mark,  String colour, Engine engine_obj, int wheels_number,int seats_number)
    {
        super(mark, colour, engine_obj, wheels_number);
        m_seats_number = seats_number;
    }
}
