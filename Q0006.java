public class Q0006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        //String res = "";

        int length = s.length();
        char[] res = new char[length];
        int index = 0;
        int next = 0;
        int step = numRows * 2 - 2;
        //Row 0
        for (int i = 0; i < length; i += step) {
            res[index] = s.charAt(i);
            index++;
        }

        for (int row = 1; row < numRows - 1; row++) {
            next = step - row - row;
            for (int i = row; i < length; i += step) {
                res[index] = s.charAt(i);
                index++;
                if (i + next < length) {
                    res[index] = s.charAt(i + next);
                    index++;
                }
            }
        }
        //Row numRows-1
        for (int i = numRows - 1; i < length; i += step) {
            res[index] = s.charAt(i);
            index++;
        }
        return String.valueOf(res);
    }
}
