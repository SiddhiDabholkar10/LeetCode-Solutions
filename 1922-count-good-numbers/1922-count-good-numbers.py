class Solution:
    def countGoodNumbers(self, n: int) -> int:
        mod = 10**9 + 7
        even_positions = (n + 1) // 2
        odd_positions = n // 2
        # Even positions: 5 choices (0, 2, 4, 6, 8)
        ways_for_even_positions = pow(5, even_positions, mod)

        # Odd positions: 4 choices (2, 3, 5, 7)
        ways_for_odd_positions = pow(4, odd_positions, mod)

     
        
        return (ways_for_even_positions * ways_for_odd_positions) % mod
        