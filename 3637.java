class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; // minimum length needed

        int i = 0;

        //  strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false; // no increase

        // strictly decreasing
        int j = i;
        while (j + 1 < n && nums[j] > nums[j + 1]) {
            j++;
        }
        if (j == i) return false; // no decrease

        //strictly increasing again
        int k = j;
        while (k + 1 < n && nums[k] < nums[k + 1]) {
            k++;
        }

        // third phase must exist AND reach the end
        return k > j && k == n - 1;
    }
}
