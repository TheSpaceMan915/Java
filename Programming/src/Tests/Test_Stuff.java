package Tests;

import java.util.Arrays;
import java.util.function.*;

public class Test_Stuff {

    private double m_number;

    interface Func
    {
        int doFunc(int value);
    }

    public void printStuff(Func test)
    {
        System.out.println("Hello");
    }

    public void printLambda(Func temp)
    {
        System.out.println("Hey!");

    }


    public static void main(String[] args) {
        Test_Stuff test_obj = new Test_Stuff();

        test_obj.printStuff(new Func() {

            @Override
            public int doFunc(int v) {
                return 0;
            }
        });

        test_obj.printLambda(obj -> {
            System.out.println("Lambda");
            return 0;
        });

        int[] arr1 = {3, -4, -6, 2, -8, -1, -4, 6};
        IntConsumer test_interf1 = x -> System.out.println(x * 2);

        for (int i = 0; i < arr1.length; i++) {
            test_interf1.accept(arr1[i]);
        }

        IntSupplier test_interf2 = () ->
        {
            int temp = 1;
            return temp;
        };

        Predicate<Integer> test_interf3 = x -> x > 0;

        for (int i = 0; i < arr1.length; i++) {
            if (!test_interf3.test(arr1[i])) arr1[i] = 0;
        }
        System.out.println(Arrays.toString(arr1));

        UnaryOperator<Double> test_interf4 = new UnaryOperator() {
            @Override
            public Object apply(Object o) {
                Double temp = null;
                if (o instanceof Double) {
                    temp = (Double) o;
                    temp *= 2;
                }
                return temp;
            }
        };

        UnaryOperator<Double> test_interf5 = (var x) -> x + 3.23;
        System.out.println(test_interf5.apply(1.0));
    }

}
