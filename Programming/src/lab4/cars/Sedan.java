package lab4.cars;

//легковая машина
public final class Sedan extends Car{

    private final boolean m_sunroof;

    public Sedan()
    {
        super();
        m_sunroof = false;
    }

    public Sedan(String mark,  String colour, Engine engine_obj, int wheels_number, boolean sunroof)
    {
        super(mark,colour,engine_obj,wheels_number);
        m_sunroof = sunroof;
    }


}
