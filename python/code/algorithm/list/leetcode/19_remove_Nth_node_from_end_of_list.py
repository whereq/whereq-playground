import sys
import os

sys.path.append(os.getcwd())

from list.list_node import ListNode

class Solution:

    """
    Runtime: 32 ms, faster than 75.39% of Python3 online submissions for Remove Nth Node From End of List.
    Memory Usage: 14.3 MB, less than 48.46% of Python3 online submissions for Remove Nth Node From End of List.
    """
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:

      def _getLength(head):
        i = 0
        while(head):
          i, head = i + 1, head.next
        return i

      pos = _getLength(head) - n
      if (pos < 0):
        return head

      prev = current = head
      i = 0
      while (current):
        if (i == pos):
          if (i == 0):
            head = head.next
            break
           
          prev.next = current.next
          break

        prev, current, i = current, current.next, i + 1
      
      return head
    
if __name__ == '__main__':

  list = ListNode.array2ist([5,6,4,9])
  # list = ListNode.array2ist([1])

  solution = Solution()
  result = solution.removeNthFromEnd(list, 4)

  ListNode.show(result)


