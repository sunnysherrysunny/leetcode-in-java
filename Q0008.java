public class Q0008 {
    public static int myAtoi(String s) {
        s = s.trim();
        long res = 0;
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) {
            return 0;
        }
        boolean sign = true;
        boolean isLeadingZero = true;
        int start = 0;
        if (charArray[0] == '-') {
            sign = false;
            start = 1;
        } else if (charArray[0] == '+') {
            start = 1;
        }

        for (int i = start; i < charArray.length; i++) {
            Character curr = charArray[i];
            if (!Character.isDigit(curr)) {
                break;
            } else {
                if (isLeadingZero) {
                    if (curr == '0') {
                        continue;
                    } else {
                        isLeadingZero = false;
                        res = (curr - '0');
                    }
                } else {
                    res = res * 10 + (curr - '0');
                    if (sign && res > Integer.MAX_VALUE) {
                        res = Integer.MAX_VALUE;
                        break;
                    } else if (!sign && res > ((long) Integer.MAX_VALUE + 1)) {
                        res = Integer.MAX_VALUE + 1;
                        break;
                    }
                }
            }
        }
        if (!sign) {
            res = -res;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("     -42  word    "));
    }
}


