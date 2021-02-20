package matieral.dp;
import java.util.*;
import matieral.common_use.*;

/**
 * Test: https://leetcode.com/problems/paint-fence/ => Like
 * Test: https://leetcode.com/problems/paint-house/
 * Test: https://leetcode.com/problems/paint-house-ii/ => Like
 * Test: https://leetcode.com/problems/house-robber/ => Like
 * Test: https://leetcode.com/problems/house-robber-ii/
 * Test: https://leetcode.com/problems/house-robber-iii/
 */

public class LinearDP {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n - 1];
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 2) % 3], dp[i - 1][(j + 1) % 3]) + costs[i - 1][j];
            }
        }
        return Arrays.stream(dp[n]).min().getAsInt();
    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        if (costs[0].length == 1) return costs[0][0];
        int n = costs.length, k = costs[0].length;

        int[][] dp = new int[n + 1][k];
        int firstColor = 0, secondColor = 0;
        for (int i = 1; i <= n; i++) {
            int first = -1, second = -1;
            for (int j = 0; j < k; j++) {
                dp[i][j] = costs[i - 1][j] + (j == firstColor ? dp[i - 1][secondColor] : dp[i - 1][firstColor]);

                if (first == -1 || dp[i][j] < dp[i][first]) {
                    second = first;
                    first = j;
                }
                else if (second == -1 || dp[i][j] < dp[i][second]) second = j;
            }
            firstColor = first;
            secondColor = second;
        }

        return Arrays.stream(dp[n]).min().getAsInt();
    }

    public int rob(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean lastTaken) {
        if (root == null) {
            return 0;
        }

        if (lastTaken) {
            return helper(root.left, false) + helper(root.right, false);
        }
        else {
            int with = root.val + helper(root.left, true) + helper(root.right, true);
            int without = helper(root.left, false) + helper(root.right, false);
            return  Math.max(with, without);
        }
    }
}