class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int bestScore = -1;
        int answer = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int score = 0;
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }
            if (score > bestScore) {
                bestScore = score;
                answer = divisor;
            } else if (score == bestScore && divisor < answer) {
                answer = divisor;
            }
        }
        return answer;
    }
}