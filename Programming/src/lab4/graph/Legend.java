package lab4.graph;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Legend {

    private ArrayList<String> m_arr_legend;

    public Legend() { m_arr_legend = new ArrayList<>(); }

    public void AddFuncColour()
    {
        String[] colours_arr = { "Red","Blue","Green","Orange","Purple"};
        int min = 0, max = colours_arr.length;

        int ind = ThreadLocalRandom.current().nextInt(min,max);     // array elements from 0 to 4th
        m_arr_legend.add(colours_arr[ind]);

        PrintColour(m_arr_legend.size(),colours_arr[ind]);
    }

    public void PrintColour(int func_number,String colour)
    {
        System.out.println("The colour of the function number " + func_number + " is " + colour);
    }
}
