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
            "^package\\s+(.*);$",
            Pattern.MULTILINE
    );

    private static final Pattern IMPORT_PATTERN = Pattern.compile(
            "^import\\s+(?:static\\s+)?((?:\\w+\\.)+(\\w+));$",
            Pattern.MULTILINE
    );

    private static final Pattern CLASS_PATTERN = Pattern.compile(
            "^(?:\\s{2})*(?:(?:abstract|public|private|protected|static|final)\\s+)*"
                    + "(class|interface|enum)\\s+([^<\\s]+)([^{]+)?\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Pattern STATIC_METHOD_PATTERN = Pattern.compile(
            "^(?<!\\s{0,20}/\\*\\n)" // Negative lookbehind
                    + "(?:\\s{2})+(?:(?:public|private|protected)\\s+)*"
                    + "static\\s+(?:final\\s+)?[\\w<>,.?\\[\\]\\s]+\\s+(\\w+)"
                    + "\\s*\\(([\\w<>,.?\\[\\]\\s]*)\\)\\s*\\{",
            Pattern.MULTILINE
    );

    private static final Map<String, String> utilsMap = new HashMap<>();

    /**
     * comment.
     *
     * @param contentfile Week10.
     * @return Week10.
     */
    public static List<String> getAllFunctions(String contentfile) {
        List<String> result = new ArrayList<>();

        String packageName = "";

        Matcher matcher = PACKAGE_PATTERN.matcher(contentfile);
        if (matcher.find()) {
            packageName = matcher.group(1);
        }

        matcher = IMPORT_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            String importPhrase = matcher.group(1);
            String importName = matcher.group(2);
            utilsMap.put(importName, importPhrase);
        }

        matcher = CLASS_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            String className = matcher.group(2);
            utilsMap.put(className, packageName + "." + className);
        }

        matcher = STATIC_METHOD_PATTERN.matcher(contentfile);
        while (matcher.find()) {
            StringBuilder func = new StringBuilder();

            String methodName = matcher.group(1);

            String args = matcher.group(2);

            func.append(methodName).append("(");

            if (!args.isEmpty()) {
                args = args.replaceAll("\\.{3}", "");
                args = args.replace("\n", "").trim();

                String[] types = args.split(", ");

                for (int i = 0; i < types.length; i++) {
                    types[i] = getAllTypes(types[i].split(" ")[0]);
                }

                for (String param : types) {
                    func.append(param).append(",");
                }

                func.deleteCharAt(func.length() - 1);
            }

            func.append(")");

            result.add(func.toString());
        }

        return result;
    }

    /**
     * Week10.
     *
     * @param arg Week10.
     * @return Week10.
     */
    private static String getAllTypes(String arg) {
        if (utilsMap.containsKey(arg)) {
            return utilsMap.get(arg);
        } else if (arg.matches("[A-Z]\\w+")) {
            return "java.lang." + arg;
        } else if (arg.contains("<")) {
            String[] parts = arg.split("<");
            parts[0] = getAllTypes(parts[0]);
            parts[1] = getAllTypes(parts[1].replace(">", ""));

            return String.format(
                    "%s<%s>",
                    parts[0],
                    parts[1]
            );
        } else {
            return arg;
        }
    }
} 