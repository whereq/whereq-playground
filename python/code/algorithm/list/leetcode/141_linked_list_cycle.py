import sys
import os

sys.path.append(os.getcwd())

from list.list_node import ListNode

class Solution:
  def hasCycleBySet(self, head: ListNode) -> bool:
    tempSet = set() 
    while (head):
      if (head.next):
        if (head.next in tempSet):
          return True
        else:
          tempSet.add(head.next)
          head = head.next
    return False

  """
  Runtime: 56 ms, faster than 51.53% of Python3 online submissions for Linked List Cycle.
  Memory Usage: 17.6 MB, less than 75.05% of Python3 online submissions for Linked List Cycle.
  """
  def hasCycleByFastSlowPointer(self, head: ListNode) -> bool:
    if (not (head and head.next)):
      return False

    slow = fast = head
    while (slow and fast and fast.next):
      slow = slow.next
      fast = fast.next.next
      if (slow is fast):
        return True

    return False

if __name__ == '__main__':
  head = ListNode.build(2)
  solution = Solution()
  result = solution.hasCycleByFastSlowPointer(head)
  print (result)
    



