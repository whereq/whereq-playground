class ListNode:
  def __init__(self, val=0, next=None):
    self.val = val 
    self.next = next 

  @staticmethod
  def show(head):
    if head is None:
      return
    
    i = 0
    while (head is not None):
      print ("#%d is %d"%(i, head.val))
      head = head.next
      i = i + 1

  @staticmethod
  def build(length):
    head = ListNode(0, None)
    current = head

    i = 0
    while (i < length):
      i = i + 1
      temp = ListNode(i, None)
      current.next = temp
      current = temp

    return head

  @staticmethod
  def buildEmptyList():
    return None

  @staticmethod
  def buildSortedList(length):
    import random

    base = random.randint(0, 10)
    head = ListNode(base, None)
    current = head

    i = 0
    while (i < length):
      i = i + 1
      base = base + random.randint(0, i + 3)
      temp = ListNode(base, None)
      current.next = temp
      current = temp

    return head

  @staticmethod
  def buildRandomList(length):
    import random

    head = ListNode(random.randint(0, 9), None)
    current = head

    i = 0
    while (i < length):
      temp = ListNode(random.randint(0, 9), None)
      current.next = temp
      current = temp
      i += 1

    return head

  @staticmethod
  def array2ist(nums):

    dummyHead = ListNode()
    current = dummyHead

    for num in nums:
      current.next = ListNode(num)
      current = current.next

    return dummyHead.next 
