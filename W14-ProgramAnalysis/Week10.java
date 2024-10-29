import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Week10.
 */
public class Week10 {
    private static final Pattern PACKAGE_PATTERN = Pattern.compile(
            "(\\w+)\\."
    );

    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "(\\w+)\\."
    );

    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "(\\w+)\\."
    );

    private static final Pattern STATIC_METHOD_PATTERN = Pattern.compile(
            "(\\w+)\\."
    );

    /**
     * comment.
     */
    public static List<String> getAllFunctions(String contentfile) {
        List<String> result = new ArrayList<>();

        Map<String, String> utilsMap = new HashMap<>();

        String packageName = "";

        Matcher matcher = PACKAGE_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            packageName = matcher.group(1);
        }

        matcher = IMPORT_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            String importName = matcher.group(1);
            String importPhrase = matcher.group(2);
            utilsMap.put(importName, importPhrase);
        }

        matcher = CLASS_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            String className = matcher.group(1);
            utilsMap.put(className, packageName + "." + className);
        }

        matcher = STATIC_METHOD_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            StringBuilder func = new StringBuilder();

            String methodName = matcher.group(1);

            String args = matcher.group(2);

            List<String> types = getAllTypes(args, utilsMap);

            func.append(methodName).append("(");

            boolean firstRow = true;
            for (String type : types) {
                if (!firstRow) {
                    func.append(",");
                }
                func.append(type);
                firstRow = false;
            }

            func.append(")");

            result.add(func.toString());
        }

        return result;
    }

    private static List<String> getAllTypes(String args, Map<String, String> utilsMap) {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(
                ""
        );

        Matcher matcher = pattern.matcher(args);
        while (matcher.find()) {
            String type = matcher.group(1);
            if (utilsMap.get(type) != null) {
                result.add(
                        utilsMap.get(type)
                );
            } else {
                result.add(type);
            }
        }

        return result;
    }
} 