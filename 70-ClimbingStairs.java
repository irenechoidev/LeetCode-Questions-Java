class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}

// [1 1 2 3 5 8 ]
// 0 1 2 3 4 5

// pattern recognition (each dp problem has a pattern)
// - this pattern is how you combine solution to sub-problems

// base case - do not use other subproblems
// every other case - combine solution to subproblems
