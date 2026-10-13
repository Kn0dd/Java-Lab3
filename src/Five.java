import java.util.HashMap;
import java.util.Map;

public class Five {

    public static <K, V> Map<V, K> invertMap(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();

        if (sourceMap == null) {
            return invertedMap;
        }

        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);

        Map<Integer, String> invertedMap = invertMap(originalMap);
        System.out.println(invertedMap);
    }
}
