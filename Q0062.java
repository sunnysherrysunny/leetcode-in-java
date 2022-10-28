public class Q0062 {

//    public static int dfs(int m, int n, int currRow, int currCol){
//        if (currRow == m - 1 && currCol == n - 1){
//            return 1;
//        }
//        if (currRow == m - 1) {
//            return dfs(m, n ,currRow, currCol + 1);
//        }
//        if (currCol == n - 1) {
//            return dfs(m, n, currRow + 1, currCol);
//        }
//        return dfs(m, n ,currRow, currCol + 1) + dfs(m, n, currRow + 1, currCol);
//    }
//
//
//    public static int uniquePaths(int m, int n) {
//        return dfs(m, n, 0, 0);
//    }


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
