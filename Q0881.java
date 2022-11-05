import java.util.Arrays;

public class Q0881 {
    public static int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }
        if (left == right) {
            count++;
        }
        return count;
    }
}
