from typing import List

class Solution:
  def solveNQueens(self, n: int) -> List[List[str]]:
    result = []

    col = [0] * n
    nw2se = [0] * (2 * n - 1)
    ne2sw = [0] * (2 * n - 1)

    def _buildBoard(row):
      board = ["" for i in range(n)]
      for i in range(n):
        board[i] = row[i] * '.' + 'Q' + '.' * (n - row[i] - 1)

      return board

    def _dropQueen(index, row):
      if index == n:
        result.append(_buildBoard(row))
        return

      for i in range(n):
        if not (col[i] or nw2se[index - i + n - 1] or ne2sw[index + i]):
          row.append(i)
          col[i], nw2se[index - i + n - 1], ne2sw[index + i] = 1, 1, 1
          _dropQueen(index + 1, row)
          col[i], nw2se[index - i + n - 1], ne2sw[index + i] = 0, 0, 0
          row.pop()

    _dropQueen(0, [])
    return result

if __name__ == '__main__':
  solution = Solution()
  result = solution.solveNQueens(4)
  print(result)


