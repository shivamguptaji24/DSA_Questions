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
