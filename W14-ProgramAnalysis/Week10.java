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
            "package\\s+([^;]*)"
    );

    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "import\\s(?:static\\s)?([^;]*\\.)?([A-z]+)",
            Pattern.MULTILINE
    );

    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "(?:class|interface|enum)\\s+([A-z]+)",
            Pattern.MULTILINE
    );

    private static final Pattern STATIC_METHOD_PATTERN = Pattern.compile(
            "static\\s[A-z<>]+\\s([A-z]+)\\(([^)]*)",
            Pattern.MULTILINE
    );

    /**
     * comment.
     *
     * @param contentfile Week10.
     * @return Week10.
     */
    public static List<String> getAllFunctions(String contentfile) {
        List<String> result = new ArrayList<>();

        Map<String, String> utilsMap = new HashMap<>();

        String packageName = "";

        Matcher matcher = PACKAGE_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            packageName = matcher.group(1);
            break;
        }

        matcher = IMPORT_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            String importPhrase = matcher.group(1);
            String importName = matcher.group(2);
            utilsMap.put(importName, importPhrase + importName);
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

            func.append(methodName).append("(");

            if (!args.equals("")) {
                List<String> types = getAllTypes(args, utilsMap);
                boolean firstRow = true;
                for (String type : types) {
                    if (!firstRow) {
                        func.append(",");
                    }
                    func.append(type);
                    firstRow = false;
                }
            }

            func.append(")");

            result.add(func.toString());
        }

        return result;
    }

    /**
     * Week10.
     *
     * @param args Week10.
     * @param utilsMap Week10.
     * @return Week10.
     */
    private static List<String> getAllTypes(String args, Map<String, String> utilsMap) {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(
                "([A-z<>.?]+)\\s"
        );

        Matcher matcher = pattern.matcher(args);
        while (matcher.find()) {
            String type = matcher.group(1);
            if (utilsMap.containsKey(type)) {
                result.add(
                        utilsMap.get(type)
                );
            } else if (type.matches("[A-Z][A-z.]+")) {
                if (type.contains("...")) {
                    type = "Object";
                }
                result.add("java.lang." + type);
            } else if (type.contains("?")) {
                result.add("java.lang." + type);
            } else if (type.contains("<")) {
                String type1 = type.substring(0, type.indexOf("<")) + " ";
                String type2 = type.substring(type.indexOf("<") + 1);
                type2 = type2.substring(0, type2.indexOf(">")) + " ";

                type1 = getAllTypes(type1, utilsMap).get(0);
                type2 = getAllTypes(type2, utilsMap).get(0);

                StringBuilder output = new StringBuilder();
                output.append(type1);
                output.append("<");
                output.append(type2);
                output.append(">");
                result.add(output.toString());
            } else {
                result.add(type);
            }
        }

        return result;
    }
} 