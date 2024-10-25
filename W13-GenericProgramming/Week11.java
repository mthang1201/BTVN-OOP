import java.util.Collections;
import java.util.List;

/**
 * Week11.
 */
public class Week11 {
    /**
     * Week11.
     *
     * @param list Week11.
     * @param <T> Week11.
     * @return Week11.
     */
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> list) {
        // bubble sort.
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;

            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).compareTo(list.get(j - 1)) < 0) {
                    Collections.swap(list, j, j - 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return list;
    }
}
