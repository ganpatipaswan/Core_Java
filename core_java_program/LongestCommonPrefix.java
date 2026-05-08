import java.util.*;
import java.util.stream.Collectors;

class LongestCommonPrefix {
    public static String LongestCommonPrefixStr(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            System.out.println("Hello, World!--->" + prefix.substring(0, prefix.length() - 1));
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = { "flowers", "flow", "flight" }; // Find common longest prefix from string
        System.out.println(LongestCommonPrefixStr(strs));

        // FlatMap Example-
        List<List<String>> ls = Arrays.asList(
                Arrays.asList("a", "A"),
                Arrays.asList("b", "B"),
                Arrays.asList("c", "C"));
        // method-1
        List<String> lso = ls.stream()
                .flatMap(a -> a.stream())
                .collect(Collectors.toList());
        System.out.println("Hello, World!--->" + lso);

        // method-2
        List<String> lso1 = ls.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Hello, World!--->" + lso1);

    }

}
