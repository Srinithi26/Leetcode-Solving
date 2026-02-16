class Solution:
    def sumZero(self, n: int) -> List[int]:
        answer = list(range(1,n))
        answer.append(-(sum(answer)))
        return answer
       