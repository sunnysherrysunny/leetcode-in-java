import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] sArr = s.toCharArray();
        for(char c : sArr){
            freq.put(c, (freq.getOrDefault(c, 0) + 1));
        }
        for(int i = 0; i < sArr.length; i++) {
            if (freq.get(sArr[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
