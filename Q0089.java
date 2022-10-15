import java.util.ArrayList;
import java.util.List;

public class Q0089 {
    public List<Integer> grayCode(int n) {
        int[] res = generate(n);
        List<Integer> ret = new ArrayList<>(res.length);
        for (int i = 0; i < res.length; i++) {
            ret.add(res[i]);
        }
        return ret;
    }

    public int[] generate(int n) {

        if (n == 1) {
            int[] res = {0, 1};
            return res;
        }

        if (n == 2) {
            int[] res = {0, 1, 3, 2};
            return res;
        }

        int[] left = generate(n - 1);
        int leftL = left.length;
        int[] right = new int[leftL];


        int offset = (int) Math.pow(2, n - 1);
        for (int i = 0; i < leftL; i++) {
            right[i] = left[leftL - i - 1] + offset;
        }

        int[] res = new int[leftL * 2];
        System.arraycopy(left, 0, res, 0, leftL);
        System.arraycopy(right, 0, res, 0 + leftL, leftL);


        return res;
    }
}