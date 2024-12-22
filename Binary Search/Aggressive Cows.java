class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = 0;
        for (int i = 0; i < stalls.length; i++) {
            high = Math.max(high, stalls[i]);
        }
        int middle = 0;
        int answer = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            int numberOfCowsAlloted = fetchNumberOfCowsAlloted(stalls, middle);
            if (numberOfCowsAlloted < k) {
                high = middle - 1;
            }
            else {
                answer = middle;
                low = middle + 1;
            }
        }
        return answer;
    }
    private static int fetchNumberOfCowsAlloted(int[] stalls, int maxDistBetweenAnyTwoCows) {
        int totalCowsAlloted = 1;
        int lastPosition = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= maxDistBetweenAnyTwoCows) {
                totalCowsAlloted++;
                lastPosition = stalls[i];
            }
        }
        return totalCowsAlloted;
    }
}