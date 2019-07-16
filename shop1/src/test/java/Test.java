import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <String> col = new ArrayList<>();
        try {
            System.out.println("Enter value");
            col.add(String.valueOf(str.readLine()));
            System.out.println("Enter next");
            col.add(String.valueOf(str.readLine()));
            col.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (String result : col) {
//            System.out.println(result);
//        }
    }
}
