package ss11_dsa_stack_queue.bai_tap.count_string;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountString {
    public static void main(String[] args) {
        String str = "Haasd dsro jlasdj AGDSGsdasdkasd";
        Map<Character, Integer> map = new TreeMap<>();
        for (char a : str.toLowerCase().toCharArray()) {
            if (a == ' ') {
                continue;
            }
            if (map.containsKey(a)) {
                Integer value = map.get(a);
                map.remove(a);
                map.put(a, value + 1);
            } else {
                map.put(a, 1);
            }
        }
       Set<Character> set= map.keySet();
        for (Character key : set) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
