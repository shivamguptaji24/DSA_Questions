---

# 🔺 Pascal's Triangle  

## 📝 Problem Statement  
This problem has **3 variations :**  

### 📌 **Variation 1:**  
Given row number `r` and column number `c`. **Print the element** at position `(r, c)` in Pascal’s Triangle.  

### 📌 **Variation 2:**  
Given the row number `n`. **Print the `n`-th row** of Pascal’s Triangle.  

### 📌 **Variation 3:**  
Given the number of rows `n`. **Print the first `n` rows** of Pascal’s Triangle.  

---

## 🔍 Example 1  
**Input:**  
```
N = 5, r = 5, c = 3
```

**Result:**  
```
6 (for Variation 1)
1 4 6 4 1 (for Variation 2)

1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1    (for Variation 3)
```

**Explanation:**  
- The element at position `(5, 3)` is **6**.  
- The **5th row** is `{1, 4, 6, 4, 1}`.  
- The first **5 rows** of Pascal’s Triangle are shown accordingly.  

---

## 🔍 Example 2  
**Input:**  
```
N = 1, r = 1, c = 1
```

**Result:**  
```
1 (for Variation 1)
1 (for Variation 2)
1 (for Variation 3)
```

**Explanation:**  
The output matrix has only **1 row** with the number **1**.  

---

## 💡 How Pascal's Triangle Works  
- Each number is the **sum** of the two numbers directly above it.  
- The outer edges are always **1**.  

### 🔹 Pascal's Triangle Pattern  
```
       1
      1 1
     1 2 1
    1 3 3 1
   1 4 6 4 1
```

---

## 🚀 Solution Approach  
✅ **Variation 1:**  
- Use the combination formula:  
\[
C(r-1, c-1) = \frac{(r-1)!}{(c-1)! \times ((r-c)!)}
\]

✅ **Variation 2:**  
- For each element in the row:  
\[
C(n-1, k)
\]

✅ **Variation 3:**  
- Build the triangle row by row using combinations or iterative logic.  

---
