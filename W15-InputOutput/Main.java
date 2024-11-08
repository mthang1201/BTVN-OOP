import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "/Users/mthang1201/Desktop/src/";

        List<String> a = new ArrayList<String>();

        a.add(
                Utils.readContentFromFile(url + "Week10.java")
        );

        String s = "a;jfeifawe";
        Utils.writeContentToFile(s,url + "test.txt");

        Utils.writeContentToFileAppend(s,url + "test.txt");

        for (String line : a) {
            System.out.println(line);
        }

        File searchFile = Utils.findFileByName(url, "abc.cpp");

        if (searchFile != null) {
            System.out.println(searchFile.getAbsolutePath());
        } else {
            System.out.println("File not found");
        }
    }
}
