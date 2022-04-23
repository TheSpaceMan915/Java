package lab4.autopark;

import lab4.cars.*;

public class Autopark {

    private Car[] m_cars;

   // public Autopark() {}
    public Autopark(int size) { m_cars = new Car[size]; }

    public void AddCar(Car obj)
    {
        for (int i = 0; i <m_cars.length; i++)
        {
            if (m_cars[i] == null)
            {
                m_cars[i] = obj;
                return;
            }
        }
      System.out.println("There is no space in the autopark");
    }

    public void DeleteCar(Car obj)
    {
        int i = 0;
        while (!m_cars[i].equals(obj))
        { i++; }

        if (i == m_cars.length)
        { System.out.println("There is no such car in the park"); }
        else
        {
            m_cars[i] = null;
        }
    }

    public void PrintCarsAtThePark()
    {
        System.out.println("These cars are at the park:");
        for (int i = 0; i < m_cars.length; i++)
        {
            if (m_cars[i].GetAutoState().equals(Car.Auto_state.AT_THE_PARK))
            { m_cars[i].PrintCar();}
        }
    }

    public void PrintCarsOnTheWay()
    {
        System.out.println("These cars are on the way:");
        for (int i = 0; i < m_cars.length; i++)
        {
            if (m_cars[i].GetAutoState().equals(Car.Auto_state.ON_THE_WAY))
            { m_cars[i].PrintCar();}
        }
    }

    public void PrintCarsInService()
    {
        System.out.println("These cars are in service:");
        for (int i = 0; i < m_cars.length; i++)
        {
            if (m_cars[i].GetAutoState().equals(Car.Auto_state.IN_SERVICE))
            { m_cars[i].PrintCar();}
        }
    }

    public static void main(String[] args) {

        String s1 = "kj";
        String s2 = "kj";
        boolean res = s1.equals(s2);
        System.out.println(res);

        Engine engine1 = new Engine(975,100,4,14,"Gas",32);
        Engine engine2 = new Engine(473,200,3,12,"Petrol",11);
        Engine engine3 = new Engine(895,132,2,5,"Diesel",20);

        Car bmw_520d = new Diplomatic_Car("G324","Black",engine1,4,"Italy");
        Car kia_rio = new Sedan("F321","White",engine2,4,true);
        Car bus = new Bus("M342","Blue",engine3,4,23);

        bus.SetAutoState(Car.Auto_state.IN_SERVICE);
        bmw_520d.SetAutoState(Car.Auto_state.ON_THE_WAY);
        Autopark park = new Autopark(3);
        park.AddCar(bmw_520d);
        park.AddCar(kia_rio);
        park.AddCar(bus);
        park.DeleteCar(kia_rio);
        park.AddCar(kia_rio);
        park.PrintCarsAtThePark();
        park.PrintCarsInService();
        park.PrintCarsOnTheWay();
    }
}
