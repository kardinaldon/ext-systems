import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("/home/cardinal/Рабочий стол/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/home/cardinal/Рабочий стол/test.txt");

        while (fileInputStream.available() > 0)
        {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
