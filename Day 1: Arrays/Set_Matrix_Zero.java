/*
It can be solve by two approach :-
  1. Brute Force Approach
  2. Better Approach
  3. Optimal Approach
*/

// Brute Force Approach

/*
Approach:
The steps are the following:

1. First, we will use two loops(nested loops) to traverse all the cells of the matrix.
2. If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
3. We will perform step 2 for every cell containing 0.
4. Finally, we will mark all the cells containing -1 with 0.
5. Thus the given matrix will be modified according to the question.

Note: Here, we are assuming that the matrix does not contain any negative numbers. But if it contains negatives, we need to find some other ways to mark the cells instead of marking them with -1.

Intuition:

This approach is very straightforward and we are just following the process stated in the question. But the following two questions need to be clarified to understand the algorithm further.
Why we are marking the cells with -1 and not with 0 directly:
Let’s try to understand this using the following example and in that example, we will try to mark the cells directly with 0.

First, we will find 0 at cell (1,1) (0-based indexing). For the cell, we will mark all the cells(except those that contain 0) of row 1 and column 1 with 0. So, the matrix, in this case, will look like the following:

Now, we will again find 0 at cell (1, 2). But this cell was initially 1, not 0. And only those cells which were initially 0 should modify the rows and columns. In this case, we will eventually mark the wrong rows and columns with 0. That is why we cannot mark the cells directly with 0. We have to choose a different number.
As in this case, we are assuming that the matrix does not contain any negative numbers, we are choosing -1 as our marker.

While marking the cells with -1, why we are not marking the cells that contain 0:
Again, let’s try to understand this using the following example and in that example, we will try to mark all the cells with -1.

First, we will find 0 at cell (1,1) (0-based indexing). For the cell, we will mark all the cells of row 1 and column 1 with -1. So, the matrix, in this case, will look like the following:

Now, we will not be able to find the value 0 that should be in the cell (1,3). And our algorithm will not modify column 3. That is why we cannot modify the cells with value 0 while marking the cells -1 as those cells with 0 will contribute to the answer.

Time Complexity: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
Another O(N*M) is taken to mark all the cells with -1 as 0 finally.
Space Complexity: O(1) as we are not using any extra space.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        // Step 1: Mark rows and columns with -1 (except 0s)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }

        // Step 2: Convert all -1 to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void markRow(int[][] matrix, int n, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    private void markCol(int[][] matrix, int n, int m, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }
}

/*-------------------------------------------------------------------------------------------------------------------------*/

// Better Approach

/*
In the previous approach, we were marking the row and column with -1 while traversing the matrix. Here we will reduce the time complexity by marking the cells after the traversal.

Approach (Using two extra arrays):

The steps are as follows:

1. First, we will declare two arrays: a row array of size N and a col array of size M and both are initialized with 0.
2. Then, we will use two loops(nested loops) to traverse all the cells of the matrix.
3. If any cell (i,j) contains the value 0, we will mark ith index of row array i.e. row[i] and jth index of col array col[j] as 1. It signifies that all the elements in the ith row and jth column will be 0 in the final matrix.
4. We will perform step 3 for every cell containing 0.
5. Finally, we will again traverse the entire matrix and we will put 0 into all the cells (i, j) for which either row[i] or col[j] is marked as 1.
6. Thus we will get our final matrix.
Intuition:

In the previous approach, we were marking the cells with -1 while traversing the matrix. But in this approach, we are not marking the entire row and column instead, we are marking the ith index of row array i.e. row[i], and jth index of col array i.e. col[j] with 1. These marked indices of the two arrays, row and col will tell us for which rows and columns we need to change the values to 0. For any cell (i, j), if the row[i] or col[j] is marked with 1, we will change the value of cell(i, j) to 0.

Here we are marking the cells after traversal whereas in the previous case, we were marking the cells while traversal. That is how the time complexity reduces in this case.

Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: We are traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: O(N) is for using the row array and O(M) is for using the col array.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] row = new int[n]; // Row marker array
        int[] col = new int[m]; // Column marker array

        // Step 1: Identify rows & columns that need to be set to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1; // Mark row i
                    col[j] = 1; // Mark column j
                }
            }
        }

        // Step 2: Set matrix elements to 0 based on the markers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*-------------------------------------------------------------------------------------------------------------------------*/

