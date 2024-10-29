public class Main {
    public static void main(String[] args) {
        String contentFile2 = "package com.nordstrom.common.jdbc;\n" +
                "\n" +
                "import java.sql.CallableStatement;\n" +
                "import java.sql.Connection;\n" +
                "import java.sql.Driver;\n" +
                "import java.sql.DriverManager;\n" +
                "import java.sql.ResultSet;\n" +
                "import java.sql.SQLException;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.Iterator;\n" +
                "import java.util.Objects;\n" +
                "import java.util.ServiceLoader;\n" +
                "import java.util.regex.Matcher;\n" +
                "import java.util.regex.Pattern;\n" +
                "\n" +
                "import com.nordstrom.common.base.UncheckedThrow;\n" +
                "import com.nordstrom.common.jdbc.Param.Mode;\n" +
                "\n" +
                "import java.sql.PreparedStatement;\n" +
                "public class DatabaseUtils {\n" +
                "public static Object executeStoredProcedure(Class<?> resultType, String connectionStr, String sprocName, Param... params) {}\n" +
                "    \n" +
                "    private static Pattern SPROC_PATTERN = \n" +
                "                    Pattern.compile(\"([\\\\p{Alpha}_][\\\\p{Alpha}\\\\p{Digit}@$#_]*)(?:\\\\(([<>=](?:,\\\\s*[<>=])*)?(:)?\\\\))?\");\n" +
                "    \n" +
                "    private DatabaseUtils() {\n" +
                "        throw new AssertionError(\"DatabaseUtils is a static utility class that cannot be instantiated\");\n" +
                "    }\n" +
                "    \n" +
                "    static {\n" +
                "        Iterator<Driver> iterator = ServiceLoader.load(Driver.class).iterator();\n" +
                "        while (iterator.hasNext()) {\n" +
                "            iterator.next();\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query object with supplied arguments as an 'update' operation\n" +
                "     * \n" +
                "     * @param query query object to execute\n" +
                "     * @param queryArgs replacement values for query place-holders\n" +
                "     * @return count of records updated\n" +
                "     */\n" +
                "    public static int update(QueryAPI query, Object... queryArgs) {\n" +
                "        Integer result = (Integer) executeQuery(null, query, queryArgs);\n" +
                "        return (result != null) ? result.intValue() : -1;\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query object with supplied arguments as a 'query' operation\n" +
                "     * \n" +
                "     * @param query query object to execute\n" +
                "     * @param queryArgs replacement values for query place-holders\n" +
                "     * @return row 1 / column 1 as integer; -1 if no rows were returned\n" +
                "     */\n" +
                "    public static int getInt(QueryAPI query, Object... queryArgs) {\n" +
                "        Integer result = (Integer) executeQuery(Integer.class, query, queryArgs);\n" +
                "        return (result != null) ? result.intValue() : -1;\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query object with supplied arguments as a 'query' operation\n" +
                "     * \n" +
                "     * @param query query object to execute\n" +
                "     * @param queryArgs replacement values for query place-holders\n" +
                "     * @return row 1 / column 1 as string; {@code null} if no rows were returned\n" +
                "     */\n" +
                "    public static String getString(QueryAPI query, Object... queryArgs) {\n" +
                "        return (String) executeQuery(String.class, query, queryArgs);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query object with supplied arguments as a 'query' operation\n" +
                "     * \n" +
                "     * @param query query object to execute\n" +
                "     * @param queryArgs replacement values for query place-holders\n" +
                "     * @return {@link ResultPackage} object\n" +
                "     */\n" +
                "    public static ResultPackage getResultPackage(QueryAPI query, Object... queryArgs) {\n" +
                "        return (ResultPackage) executeQuery(ResultPackage.class, query, queryArgs);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query with the supplied arguments, returning a result of the indicated type.\n" +
                "     * <p>\n" +
                "     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>\n" +
                "     * <li>{@code null} - The query is executed as an update operation.</li>\n" +
                "     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>\n" +
                "     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>\n" +
                "     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>\n" +
                "     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>\n" +
                "     * \n" +
                "     * @param resultType desired result type (see TYPES above)\n" +
                "     * @param query query object to execute\n" +
                "     * @param queryArgs replacement values for query place-holders\n" +
                "     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>\n" +
                "     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object\n" +
                "     * when you're done with it to free up database and JDBC resources that were allocated for it. \n" +
                "     */\n" +
                "    private static Object executeQuery(Class<?> resultType, QueryAPI query, Object... queryArgs) {\n" +
                "        int expectCount = query.getArgNames().length;\n" +
                "        int actualCount = queryArgs.length;\n" +
                "        \n" +
                "        if (actualCount != expectCount) {\n" +
                "            String message;\n" +
                "            \n" +
                "            if (expectCount == 0) {\n" +
                "                message = \"No arguments expected for \" + query.getEnum().name();\n" +
                "            } else {\n" +
                "                message = String.format(\"Incorrect argument count for %s%s: expect: %d; actual: %d\", \n" +
                "                        query.getEnum().name(), Arrays.toString(query.getArgNames()), expectCount, actualCount);\n" +
                "            }\n" +
                "            \n" +
                "            throw new IllegalArgumentException(message);\n" +
                "        }\n" +
                "        \n" +
                "        return executeQuery(resultType, query.getConnection(), query.getQueryStr(), queryArgs);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified query with the supplied arguments, returning a result of the indicated type.\n" +
                "     * <p>\n" +
                "     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>\n" +
                "     * <li>{@code null} - The query is executed as an update operation.</li>\n" +
                "     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>\n" +
                "     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>\n" +
                "     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>\n" +
                "     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>\n" +
                "     * \n" +
                "     * @param resultType desired result type (see TYPES above)\n" +
                "     * @param connectionStr database connection string\n" +
                "     * @param queryStr a SQL statement that may contain one or more '?' IN parameter placeholders\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>\n" +
                "     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object\n" +
                "     * when you're done with it to free up database and JDBC resources that were allocated for it. \n" +
                "     */\n" +
                "    public static Object executeQuery(Class<?> resultType, String connectionStr, String queryStr, Object... params) {\n" +
                "        try {\n" +
                "            Connection connection = getConnection(connectionStr);\n" +
                "            PreparedStatement statement = connection.prepareStatement(queryStr);\n" +
                "            \n" +
                "            for (int i = 0; i < params.length; i++) {\n" +
                "                statement.setObject(i + 1, params[i]);\n" +
                "            }\n" +
                "            \n" +
                "            return executeStatement(resultType, connection, statement);\n" +
                "        } catch (SQLException e) {\n" +
                "            throw UncheckedThrow.throwUnchecked(e);\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified stored procedure object with supplied parameters\n" +
                "     * \n" +
                "     * @param sproc stored procedure object to execute\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return row 1 / column 1 as integer; -1 if no rows were returned\n" +
                "     */\n" +
                "    public static int getInt(SProcAPI sproc, Object... params) {\n" +
                "        Integer result = (Integer) executeStoredProcedure(Integer.class, sproc, params);\n" +
                "        return (result != null) ? result.intValue() : -1;\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified stored procedure object with supplied parameters\n" +
                "     * \n" +
                "     * @param sproc stored procedure object to execute\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return row 1 / column 1 as string; {@code null} if no rows were returned\n" +
                "     */\n" +
                "    public static String getString(SProcAPI sproc, Object... params) {\n" +
                "        return (String) executeStoredProcedure(String.class, sproc, params);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified stored procedure object with supplied parameters\n" +
                "     * \n" +
                "     * @param sproc stored procedure object to execute\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return {@link ResultPackage} object\n" +
                "     */\n" +
                "    public static ResultPackage getResultPackage(SProcAPI sproc, Object... params) {\n" +
                "        return (ResultPackage) executeStoredProcedure(ResultPackage.class, sproc, params);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified stored procedure with the specified arguments, returning a result of the indicated type.\n" +
                "     * <p>\n" +
                "     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>\n" +
                "     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>\n" +
                "     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>\n" +
                "     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>\n" +
                "     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>\n" +
                "     * \n" +
                "     * @param resultType desired result type (see TYPES above)\n" +
                "     * @param sproc stored procedure object to execute\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return an object of the indicated type<br>\n" +
                "     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object\n" +
                "     * when you're done with it to free up database and JDBC resources that were allocated for it. \n" +
                "     */\n" +
                "    public static Object executeStoredProcedure(Class<?> resultType, SProcAPI sproc, Object... params) {\n" +
                "        Objects.requireNonNull(resultType, \"[resultType] argument must be non-null\");\n" +
                "        \n" +
                "        String[] args = {};\n" +
                "        String sprocName = null;\n" +
                "        boolean hasVarArgs = false;\n" +
                "        int[] argTypes = sproc.getArgTypes();\n" +
                "        String signature = sproc.getSignature();\n" +
                "        Matcher matcher = SPROC_PATTERN.matcher(signature);\n" +
                "        \n" +
                "        String message = null;\n" +
                "        if (matcher.matches()) {\n" +
                "            sprocName = matcher.group(1);\n" +
                "            hasVarArgs = (matcher.group(3) != null);\n" +
                "            if (matcher.group(2) != null) {\n" +
                "                args = matcher.group(2).split(\",\\\\s\");\n" +
                "            } else {\n" +
                "                if (hasVarArgs) {\n" +
                "                    message = String.format(\"VarArgs indicated with no placeholder in signature for %s: %s\",\n" +
                "                            sproc.getEnum().name(), signature);\n" +
                "                }\n" +
                "            }\n" +
                "        } else {\n" +
                "            message = String.format(\"Unsupported stored procedure signature for %s: %s\",\n" +
                "                            sproc.getEnum().name(), signature);\n" +
                "        }\n" +
                "        \n" +
                "        if (message != null) {\n" +
                "            throw new IllegalArgumentException(message);\n" +
                "        }\n" +
                "        \n" +
                "        int argsCount = args.length;\n" +
                "        int typesCount = argTypes.length;\n" +
                "        int parmsCount = params.length;\n" +
                "        \n" +
                "        int minCount = typesCount;\n" +
                "        \n" +
                "        // if unbalanced args/types\n" +
                "        if (argsCount != typesCount) {\n" +
                "            message = String.format(\n" +
                "                            \"Signature argument count differs from declared type count for %s%s: \"\n" +
                "                                            + \"signature: %d; declared: %d\",\n" +
                "                            sproc.getEnum().name(), Arrays.toString(argTypes), argsCount, typesCount);\n" +
                "        } else if (hasVarArgs) {\n" +
                "            minCount -= 1;\n" +
                "            if (parmsCount < minCount) {\n" +
                "                message = String.format(\n" +
                "                                \"Insufficient arguments count for %s%s: minimum: %d; actual: %d\",\n" +
                "                                sproc.getEnum().name(), Arrays.toString(argTypes), minCount, parmsCount);\n" +
                "            }\n" +
                "        } else if (parmsCount != typesCount) {\n" +
                "            if (typesCount == 0) {\n" +
                "                message = \"No arguments expected for \" + sproc.getEnum().name();\n" +
                "            } else {\n" +
                "                message = String.format(\n" +
                "                                \"Incorrect arguments count for %s%s: expect: %d; actual: %d\",\n" +
                "                                sproc.getEnum().name(), Arrays.toString(argTypes), typesCount, parmsCount);\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        if (message != null) {\n" +
                "            throw new IllegalArgumentException(message);\n" +
                "        }\n" +
                "        \n" +
                "        Param[] parmArray = Param.array(parmsCount);\n" +
                "        \n" +
                "        int i;\n" +
                "        \n" +
                "        // process declared parameters\n" +
                "        for (i = 0; i < minCount; i++) {\n" +
                "            Mode mode = Mode.fromChar(args[i].charAt(0));\n" +
                "            parmArray[i] = Param.create(mode, argTypes[i], params[i]);\n" +
                "        }\n" +
                "        \n" +
                "        // handle varargs parameters\n" +
                "        for (int j = i; j < parmsCount; j++) {\n" +
                "            Mode mode = Mode.fromChar(args[i].charAt(0));\n" +
                "            parmArray[j] = Param.create(mode, argTypes[i], params[j]);\n" +
                "        }\n" +
                "        \n" +
                "        return executeStoredProcedure(resultType, sproc.getConnection(), sprocName, parmArray);\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified stored procedure with the supplied arguments, returning a result of the indicated type.\n" +
                "     * <p>\n" +
                "     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>\n" +
                "     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>\n" +
                "     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>\n" +
                "     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>\n" +
                "     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>\n" +
                "     * \n" +
                "     * @param resultType desired result type (see TYPES above)\n" +
                "     * @param connectionStr database connection string\n" +
                "     * @param sprocName name of the stored procedure to be executed\n" +
                "     * @param params an array of objects containing the input parameter values\n" +
                "     * @return an object of the indicated type<br>\n" +
                "     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object\n" +
                "     * when you're done with it to free up database and JDBC resources that were allocated for it. \n" +
                "     */\n" +
                "    public static Object executeStoredProcedure(Class<?> resultType, String connectionStr, String sprocName, Param... params) {\n" +
                "        Objects.requireNonNull(resultType, \"[resultType] argument must be non-null\");\n" +
                "        \n" +
                "        StringBuilder sprocStr = new StringBuilder(\"{call \").append(sprocName).append(\"(\");\n" +
                "        \n" +
                "        String placeholder = \"?\";\n" +
                "        for (int i = 0; i < params.length; i++) {\n" +
                "            sprocStr.append(placeholder);\n" +
                "            placeholder = \",?\";\n" +
                "        }\n" +
                "        \n" +
                "        sprocStr.append(\")}\");\n" +
                "        \n" +
                "        try {\n" +
                "            Connection connection = getConnection(connectionStr);\n" +
                "            CallableStatement statement = connection.prepareCall(sprocStr.toString());\n" +
                "            \n" +
                "            for (int i = 0; i < params.length; i++) {\n" +
                "                params[i].set(statement, i + 1);\n" +
                "            }\n" +
                "            \n" +
                "            return executeStatement(resultType, connection, statement);\n" +
                "        } catch (SQLException e) {\n" +
                "            throw UncheckedThrow.throwUnchecked(e);\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Execute the specified prepared statement, returning a result of the indicated type.\n" +
                "     * <p>\n" +
                "     * <b>TYPES</b>: Specific result types produce the following behaviors: <ul>\n" +
                "     * <li>{@code null} - The prepared statement is a query to be executed as an update operation.</li>\n" +
                "     * <li>{@link ResultPackage} - An object containing the connection, statement, and result set is returned</li>\n" +
                "     * <li>{@link Integer} - If rows were returned, row 1 / column 1 is returned as an Integer; otherwise -1</li>\n" +
                "     * <li>{@link String} - If rows were returned, row 1 / column 1 is returned as an String; otherwise {@code null}</li>\n" +
                "     * <li>For other types, {@link ResultSet#getObject(int, Class)} to return row 1 / column 1 as that type</li></ul>\n" +
                "     * <p>\n" +
                "     * <b>NOTE</b>: For all result types except {@link ResultPackage}, the specified connection and statement, as well\n" +
                "     * as the result set from executing the statement, are closed prior to returning the result. \n" +
                "     * \n" +
                "     * @param resultType desired result type (see TYPES above)\n" +
                "     * @param connectionStr database connection string\n" +
                "     * @param statement prepared statement to be executed (query or store procedure)\n" +
                "     * @return for update operations, the number of rows affected; for query operations, an object of the indicated type<br>\n" +
                "     * <b>NOTE</b>: If you specify {@link ResultPackage} as the result type, it's recommended that you close this object\n" +
                "     * when you're done with it to free up database and JDBC resources that were allocated for it. \n" +
                "     */\n" +
                "    private static Object executeStatement(Class<?> resultType, Connection connection, PreparedStatement statement) {\n" +
                "        Object result = null;\n" +
                "        boolean failed = false;\n" +
                "        \n" +
                "        ResultSet resultSet = null;\n" +
                "        \n" +
                "        try {\n" +
                "            if (resultType == null) {\n" +
                "                result = Integer.valueOf(statement.executeUpdate());\n" +
                "            } else {\n" +
                "                if (statement instanceof CallableStatement) {\n" +
                "                    if (statement.execute()) {\n" +
                "                        resultSet = statement.getResultSet(); //NOSONAR\n" +
                "                    }\n" +
                "                    \n" +
                "                    if (resultType == ResultPackage.class) {\n" +
                "                        result = new ResultPackage(connection, statement, resultSet); //NOSONAR\n" +
                "                    } else if (resultType == Integer.class) {\n" +
                "                        result = ((CallableStatement) statement).getInt(1);\n" +
                "                    } else if (resultType == String.class) {\n" +
                "                        result = ((CallableStatement) statement).getString(1);\n" +
                "                    } else {\n" +
                "                        result = ((CallableStatement) statement).getObject(1);\n" +
                "                    }\n" +
                "                } else {\n" +
                "                    resultSet = statement.executeQuery(); //NOSONAR\n" +
                "                    \n" +
                "                    if (resultType == ResultPackage.class) {\n" +
                "                        result = new ResultPackage(connection, statement, resultSet); //NOSONAR\n" +
                "                    } else if (resultType == Integer.class) {\n" +
                "                        result = Integer.valueOf((resultSet.next()) ? resultSet.getInt(1) : -1);\n" +
                "                    } else if (resultType == String.class) {\n" +
                "                        result = (resultSet.next()) ? resultSet.getString(1) : null;\n" +
                "                    } else {\n" +
                "                        result = (resultSet.next()) ? resultSet.getObject(1, resultType) : null;\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "        } catch (SQLException e) {\n" +
                "            failed = true;\n" +
                "            throw UncheckedThrow.throwUnchecked(e);\n" +
                "        } finally {\n" +
                "            if (failed || (resultType != ResultPackage.class)) {\n" +
                "                if (resultSet != null) {\n" +
                "                    try {\n" +
                "                        resultSet.close();\n" +
                "                    } catch (SQLException e) {\n" +
                "                        // Suppress shutdown failures\n" +
                "                    }\n" +
                "                }\n" +
                "                if (statement != null) {\n" +
                "                    try {\n" +
                "                        statement.close();\n" +
                "                    } catch (SQLException e) {\n" +
                "                        // Suppress shutdown failures\n" +
                "                    }\n" +
                "                }\n" +
                "                if (connection != null) {\n" +
                "                    try {\n" +
                "                        connection.commit();\n" +
                "                        connection.close();\n" +
                "                    } catch (SQLException e) {\n" +
                "                        // Suppress shutdown failures\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        \n" +
                "        return result;\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * Get a connection to the database associated with the specified connection string.\n" +
                "     * \n" +
                "     * @param connectionString database connection string\n" +
                "     * @return database connection object\n" +
                "     */\n" +
                "    private static Connection getConnection(String connectionString) {\n" +
                "        try {\n" +
                "            return DriverManager.getConnection(connectionString);\n" +
                "        } catch (SQLException e) {\n" +
                "            throw UncheckedThrow.throwUnchecked(e);\n" +
                "        }\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * This interface defines the API supported by database query collections\n" +
                "     */\n" +
                "    public interface QueryAPI {\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the query string for this query object.\n" +
                "         * \n" +
                "         * @return query object query string\n" +
                "         */\n" +
                "        String getQueryStr();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the argument names for this query object.\n" +
                "         *  \n" +
                "         * @return query object argument names\n" +
                "         */\n" +
                "        String[] getArgNames();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the database connection string for this query object.\n" +
                "         * \n" +
                "         * @return query object connection string\n" +
                "         */\n" +
                "        String getConnection();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the implementing enumerated constant for this query object.\n" +
                "         * \n" +
                "         * @return query object enumerated constant\n" +
                "         */\n" +
                "        Enum<? extends QueryAPI> getEnum(); //NOSONAR\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * This interface defines the API supported by database stored procedure collections\n" +
                "     */\n" +
                "    public interface SProcAPI {\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the signature for this stored procedure object.\n" +
                "         * <p>\n" +
                "         * Each argument place holder in the stored procedure signature indicates the mode of the corresponding\n" +
                "         * parameter: \n" +
                "         * \n" +
                "         * <ul>\n" +
                "         *     <li>'&gt;' : This argument is an IN parameter</li>\n" +
                "         *     <li>'&lt;' : This argument is an OUT parameter</li>\n" +
                "         *     <li>'=' : This argument is an INOUT parameter</li>\n" +
                "         * </ul>\n" +
                "         * \n" +
                "         * For example:\n" +
                "         * \n" +
                "         * <blockquote>RAISE_PRICE(&gt;, &lt;, =)</blockquote>\n" +
                "         * \n" +
                "         * The first and second arguments are IN parameters, and the third argument is an INOUT parameter.\n" +
                "         * \n" +
                "         * @return stored procedure signature\n" +
                "         */\n" +
                "        String getSignature();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the argument types for this stored procedure object.\n" +
                "         * \n" +
                "         * @return stored procedure argument types\n" +
                "         */\n" +
                "        int[] getArgTypes();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the database connection string for this stored procedure object.\n" +
                "         * \n" +
                "         * @return stored procedure connection string\n" +
                "         */\n" +
                "        String getConnection();\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the implementing enumerated constant for this stored procedure object.\n" +
                "         * \n" +
                "         * @return stored procedure enumerated constant\n" +
                "         */\n" +
                "        Enum<? extends SProcAPI> getEnum(); //NOSONAR\n" +
                "    }\n" +
                "    \n" +
                "    /**\n" +
                "     * This class defines a package of database objects associated with a query. These include:<ul>\n" +
                "     * <li>{@link Connection} object</li>\n" +
                "     * <li>{@link PreparedStatement} object</li>\n" +
                "     * <li>{@link ResultSet} object</li></ul>\n" +
                "     */\n" +
                "    public static class ResultPackage implements AutoCloseable {\n" +
                "        \n" +
                "        private Connection connection;\n" +
                "        private PreparedStatement statement;\n" +
                "        private ResultSet resultSet;\n" +
                "        \n" +
                "        /**\n" +
                "         * Constructor for a result package object\n" +
                "         * \n" +
                "         * @param connection {@link Connection} object\n" +
                "         * @param statement {@link PreparedStatement} object\n" +
                "         * @param resultSet {@link ResultSet} object\n" +
                "         */\n" +
                "        private ResultPackage(Connection connection, PreparedStatement statement, ResultSet resultSet) {\n" +
                "            this.connection = connection;\n" +
                "            this.statement = statement;\n" +
                "            this.resultSet = resultSet;\n" +
                "        }\n" +
                "        \n" +
                "        public Connection getConnection() {\n" +
                "            return connection;\n" +
                "        }\n" +
                "        \n" +
                "        public PreparedStatement getStatement() {\n" +
                "            return statement;\n" +
                "        }\n" +
                "        \n" +
                "        public CallableStatement getCallable() {\n" +
                "            if (statement instanceof CallableStatement) {\n" +
                "                return (CallableStatement) statement;\n" +
                "            }\n" +
                "            throw new UnsupportedOperationException(\"The statement of this package is not a CallableStatement\");\n" +
                "        }\n" +
                "        \n" +
                "        /**\n" +
                "         * Get the result set object of this package.\n" +
                "         * \n" +
                "         * @return {@link ResultSet} object\n" +
                "         */\n" +
                "        public ResultSet getResultSet() {\n" +
                "            if (resultSet != null) return resultSet;\n" +
                "            throw new IllegalStateException(\"The result set in this package has been closed\");\n" +
                "        }\n" +
                "        \n" +
                "        @Override\n" +
                "        public void close() {\n" +
                "            if (resultSet != null) {\n" +
                "                try {\n" +
                "                    resultSet.close();\n" +
                "                    resultSet = null;\n" +
                "                } catch (SQLException e) { }\n" +
                "            }\n" +
                "            if (statement != null) {\n" +
                "                try {\n" +
                "                    statement.close();\n" +
                "                    statement = null;\n" +
                "                } catch (SQLException e) { }\n" +
                "            }\n" +
                "            if (connection != null) {\n" +
                "                try {\n" +
                "                    connection.commit();\n" +
                "                    connection.close();\n" +
                "                    connection = null;\n" +
                "                } catch (SQLException e) { }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String contentFile = "public static void sayHello() {}\n" +
                "=> sayHello()\n" +
                "---------------------------------------------\n" +
                "import java.util.List;" +
                "public static void fib(int a, String b, List<String> c) {}" +
                "public static int add(int a, int b) {}\n" +
                "=> add(int,int)\n" +
                "---------------------------------------------\n" +
                "public static void printMessage(String message) {}\n" +
                "=> printMessage(java.lang.String)\n" +
                "---------------------------------------------\n" +
                "public static void printMessages(String[] messages) {}\n" +
                "=> printMessages(java.lang.String[])\n" +
                "---------------------------------------------\n" +
                "import java.io.File;\n" +
                "public static String readFile(File file) {}\n" +
                "=> readFile(java.io.File)\n" +
                "---------------------------------------------\n" +
                "// tệp này có 2 lớp\n" +
                "package net.bqc.utils;\n" +
                "class Message {}\n" +
                "public static void printMessage(Message message) {}\n" +
                "=> printMessage(net.bqc.utils.Message)\n" +
                "---------------------------------------------\n" +
                "// tệp này có 2 lớp\n" +
                "package net.bqc.utils;\n" +
                "import java.util.List;\n" +
                "class Message {}\n" +
                "public static void printMessages(List<Message> messages) {}\n" +
                "=> printMessages(java.util.List<net.bqc.utils.Message>)";

        Week10.getAllFunctions(contentFile2).forEach(System.out::println);
    }
}
