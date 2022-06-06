package lab4.cars;

public final class Lorry extends Car {

    private boolean m_trailer;

    public Lorry()
    {
        super();
        m_trailer = false;
    }

    public Lorry(String mark,  String colour, Engine engine_obj, int wheels_number, boolean trailer)
    {
        super(mark, colour, engine_obj, wheels_number);
        m_trailer = trailer;
    }

    public void SetTrailer(boolean flag)
    {
        m_trailer = flag;
    }
}
