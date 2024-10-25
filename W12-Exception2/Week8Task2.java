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
     * Week8Task2.
     */
    public void nullPointerEx() throws NullPointerException {
        String str = null;
        System.out.println(str.length());
        throw new NullPointerException();
    }

    /**
     * Week8Task2.
     */
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int[] arr = {1, 2, 4, 5, 9};
        System.out.println(arr[10]);
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Week8Task2.
     */
    public void arithmeticEx() throws ArithmeticException {
        int a = 3;
        int b = 0;
        int c = a / b;
    }

    /**
     * Week8Task2.
     *
     * @throws FileNotFoundException Week8Task2.
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
        throw new FileNotFoundException();
    }

    /**
     * Week8Task2.
     *
     * @throws IOException Week8Task2.
     */
    public void ioEx() throws IOException {
        FileReader reader = new FileReader("file.txt");
        throw new IOException();
    }

    /**
     * Week8Task2.
     *
     * @return Week8Task2.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }

        return "Không có lỗi";
    }

    /**
     * Week8Task2.
     *
     * @return Week8Task2.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }

        return "Không có lỗi";
    }

    /**
     * Week8Task2.
     *
     * @return Week8Task2.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }

        return "Không có lỗi";
    }

    /**
     * Week8Task2.
     *
     * @return Week8Task2.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }

        return "Không có lỗi";
    }

    /**
     * Week8Task2.
     *
     * @return Week8Task2.
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return "Lỗi IO";
        }

        return "Không có lỗi";
    }

    /**
     * Week8Task2.
     *
     * @param args Week8Task2.
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
