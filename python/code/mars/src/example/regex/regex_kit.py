import re

class RegexKit:
  def __init__(self):
    # Initialization code goes here
    pass

  def pattern_matching(self, pattern, string):
    # A match object is truthy, so you can use it in a Boolean context like a conditional statement:
    return re.match(pattern, string)

  def match(self, pattern, string):
    return re.match(pattern, string)

  def search(self, pattern, string):
    return re.search(pattern, string)

  def find_all(self, pattern, string):
    return re.findall(pattern, string)

  def split(self, pattern, string):
    return re.split(pattern, string)  # matches one or more digits
