import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Week8Task2.
 */
public class Week8Task2 {
    /**
     *
     */
    public void nullPointerEx() {
        String str = null;
        System.out.println(str.length());
    }

    /**
     *
     */
    public void ArrayIndexOutOfBoundsEx() {
        int[] arr = {1, 2, 4, 5, 9};
        System.out.println(arr[10]);
    }

    /**
     *
     */
    public void ArithmeticEx() {
        int a = 3;
        int b = 0;
        int c = a / b;
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
    }

    /**
     *
     * @throws IOException
     */
    public void ioEx() throws IOException {
        FileReader reader = new FileReader("file.txt");
    }

    /**
     *
     * @return
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return e.getMessage();
        }

        return "Không có lỗi";
    }

    /**
     *
     * @return
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            ArrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }

        return "Không có lỗi";
    }

    /**
     *
     * @return
     */
    public String arithmeticExTest() {
        try {
            ArithmeticEx();
        } catch (ArithmeticException e) {
            return e.getMessage();
        }

        return "Không có lỗi";
    }

    /**
     *
     * @return
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }

        return "Không có lỗi";
    }

    /**
     *
     * @return
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return e.getMessage();
        }

        return "Không có lỗi";
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Week8Task2 task = new Week8Task2();
        System.out.println(task.nullPointerExTest());
        System.out.println(task.arrayIndexOutOfBoundsExTest());
        System.out.println(task.arithmeticExTest());
        System.out.println(task.fileNotFoundExTest());
        System.out.println(task.ioExTest());
    }
}
