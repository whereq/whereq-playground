class Solution:
  def isPalindromeByRegex(self, oriString: str) -> bool:
    import re

    newString = re.sub("[^0-9a-z]", '', oriString.lower())
    return newString == newString[::-1]

  def isPalindromeBySinglyList(self, oriString: str) -> bool:


if __name__ == '__main__':
  solution = Solution()
  s = "A man, a plan, a canal: Panama"
  print(solution.isPalindromeByRegex(s))

  s = "ab_a"
  print(solution.isPalindromeByRegex(s))

