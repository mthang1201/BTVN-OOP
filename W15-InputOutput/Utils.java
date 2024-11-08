import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utils.
 */
public class Utils {
    /**
     * Utils.
     *
     * @param path Utils.
     * @return Utils.
     * @throws IOException Utils.
     */
    public static String readContentFromFile(String path) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path));
        StringBuilder result = new StringBuilder();
        for (String line : lines) {
            result.append(line);
        }
        return result.toString();
    }

    /**
     * Utils.
     *
     * @param content Utils.
     * @param path Utils.
     * @throws IOException Utils.
     */
    public static void writeContentToFile(String content, String path) throws IOException {
        FileWriter fw = new FileWriter(path, false);
        fw.write(content);
        fw.close();
    }

    /**
     * Utils.
     *
     * @param content Utils.
     * @param path Utils.
     * @throws IOException Utils.
     */
    public static void writeContentToFileAppend(String content, String path) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(content);
        fw.close();
    }

    /**
     * Utils.
     *
     * @param folderPath Utils.
     * @param fileName Utils.
     * @return Utils.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File directory = new File(folderPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory not found: " + directory.getAbsolutePath());
            return null;
        }

        String[] flist = directory.list();

        if (flist == null || flist.length == 0) {
            System.out.println("File not found: " + directory.getAbsolutePath());
            return null;
        }

        for (int i = 0; i < flist.length; i++) {
            if (flist[i].equalsIgnoreCase(fileName)) {
                return new File(directory, flist[i]);
            }
        }
        return null;
    }
}
