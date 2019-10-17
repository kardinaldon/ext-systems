import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
//        BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList <String> col = new ArrayList<>();
//        try {
//            System.out.println("Enter value");
//            col.add(String.valueOf(str.readLine()));
//            System.out.println("Enter next");
//            col.add(String.valueOf(str.readLine()));
//            col.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        for (String result : col) {
//            System.out.println(result);
//        }


        SortedSet <Integer> sortedSet = new TreeSet();
        int [] array = new int [10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(2000000000);
            sortedSet.add(array[i]);
        }
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        System.out.println(sortedSet);
        System.out.println(sortedSet);
        System.out.println("SortedSet");
        System.out.println();

    }
}
