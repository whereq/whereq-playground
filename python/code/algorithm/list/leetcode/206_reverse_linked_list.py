import sys
import os

sys.path.append(os.getcwd())


from list.list_node import ListNode

"""
Runtime: 24 ms, faster than 99.17% of Python3 online submissions for Reverse Linked List.
Memory Usage: 15.7 MB, less than 42.36% of Python3 online submissions for Reverse Linked List.
"""
def reverseSingle(head: ListNode) -> ListNode:
  prev, curr, next = None, head, None

  while (curr is not None):
    next = curr.next
    curr.next = prev
    prev = curr
    curr = next
  
  return prev 

"""
Runtime: 36 ms, faster than 61.62% of Python3 online submissions for Reverse Linked List.
Memory Usage: 15.7 MB, less than 42.36% of Python3 online submissions for Reverse Linked List.
"""
def reverseTuple(head: ListNode) -> ListNode:
  prev, curr = None, head

  while (curr is not None):
    prev, prev.next, curr = curr, prev, curr.next

  return prev 

def test():
  head = ListNode.build(5)

  print("original list")
  ListNode.show(head)

  print("reversed list by single assignment")
  ListNode.show(reverseSingle(head))

  head = ListNode.build(5)
  print("reversed list by tuple assignment")
  ListNode.show(reverseTuple(head))

if __name__ == "__main__":
  test()

