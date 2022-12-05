public class Q0390 {
    public static int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        int head = 2;
        int step = 2;
        int count = n / 2;
        boolean isFromLeft = false;
        while (count > 1) {
            if (count % 2 == 1) {
                head += step;
            } else if (isFromLeft) {
                head += step;
            }
            count /= 2;
            step *= 2;
            isFromLeft = !isFromLeft;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
    }
}
