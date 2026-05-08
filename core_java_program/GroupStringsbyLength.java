import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsbyLength() {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "ccc", "dd");

        Map<Integer, Long> result = list.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()));

        System.out.println(result);
    }
}
