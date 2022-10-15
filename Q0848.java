import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Q0848 {
    public static char shiftOne(char c, long shift) {
        return (char) ((c - 'a' + shift) % 26 + 'a');
    }

    public static String shiftingLetters(String s, int[] shifts) {
        IntUnaryOperator mod26 = x -> x % 26;
        char[] sArray = s.toCharArray();
        StringBuilder res = new StringBuilder();
        long[] finalShifts = new long[shifts.length];
        int[] newShifts = Arrays.stream(shifts).map(x -> x % 26).toArray();
        long totalShift = Arrays.stream(newShifts).sum();
        for (int i = 0; i < shifts.length; i++) {
            finalShifts[i] = totalShift;
            totalShift -= newShifts[i];
        }
        for (int i = 0; i < finalShifts.length; i++) {
            res.append(shiftOne(sArray[i], finalShifts[i]));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        shiftingLetters("mkgfzkkuxownxvfvxasy",
                new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513});
    }
}
