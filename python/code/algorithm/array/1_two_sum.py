class Solution:
  def twoSum(self, nums: List[int], target: int) -> List[int]:
    tempMap = {}
    for i, num in enumerate(nums):
      k = target - num

      if (k in tempMap):
        return [tempMap[k], i]
      else:
        tempMap[num] = i
    
    return []
