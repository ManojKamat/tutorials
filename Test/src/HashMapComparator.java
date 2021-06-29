import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

class HashMapComparator {

    public static void main(String[] args) {
        // New HashMap1
        Map<Integer, String> map1 = new HashMap<>();

        // Add Entry to map
        map1.put(1, "Akshayy");
        map1.put(2, "Bina");
        map1.put(3, "Chintu");

        // New HashMap2
        Map<Integer, String> map2 = new HashMap<>();

        // Add Entry to map
        map2.put(3, "Chintu");
        map2.put(2, "Binaa");
        map2.put(1, "Akshay");

        // Compare Map
        System.out.println("map1 == map2 : " + map1.equals(map2));

        // Compare by Keys
        System.out.println("map1 == map2 keys : " + map1.keySet().equals(map2.keySet()));

        // Compare by values
        Set<String> set1 = new HashSet<>(map1.values());
        Set<String> set2 = new HashSet<>(map2.values());
        System.out.println("map1 == map2 values : " + set1.equals(set2));

        String[][] table = getDiffByValues(map1, map2);
        // System.out.println(Arrays.deepToString(table));
        tableWithLines(table);
    }

    private static String[][] getDiffByValues(Map<Integer, String> map1, Map<Integer, String> map2) {
        List<String[]> diff = new ArrayList<>();
        diff.add(new String[] {"Key 1", "Value 1", "Key 2", "Value 2"});
        for (Entry<Integer, String> item : map1.entrySet()) {
            if (!item.getValue().equals(map2.get(item.getKey()))) {
                diff.add(new String[] { item.getKey().toString(), item.getValue(), item.getKey().toString(),
                        map2.get(item.getKey()) });
            }
        }

        String[][] table = new String[diff.size()][];
        for (int i = 0; i < table.length; i++) {
            table[i] = new String[diff.get(i).length];
        }
        for (int i = 0; i < diff.size(); i++) {
            for (int j = 0; j < diff.get(i).length; j++) {
                table[i][j] = diff.get(i)[j];
            }
        }
        return table;
    }

    public static void tableWithLines(String[][] table) {
        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = false;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */
        // String[][] table = new String[][] { { "id", "First Name", "Last Name", "Age"
        // },
        // { "1", "John", "Johnson", "45" }, { "2", "Tom", "", "35" }, { "3", "Rose",
        // "Johnson", "22" },
        // { "4", "Jimmy", "Kimmel", "" } };

        /*
         * Calculate appropriate Length of each column by looking at width of data in
         * each column.
         * 
         * Map columnLengths is <column_number, column_length>
         */
        Map<Integer, Integer> columnLengths = new HashMap<>();
        Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
            if (columnLengths.get(i) == null) {
                columnLengths.put(i, 0);
            }
            if (columnLengths.get(i) < a[i].length()) {
                columnLengths.put(i, a[i].length());
            }
        }));
        // System.out.println("columnLengths = " + columnLengths);

        /*
         * Prepare format String
         */
        final StringBuilder formatString = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
        formatString.append("|\n");
        // System.out.println("formatString = " + formatString.toString());

        /*
         * Prepare line for top, bottom & below header row.
         */
        String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
            String templn = "+-";
            templn = templn + Stream.iterate(0, (i -> i < b.getValue()), (i -> ++i)).reduce("", (ln1, b1) -> ln1 + "-",
                    (a1, b1) -> a1 + b1);
            templn = templn + "-";
            return ln + templn;
        }, (a, b) -> a + b);
        line = line + "+\n";
        // System.out.println("Line = " + line);

        /*
         * Print table
         */
        System.out.print(line);
        Arrays.stream(table).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
        System.out.print(line);

        Stream.iterate(1, (i -> i < table.length), (i -> ++i))
                .forEach(a -> System.out.printf(formatString.toString(), table[a]));
        System.out.print(line);
    }
}