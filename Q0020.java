import java.util.Stack;


public class Q0020 {
    public boolean isValid(String s) {
        char[] strArray = s.toCharArray();

        int strLength = strArray.length;

        Stack<Character> tmp = new Stack<>();

        for (int i = 0; i < strLength; i++) {
            char curr = strArray[i];
            if (!tmp.empty()) {
                if (curr == '(' || curr == '{' || curr == '[') {
                    tmp.push(curr);
                } else {
                    char top = tmp.pop();
                    switch (curr) {
                        case ')':
                            if (top != '(') return false;
                            break;
                        case '}':
                            if (top != '{') return false;
                            break;
                        case ']':
                            if (top != '[') return false;
                            break;
                        default:
                            return false;
                    }
                }
            } else {
                tmp.push(curr);
            }

        }

        return tmp.empty();
    }

}
