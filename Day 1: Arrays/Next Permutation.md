---

# 🔄 Next Permutation  

## 📝 Problem Statement  
Given an array `Arr[]` of integers, rearrange the numbers of the given array into the **lexicographically next greater permutation** of numbers.  

If such an arrangement is **not possible**, it must be rearranged to the **lowest possible order** (i.e., sorted in ascending order).  

---

## 🔍 Example 1  
**Input:**  
```
Arr[] = {1, 3, 2}
```

**Output:**  
```
Arr[] = {2, 1, 3}
```

**Explanation:**  
All permutations of `{1, 2, 3}` are:  
`{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}`  

The **next permutation** just after `{1, 3, 2}` is `{2, 1, 3}`.  

---

## 🔍 Example 2  
**Input:**  
```
Arr[] = {3, 2, 1}
```

**Output:**  
```
Arr[] = {1, 2, 3}
```

**Explanation:**  
All permutations of `{1, 2, 3}` show `{3, 2, 1}` at the **last position**. Therefore, the **next permutation** is the **smallest permutation**: `{1, 2, 3}`.  

---

## 💡 Constraints  
- `1 <= Arr.length <= 10000`  
- `-10^6 <= Arr[i] <= 10^6`  

---

## 🚀 Solution Approach  
To efficiently find the **next permutation**:  

✅ **Step 1:** Identify the **pivot** point (first number from the end that is smaller than its next number).  
✅ **Step 2:** Find the **successor** — the smallest number larger than the pivot, then swap them.  
✅ **Step 3:** Reverse the portion of the array **after the pivot's position** to get the next permutation.  
✅ If no pivot is found (array is in descending order), simply **reverse the array** to get the lowest possible order.  

---
