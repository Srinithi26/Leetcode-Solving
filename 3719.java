class Solution {
    public int longestBalanced(int[] nums) {
        int maxl = 0;

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> e = new HashSet<>();
            HashSet<Integer> o = new HashSet<>();
            
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0)
                    e.add(nums[j]);
                else
                    o.add(nums[j]);

                if (e.size() == o.size())
                    maxl = Math.max(maxl, j - i + 1);
            }
        }

        return maxl;
    }
}