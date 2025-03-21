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

/*-------------------------------------------------------------------------------------------------------------------------*/

// Variation 2

/*
It can be solve by two approach :-
  1. Naive Approach
  2. Optimal Approach
*/

// Naive Approach

/*
In this approach, for every column from 1 to n, we will calculate the element (n, c)(where n is the given row number and c is the column number that will vary from 1 to n) using the previous method. Thus, we will print the row.  

Approach:
The steps are as follows:

1. We will use a loop(say c) to iterate over each column i.e. from 1 to n. And for each column, we will do the following steps:
      a. First, we will consider n-1 as n and c-1 as r.
      b. After that, we will simply calculate the value of the combination using a loop. 
      c. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
      d. Finally, we will print the element.
2. Finally, the entire row will be printed.

Time Complexity: O(n*r), where n is the given row number, and r is the column index which can vary from 0 to n-1.
Reason: We are calculating the element for each column. Now, there are total n columns, and for each column, the calculation of the element takes O(r) time where r is the column index.
Space Complexity: O(1) as we are not using any extra space.
*/

class Solution {
    public long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Generating the entire row `rowIndex`:
        for (int col = 0; col <= rowIndex; col++) {
            row.add((int) nCr(rowIndex, col));
        }
        return row;
    }
}

// Optimal Approach

/*
We will try to build intuition for this approach using the following observations.

Here, we can observe that the numbers marked in red are added to the previous number to build the current number. In each step, the numerator is multiplied by the previous consecutive element, and the denominator is multiplied by the next consecutive element.
We will replicate this in our algorithm. First, we will mark the indices of the column starting from 0. Then we will simply multiply the numerator by (n-index) and the denominator by the index itself.
From column no. 1 the formula will be the following:
Current element = prevElement * (rowNumber - colIndex) / colIndex

Approach:
The steps are as follows:

1. First, we will print the 1st element i.e. 1 manually.
2. After that, we will use a loop(say i) that runs from 1 to n-1. It will print the rest of the elements.
3. Inside the loop, we will use the above-said formula to print the element. We will multiply the previous answer by (n-i) and then divide it by i itself.
4. Thus, the entire row will be printed.
Note: If we want to store the row elements, we just need to store each element instead of printing it.

Time Complexity: O(N) where N = given row number. Here we are using only a single loop.
Space Complexity: O(1) as we not using any extra space.
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long ans = 1;
        row.add((int) ans); // Adding the first element (always 1)

        // Generate the rest of the row:
        for (int i = 1; i <= rowIndex; i++) {
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;
            row.add((int) ans);
        }
        return row;
    }
}

/*-------------------------------------------------------------------------------------------------------------------------*/

// Variation 3

/*
It can be solve by two approach :-
  1. Naive Approach
  2. Optimal Approach
*/

// Naive Approach

/*
The naive approach is basically a combination of variation 1 and variation 2. Here, for every row from 1 to n, we will try to generate all the row elements by simply using the naive approach of variation 2. So, we will use the same code as variation 2(naive approach), inside a loop (i.e. row runs from 1 to n).

Approach:
The steps are as follows:

1. First, we will run a loop(say row) from 1 to n.
2. We will use a loop(say col) to iterate over each column i.e. from 1 to n. And inside the nested loops, we will do the following steps:
      a. First, we will consider row-1 as n and col-1 as r.
      b. After that, we will simply calculate the value of the combination using a loop. 
      c. The loop will run from 0 to r. And in each iteration, we will multiply (n-i) with the result and divide the result by (i+1).
      d. Finally, we will add the element to a temporary list.
3. After calculating all the elements for all columns of a row, we will add the temporary list to our final answer list.
4. Finally, we will return the answer list.

Time Complexity: O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
Reason: The row loop will run for approximately n times. And generating a row using the naive approach of variation 2 takes O(n*r) time complexity.
Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can be still considered as O(1).
*/

class Solution {
    public int nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int row = 1; row <= numRows; row++) {
            List<Integer> tempLst = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }
}

// Optimal Approach

/*
Now, in the optimal approach of variation 2, we have learned how to generate a row in O(n) time complexity. So, in order to optimize the overall time complexity, we will be using that approach for every row. Thus the total time complexity will reduce.

Approach:
The steps are as follows:

1. First, we will run a loop(say row) from 1 to n.
2. Inside the loop, we will call a generateRow() function and add the returned list to our final answer. Inside the function we will do the following:
      a. First, we will store the 1st element i.e. 1 manually.
      b. After that, we will use a loop(say col) that runs from 1 to n-1. It will store the rest of the elements.
      c. Inside the loop, we will use the specified formula to print the element. We will multiply the previous answer by (row-col) and then divide it by col itself.
      d. Thus, the entire row will be stored and returned.
3. Finally, we will return the answer list.

Time Complexity: O(n2), where n = number of rows(given).
Reason: We are generating a row for each single row. The number of rows is n. And generating an entire row takes O(n) time complexity.
Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can still be considered as O(1).
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Generate Pascal's Triangle row by row
        for(int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }

        return ans;
    }

    public List<Integer> generateRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);  // First element is always 1

        // Calculating the remaining elements using nCr formula
        for(int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans);
        }

        return ansRow;
    }
}
