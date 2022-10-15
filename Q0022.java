import java.util.ArrayList;
import java.util.List;

public class Q0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(n, n, "", res);
        return res;

    }


    public void generate(int restL, int restR, String curr, List<String> res) {
        if (restL == 0 && restR == 0) {
            res.add(curr);
            return;
        }


        if (restL > 0) {
            generate(restL - 1, restR, curr + '(', res);
        }

        if (restR > 0 && restL < restR) {
            generate(restL, restR - 1, curr + ')', res);
        }

    }
}
