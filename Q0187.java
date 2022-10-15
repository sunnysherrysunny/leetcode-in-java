import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> occurred = new HashSet<>();
        Set<String> res = new HashSet<>();
        String curr;
        for (int i = 0; i <= s.length() - 10; i++) {
            curr = s.substring(i, i + 10);
            if (occurred.contains(curr)) {
                res.add(curr);
            } else {
                occurred.add(curr);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }
}
