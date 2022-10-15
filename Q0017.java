import java.util.ArrayList;
import java.util.List;

public class Q0017 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        generate(digits, 0, "", res);
        return res;
    }

    public void generate(String digits, int index, String curr, List<String> res) {
        if (index == digits.length()) {
            res.add(curr);
            return;
        }

        char currDigit = digits.charAt(index);

        switch (currDigit) {
            case '2': {
                generate(digits, index + 1, curr + 'a', res);
                generate(digits, index + 1, curr + 'b', res);
                generate(digits, index + 1, curr + 'c', res);
                break;
            }
            case '3': {
                generate(digits, index + 1, curr + 'd', res);
                generate(digits, index + 1, curr + 'e', res);
                generate(digits, index + 1, curr + 'f', res);
                break;
            }
            case '4': {
                generate(digits, index + 1, curr + 'g', res);
                generate(digits, index + 1, curr + 'h', res);
                generate(digits, index + 1, curr + 'i', res);
                break;
            }
            case '5': {
                generate(digits, index + 1, curr + 'j', res);
                generate(digits, index + 1, curr + 'k', res);
                generate(digits, index + 1, curr + 'l', res);
                break;
            }
            case '6': {
                generate(digits, index + 1, curr + 'm', res);
                generate(digits, index + 1, curr + 'n', res);
                generate(digits, index + 1, curr + 'o', res);
                break;
            }
            case '7': {
                generate(digits, index + 1, curr + 'p', res);
                generate(digits, index + 1, curr + 'q', res);
                generate(digits, index + 1, curr + 'r', res);
                generate(digits, index + 1, curr + 's', res);
                break;
            }
            case '8': {
                generate(digits, index + 1, curr + 't', res);
                generate(digits, index + 1, curr + 'u', res);
                generate(digits, index + 1, curr + 'v', res);
                break;
            }
            case '9': {
                generate(digits, index + 1, curr + 'w', res);
                generate(digits, index + 1, curr + 'x', res);
                generate(digits, index + 1, curr + 'y', res);
                generate(digits, index + 1, curr + 'z', res);
                break;
            }
        }
    }
}
