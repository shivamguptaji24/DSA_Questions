---

# 🔢 Set Matrix Zero  

## 📝 Problem Statement  
Given a **matrix**, if an element in the matrix is `0`, then **set its entire row and column to `0`** and return the updated matrix.  

---

## 🔍 Example 1  
**Input:**  
```python
matrix = [[1,1,1],
          [1,0,1],
          [1,1,1]]
```

**Output:**  
```python
[[1,0,1],
 [0,0,0],
 [1,0,1]]
```

**Explanation:**  
Since `matrix[1][1] = 0`, the **2nd row and 2nd column** will be set to `0`.  

---

## 🔍 Example 2  
**Input:**  
```python
matrix = [[0,1,2,0],
          [3,4,5,2],
          [1,3,1,5]]
```

**Output:**  
```python
[[0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]]
```

**Explanation:**  
- `matrix[0][0] = 0` and `matrix[0][3] = 0`.  
- Therefore, the **1st row, 1st column, and 4th column** will be set to `0`.  

---

## 💡 Constraints  
- `1 <= matrix.length, matrix[0].length <= 200`  
- `-10^9 <= matrix[i][j] <= 10^9`  

---

## 🚀 Solution Approach  
✅ **Brute Force Approach (O(N³))**  
1. Traverse the matrix and mark the rows & columns that contain `0`.  
2. Set the marked rows and columns to `0`.  

✅ **Optimized Approach (O(N²))**  
1. Use two arrays (`row` and `col`) to track rows and columns that need to be set to `0`.  
2. Traverse the matrix and update rows/columns accordingly.  

✅ **Space-Optimized Approach (O(1) Extra Space)**  
1. Use the **first row and first column** as markers instead of extra arrays.  
2. Process the matrix in-place for efficient space utilization.  

---
