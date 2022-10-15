import java.util.HashSet;

public class Q0202 {
    public static boolean isHappy(int n) {
        int prev = n;
        HashSet<Integer> occured = new HashSet<>();
        int sum = 0;
        while (true) {
            sum = 0;
            char[] c = String.valueOf(prev).toCharArray();
            for (char x : c) {
                sum += Math.pow((x - '0'), 2);
            }
            if (sum == 1) {
                break;
            }
            if (occured.contains(sum)) {
                return false;
            }
            prev = sum;
            occured.add(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
