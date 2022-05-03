package lab5.d_list;

import java.util.ArrayList;

public class DList<T1,T2> {

    private ArrayList<T1> m_arr;
    private ArrayList<ArrayList<T2>> m_list_arr;

    public DList()
    {
        m_arr = new ArrayList<>();
        m_list_arr = new ArrayList<>();
    }

    public void addElem(T1 list_id, ArrayList<T2> arr)
    {
        if (!m_arr.contains(list_id))
        {
            m_arr.add(list_id);
            m_list_arr.add(arr);
        }
        else
        {
            int ind = m_arr.indexOf(list_id);

            for (T2 elem : arr)
            { m_list_arr.get(ind).add(elem); }
        }
    }

    public static void main(String[] args)
    {
        DList<Integer,Double> test_list = new DList<>();
        ArrayList<Double> arr1 = new ArrayList<>();
        ArrayList<Double> arr2 = new ArrayList<>();
        arr1.add(4.2);
        arr1.add(6.5);
        arr2.add(7.5);
        arr2.add(10.5);

        test_list.addElem(0,arr1);
        test_list.addElem(0,arr2);
        System.out.println("Check");
    }
}
