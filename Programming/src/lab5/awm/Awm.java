package lab5.awm;

import java.util.ArrayList;
import java.util.Arrays;

public class Awm {

    private int[] m_arr_coins;

    public Awm(int[] arr_coins) { m_arr_coins = arr_coins; }

    public ArrayList<Integer> getMoney(int amount_money) {

        ArrayList<Integer> arr_coins = new ArrayList<>();
        Arrays.sort(m_arr_coins);

        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(m_arr_coins));
        int temp = amount_money;

        for (int j = m_arr_coins.length - 1; j >= 0; j--) {
            if (temp - m_arr_coins[j] >= 0)
            {
                arr_coins.add(m_arr_coins[j]);
                temp -= m_arr_coins[j];
            }
        }

        return arr_coins;
    }

    public static void main (String[] args)
    {
        int[] arr = {5,2,1,10,5,2,3};
        Awm test = new Awm(arr);

        ArrayList<Integer> list1 = test.getMoney(22);
        System.out.println(Arrays.toString(list1.toArray()));

    }
    }
