package by.bsuir.kaziukovich.task3.tablebuilder;

import java.util.Collection;
import java.util.Map;

/**
 * Class for creating two-column table
 */
public class TwoColumnTableBuilder {
    /**
     * Column indent
     */
    private static final String COLUMN_INDENT = " ";

    /**
     * Column aggregator
     */
    private static final char COLUMN_AGGREGATOR = ' ';

    /**
     * Column delimiter
     */
    private static final char COLUMN_DELIMITER = '|';

    /**
     * Corner symbol
     */
    private static final char CORNER = '+';

    /**
     * Row delimiter
     */
    private static final char ROW_DELIMITER = '-';

    /**
     * Method returns max width of string representation of all elements of collection
     * @param values Collection to analyze
     * @return Max width of string representation of all elements of collection
     */
    private static int getMaxWidth(Collection<Object> values) {
        int maxWidth = 0;

        if (values == null) {
            throw new IllegalArgumentException("Values shouldn't be null collection");
        }

        for (Object value : values) {
            maxWidth = Math.max(maxWidth, value.toString().length());
        }
        return maxWidth;
    }

    /**
     * Repeats char n times
     * @param ch Char to repeat
     * @param times How many times char should be repeated
     * @return Repeated char
     */
    private static String repeatChar(char ch, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("Times should be non-negative number");
        }

        if (times == 0) {
            return "";
        }
        return new String(new char[times]).replace('\0', ch);
    }

    /**
     * Builds column entry for table
     * @param data Data of column
     * @param width Column width
     * @return Column entry
     */
    private static String getColumnEntry(String data, int width) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (width < 0) {
            throw new IllegalArgumentException("Column width should be non-negative");
        }
        if (width < (data.length() + COLUMN_INDENT.length() * 2)) {
            throw new IllegalArgumentException("Column with width " + width + " can't fit data " + data);
        }

        return COLUMN_INDENT + data
                + repeatChar(COLUMN_AGGREGATOR, width - 2 * COLUMN_INDENT.length() - data.length())
                + COLUMN_INDENT;
    }

    /**
     * Builds row entry for table
     * @param firstColumnData First column data
     * @param secondColumnData Second column data
     * @param firstColumnWidth First column width
     * @param secondColumnWidth Second column width
     * @return Row entry
     */
    private static String getRowEntry(String firstColumnData, String secondColumnData, int firstColumnWidth,
            int secondColumnWidth) {
        if ((firstColumnData == null) || (secondColumnData == null)) {
            throw new IllegalArgumentException("Column names can't be null");
        }
        if ((firstColumnWidth < 0) || (secondColumnWidth < 0)) {
            throw new IllegalArgumentException("Column widths can't be negative");
        }

        return COLUMN_DELIMITER + getColumnEntry(firstColumnData, firstColumnWidth) + COLUMN_DELIMITER
                + getColumnEntry(secondColumnData, secondColumnWidth) + COLUMN_DELIMITER + '\n';
    }

    /**
     * Builds row delimiter line
     * @param firstColumnWidth First column width
     * @param secondColumnWidth Second column width
     * @return Row delimiter line
     */
    private static String getRowDelimiterLine(int firstColumnWidth, int secondColumnWidth) {
        if ((firstColumnWidth < 0) || (secondColumnWidth < 0)) {
            throw new IllegalArgumentException("Widths cannot be negative");
        }

        return CORNER + repeatChar(ROW_DELIMITER, firstColumnWidth) + CORNER
                + repeatChar(ROW_DELIMITER, secondColumnWidth) + CORNER + '\n';
    }

    /**
     * Builds table header
     * @param firstColumnName First column name
     * @param secondColumnName Second column name
     * @param firstColumnWidth First column data
     * @param secondColumnWidth Second column data
     * @return Table header
     */
    private static String getTableHeader(String firstColumnName, String secondColumnName, int firstColumnWidth,
                                         int secondColumnWidth) {
        if ((firstColumnName == null) || (secondColumnName == null)) {
            throw new IllegalArgumentException("Column names can't be null");
        }
        if ((firstColumnWidth < 0) || (secondColumnWidth < 0)) {
            throw new IllegalArgumentException("Column widths can't be negative");
        }

        return getRowDelimiterLine(firstColumnWidth, secondColumnWidth)
                + getRowEntry(firstColumnName, secondColumnName, firstColumnWidth, secondColumnWidth)
                + getRowDelimiterLine(firstColumnWidth, secondColumnWidth);
    }

    /**
     * Builds two-column table by provided map
     * @param map Data to table build by
     * @param firstColumnName First column name
     * @param secondColumnName Second column name
     * @return String representation of table
     */
    public static String build(Map<Object, Object> map, String firstColumnName, String secondColumnName) {
        int firstColumnWidth, secondColumnWidth;
        StringBuilder table;

        if (map == null) {
            throw new IllegalArgumentException("Map shouldn't be null collection");
        }
        if ((firstColumnName == null) || (secondColumnName == null)) {
            throw new IllegalArgumentException("Column names can't be null");
        }

        firstColumnWidth = Math.max(getMaxWidth(map.keySet()), firstColumnName.length()) + COLUMN_INDENT.length() * 2;
        secondColumnWidth = Math.max(getMaxWidth(map.values()), secondColumnName.length()) + COLUMN_INDENT.length() * 2;

        table = new StringBuilder(getTableHeader(firstColumnName, secondColumnName, firstColumnWidth,
                secondColumnWidth));
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            table.append(getRowEntry(entry.getKey().toString(), entry.getValue().toString(), firstColumnWidth,
                    secondColumnWidth));
            table.append(getRowDelimiterLine(firstColumnWidth, secondColumnWidth));
        }
        return table.toString();
    }

    /**
     * Private constructor to prevent object creation
     */
    private TwoColumnTableBuilder() {}
}
