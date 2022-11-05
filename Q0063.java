public class Q0063 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] res = new int[rows][cols];
        res[0][0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    res[row][col] = 0;
                } else if (row == 0 && col != 0) {
                    res[row][col] = res[row][col - 1];
                } else if (col == 0 && row != 0) {
                    res[row][col] = res[row - 1][col];
                } else if (col != 0 && row != 0) {
                    res[row][col] = res[row][col - 1] + res[row - 1][col];
                }

            }
        }
        return res[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0
                , 1, 0}, {0, 0, 0}}));
    }
}
