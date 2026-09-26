import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LCS {
    public static class LCSResult {
        public final int length;
        public final int[][] dp;

        public LCSResult(int length, int[][] dp) {
            this.length = length;
            this.dp = dp;
        }
    }

    public static LCSResult lcsLength(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return new LCSResult(dp[m][n], dp);
    }

    public static String buildLCS(String x, String y, int[][] dp) {
        int i = x.length();
        int j = y.length();
        List<Character> result = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result.add(x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        Collections.reverse(result);
        StringBuilder lcs = new StringBuilder();
        for (char c : result) {
            lcs.append(c);
        }
        return lcs.toString();
    }

    public static void main(String[] args) {
        String x = "VASAI";
        String y = "SAI";

        LCSResult result = lcsLength(x, y);
        String subsequence = buildLCS(x, y, result.dp);

        System.out.println("LCS length: " + result.length);
        System.out.println("LCS: " + subsequence);
    }
}