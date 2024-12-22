class Solution {
    public static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int low = 0;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        int middle = 0;
        int answer = low;
        while (low <= high) {
            middle = (low + high) / 2;
            int totalStudentsGotBooks = fetchTotalStudentsGotBooks(arr, middle);
            if (totalStudentsGotBooks <= k) {
                answer = middle;
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return answer;
    }
    private static int fetchTotalStudentsGotBooks(int[] arr, int maxNumberOfPagesAssignedToAnyStud) {
        int totalStudent = 1;
        int numberOfPagesAssigned = arr[0];
        for (int i = 1; i < arr.length; i++) {
            numberOfPagesAssigned += arr[i];
            if (numberOfPagesAssigned > maxNumberOfPagesAssignedToAnyStud) {
                totalStudent++;
                numberOfPagesAssigned = arr[i];
            }
        }
        return totalStudent;
    } 
}