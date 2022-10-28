import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q0945 {
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if (num <= prev){
                count += (prev - num + 1);
                prev ++;
            } else {
                prev = num;
            }
        }
        return count;
    }
}
