package lab8;

import java.util.List;
import java.util.stream.Collectors;

class TransformProcessor {
    @DataProcessor
    public static List<String> transformData(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}