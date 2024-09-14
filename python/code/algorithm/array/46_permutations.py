from typing import List

class Solution:

  """
  Without using recursive
  """
  def permuteWithoutRecursive(self, nums: List[int]) -> List[List[int]]:
    if len(nums) <= 1:
      return [nums]

    result = [[nums[0]]]
    index = 1
    while index < len(nums):
      tmp = []
      for permutation in result:
        for i in range(index + 1):
          tmp.append(permutation[:i] + [nums[index]] + permutation[i:])
      result = tmp
      index += 1

    return result

  """
  Two by two swap
  """
  def permute2b2Swap(self, nums: List[int]) -> List[List[int]]:
    result, length = list(), len(nums)

    def _permute2b2Swap(i):
      if (i == length):
        result.append(nums.copy())
        return 

      for j in range(i, length):
        nums[i], nums[j] = nums[j], nums[i]
        _permute2b2Swap(i + 1)
        nums[j], nums[i] = nums[i], nums[j]
      
    _permute2b2Swap(0)
    return result

  """
  The basic backtrace solution
  """
  def permuteBacktrace(self, nums: List[int]) -> List[List[int]]:
    result, permutation = [], []

    def _permuteBacktrace(nums, pos, result, permutation):
      if (pos == len(nums)):
        result.append(permutation.copy())
        return
      
      for i in range(0, len(nums)):
        if (nums[i] in permutation):
          continue

        permutation.append(nums[i])
        _permuteBacktrace(nums, pos + 1, result, permutation)
        permutation.pop()

      return

    _permuteBacktrace(nums, 0, result, permutation)
    return result



if __name__ == '__main__':
  nums = [1,2,3]
  solution = Solution()
  # result = solution.permuteWithoutRecursive(nums)
  # result = solution.permute2b2Swap(nums)
  result = solution.permuteBacktrace(nums)
  print(result)

