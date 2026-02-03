class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        sl = SortedList(nums[1:dist + 2])
        cur_sum = sum(sl[:k-1])
        ans = nums[0] + cur_sum

        for i in range(dist + 2, len(nums)):
            if sl.index(nums[i - dist - 1]) < k - 1:
                cur_sum -= nums[i - dist - 1]
                if len(sl) > k - 1:
                    cur_sum += sl[k-1]
            sl.remove(nums[i - dist - 1])

            sl.add(nums[i])
            if sl.index(nums[i]) < k - 1:
                cur_sum += nums[i]
                if len(sl) > k - 1:
                    cur_sum -= sl[k-1]

            ans = min(ans, nums[0] + cur_sum)

        return ans