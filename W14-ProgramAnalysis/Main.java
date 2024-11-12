import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in1 = new BufferedReader(new FileReader("tests/VolumeInfo.txt"));
        BufferedReader in2 = new BufferedReader(new FileReader("tests/DatabaseUtils.txt"));
        BufferedReader in3 = new BufferedReader(new FileReader("tests/RandomNumberUtils.txt"));
        BufferedReader in4 = new BufferedReader(new FileReader("tests/RandomArrayUtils.txt"));

        StringBuilder contentFile = new StringBuilder();
        String str;
        while ((str = in1.readLine()) != null) {
            contentFile.append(str).append("\n");
        }

        Week10.getAllFunctions(contentFile.toString()).forEach(System.out::println);
    }
}
