package lab5.competition;
import lab5.g_pair_bag.GenericPairBag;
import lab5.pairbag.*;
import java.util.Scanner;

public class Competition {

    private Bag m_bag;
    private GenericPairBag<String>  m_pair_bag;
    private int m_initial_number_teams;
    private int m_current_number_teams;

    public Competition(int number_teams)
    {
        m_initial_number_teams = number_teams;
        m_current_number_teams = m_initial_number_teams;
        m_bag = new Bag(number_teams);
        m_pair_bag = new GenericPairBag<>();
    }

    public Competition() { this(4); }

    public void fillBag()
    {
        String str = "Team";
        for (int i = 0; i < m_initial_number_teams; i++)
        {
            int num = i + 1;
            m_bag.addItem(str + num);
        }
    }

    public void fillPairBag()
    {
        Pair temp;
        while (!m_bag.isEmpty())
        {
            temp = new Pair<>(m_bag.deleteItem(), m_bag.deleteItem());
            m_pair_bag.addItem(temp);
        }
    }

    public String chooseTheWinner()
    {
        Scanner keyboard = new Scanner(System.in);
        Pair<String,String> temp;
        int numb = 0;

        do
        {
            fillPairBag();
            while (!m_pair_bag.isEmpty()) {
                System.out.println("What team shall win (1 or 2)?");
                temp = m_pair_bag.deleteItem();
                m_current_number_teams--;

                switch (numb = keyboard.nextInt()) {
                    case 1 -> m_bag.addItem(temp.getValue1());
                    case 2 -> m_bag.addItem(temp.getValue2());
                    default -> System.out.println("There is no team with this number. Please try again");
                }
            }
        } while (m_current_number_teams >= 2);

        return (String) m_bag.deleteItem();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of teams. It should be more than 1");
        int num_teams = in.nextInt();
        Competition test_comp;

        if (!(num_teams % 2 == 0) || (num_teams % 3 == 0))
        { test_comp = new Competition(); }
        else
        { test_comp = new Competition(num_teams); }
        test_comp.fillBag();
        String winner = test_comp.chooseTheWinner();

        System.out.println("The winner is " + winner);
    }
}
