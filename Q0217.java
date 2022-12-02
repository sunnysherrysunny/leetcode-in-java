import java.util.HashSet;
import java.util.Set;

public class Q0217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> appeared = new HashSet<>();
        for(int num: nums){
            if (appeared.contains(num)){
                return true;
            }
            appeared.add(num);
        }
        return false;
    }
}
