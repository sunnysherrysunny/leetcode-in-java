import java.util.ArrayList;

public class Q0038 {
    public static ArrayList<Integer> helper(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(1);
            return res;
        }

        if (n == 2) {
            res.add(1);
            res.add(1);
            return res;
        }
        ArrayList<Integer> prevRes = helper(n - 1);
        int prevNum = -1;
        int count = 0;
        boolean isInitialzed = false;
        for (int currNum :
                prevRes) {
            if (currNum == prevNum) {
                count++;
            } else {
                if (!isInitialzed) {
                    isInitialzed = true;
                } else {
                    res.add(count);
                    res.add(prevNum);
                }
                prevNum = currNum;
                count = 1;
            }
        }
        res.add(count);
        res.add(prevNum);
        return res;
    }

    public static String myListToString(ArrayList<Integer> list) {
        StringBuilder res = new StringBuilder();
        for (int curr :
                list) {
            res.append(curr);
        }
        return res.toString();
    }

    public static String countAndSay(int n) {
        return myListToString(helper(n));
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
