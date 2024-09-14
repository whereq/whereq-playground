import sys
import os

sys.path.append(os.getcwd())

from list.list_node import ListNode

class Solution:
    """
    Runtime: 56 ms, faster than 98.92% of Python3 online submissions for Add Two Numbers.
    Memory Usage: 14.5 MB, less than 11.39% of Python3 online submissions for Add Two Numbers.
    """
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:

      dummyHead = ListNode()
      current = dummyHead

      def _add(d):
        nonlocal current
        temp = ListNode(d % 10)
        current.next = temp 
        current = temp
        return d // 10

      t = 0
      while (l1 and l2):
        t = _add(l1.val + l2.val + t)
        l1, l2 = l1.next, l2.next
      
      l3 = l1 if l1 else l2

      while (l3):
        t = _add(l3.val + t)
        l3 = l3.next

      if (t > 0):
        temp = ListNode(t)
        current.next = temp
        current = temp

      return dummyHead.next 
      
if __name__ == '__main__':

  # l1 = ListNode.array2ist([9,9,9,9,9,9])
  # l2 = ListNode.array2ist([9,9,9,9])

  # l1 = ListNode.array2ist([2,4,9])
  # l2 = ListNode.array2ist([5,6,4,9])

  l1 = ListNode.array2ist([9,9,1])
  l2 = ListNode.array2ist([1])
  print ("------------------l1------------------")
  ListNode.show(l1)
  print ("------------------l2------------------")
  ListNode.show(l2)
  solution = Solution();
  result = solution.addTwoNumbers(l1, l2)
  # result = solution.addTwoNumbersRecursive(l1, l2)
  print ("----------------result----------------")
  ListNode.show(result)




      