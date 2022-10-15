import java.util.ArrayList;
import java.util.List;

public class Q0054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int width = matrix[0].length;
        int height = matrix.length;
        int horizontalCount = width;
        int verticalCount = height - 1;
        int count = horizontalCount;
        boolean isHorizontal = true;
        boolean isLeft = true;
        boolean isDown = true;
        int currRow = 0;
        int currCol = -1;
        for (int i = 0; i < width * height; i++) {
            count--;
            if (isHorizontal) {
                if (isLeft) {
                    currCol += 1;
                } else {
                    currCol -= 1;
                }
                res.add(matrix[currRow][currCol]);
                if (count == 0) {
                    isHorizontal = false;
                    isLeft = !isLeft;
                    horizontalCount--;
                    count = verticalCount;
                }
            } else {
                if (isDown) {
                    currRow += 1;
                } else {
                    currRow -= 1;
                }
                res.add(matrix[currRow][currCol]);
                if (count == 0) {
                    isHorizontal = true;
                    isDown = !isDown;
                    verticalCount--;
                    count = horizontalCount;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
