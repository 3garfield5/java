package lab8;

import java.util.List;
import java.util.stream.Collectors;

class FilterProcessor {
    @DataProcessor
    public static List<String> filterData(List<String> data) {
        return data.stream()
                .filter(item -> item.startsWith("a"))
                .collect(Collectors.toList());
    }
}
