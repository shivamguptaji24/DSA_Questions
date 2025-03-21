/*
This problem has three variations :
  1. Variation 1(No Direct Problem): Given row number r and column number c. Print the element at position (r, c) in Pascal's triangle.
  2. Variation 2(Leetcode 119): Given the row number n. Print the n-th row of Pascal's triangle.
  3. Variation 3(Leetcode 118: Given the number of rows n. Print the first n rows of Pascal's triangle.
*/

// Variation 1

/*
We can optimize this calculation by the following observation. 
Assume, given r = 7, c = 4. 
Now, n = r-1 = 7-1 = 6 and r = c-1 = 4-1 = 3
Let’s calculate 6C3 = 6! / (3! *(6-3)!) = (6*5*4*3*2*1) / ((3*2*1)*(3*2*1))
This will boil down to (6*5*4) / (3*2*1)
So, nCr = (n*(n-1)*(n-2)*.....*(n-r+1)) / (r*(r-1)*(r-2)*....1)
                                
Now, we will use this optimized formula to calculate the value of nCr. But while implementing this into code we will take the denominator in the forward direction like: 

(n / 1)*((n-1) / 2)*.....*((n-r+1) / r).
The code will be like the following:


Approach:
The steps are as follows:

1. First, we will consider r-1 as n and c-1 as r.
2. After that, we will simply calculate the value of the combination using a loop. 
3. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
4. Finally, the calculated value of the combination will be our answer.

Time Complexity: O(c), where c = given column number.
Reason: We are running a loop for r times, where r is c-1.
Space Complexity: O(1) as we are not using any extra space.
*/

class Solution {
    public int maxSubArray(int n, int r) {
      int res = 1;

      for(int i = 0; i < r; i++) {
        res = res * (n - 1);
        res = res / (i + 1);
      }

      return res;
    }
}