// Optimal Approach

/*
Intuition:
In the previous approach, the time complexity is minimal as the traversal of a matrix takes at least O(N*M)(where N = row and M = column). In this approach, we can just improve the space complexity. So, instead of using two extra matrices row and col, we will use the 1st row and 1st column of the given matrix to keep a track of the cells that need to be marked with 0. But here comes a problem. If we try to use the 1st row and 1st column to serve the purpose, the cell matrix[0][0] is taken twice. To solve this problem we will take an extra variable col0 initialized with 1. Now the entire 1st row of the matrix will serve the purpose of the row array. And the 1st column from (0,1) to (0,m-1) with the col0 variable will serve the purpose of the col array.

If any cell in the 0th row contains 0, we will mark matrix[0][0] as 0 and if any cell in the 0th column contains 0, we will mark the col0 variable as 0.
Thus we can optimize the space complexity.

Approach: 

The steps are as follows:

1. First, we will traverse the matrix and mark the proper cells of 1st row and 1st column with 0 accordingly. The marking will be like this: if cell(i, j) contains 0, we will mark the i-th row i.e. matrix[i][0] with 0 and we will mark j-th column i.e. matrix[0][j] with 0.
    If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark the col0 variable with 0 instead of marking matrix[0][0] again.
2. After step 1 is completed, we will modify the cells from (1,1) to (n-1, m-1) using the values from the 1st row, 1st column, and col0 variable.
    We will not modify the 1st row and 1st column of the matrix here as the modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is dependent on that row and column.
3. Finally, we will change the 1st row and column using the values from matrix[0][0] and col0 variable. Here also we will change the row first and then the column.
    If matrix[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
    If col0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.

Observations: Why in the second step, we are first marking the matrix from the cell (1,1) to (n-1, m-1) and not from (0,0):
Let’s understand this using the following example:

Now, we will try to apply step 1 in the above matrix, col0 will be 0 as (3,0) contains 0 and it will look like the following:

Now, in the second step we will try to start modifying the cells with value 0 from (0,0). First, we will change the value of (0,0) to 0 as col0 is marked with 0. After that, while checking for cell (0, 3) we will find that the value of (0,0) is 0. And we will again modify the cell (0,3) with 0. But this should not happen as (0,0) was initially 1 and that is why (0,3) should remain with the value 1.
This is why we cannot change the 1st row and 1st column on the first go as the rest of the matrix is dependent on them. If we do it, the modification of the matrix will be incorrect.

In the 3rd step, why we are marking the 1st row first and then the 1st column:
We can notice that the modification of the 1st row is dependent on matrix[0][0] and the modification of the 1st column is dependent on col0 which is an independent variable. Now, if we modify the 1st column first, matrix[0][0] might be changed and this will hinder the modification of the 1st row as well. But if we simply do the opposite, the 1st row will be changed first, based on the value matrix[0][0] and then the 1st column will be changed based on the variable col0. This is why the order of change matters.

Time Complexity: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
Reason: In this approach, we are also traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
Space Complexity: O(1) as we are not using any extra space.
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int col0 = 1; // Marker for the first column

        // Step 1: Mark the first row & column accordingly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark i-th row
                    matrix[i][0] = 0;

                    // Mark j-th column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Use the marks to set elements to zero (excluding first row & col)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Finally, set the first row and first column
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/*-----------------OR-----------------*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Step 1: Identify if first row/col needs to be set to zero
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // Step 2: Mark zeros in the first row & column for other elements
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: Set elements to zero based on first row/column makers
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Handle the first row and first column separately
        if(firstColZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(firstRowZero) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
