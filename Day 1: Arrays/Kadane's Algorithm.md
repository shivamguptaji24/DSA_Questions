---

# 🔥 Kadane's Algorithm: Maximum Subarray Sum in an Array  

## 📝 Problem Statement  
Given an integer array `arr`, find the **contiguous subarray** (containing at least one number) that has the **largest sum** and return its sum. Additionally, print the subarray.  

---

## 🔍 Example 1  
**Input:**  
```
arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

**Output:**  
```
6
```

**Explanation:**  
The subarray `[4, -1, 2, 1]` has the largest sum = **6**.  

---

## 🔍 Example 2  
**Input:**  
```
arr = [1]
```

**Output:**  
```
1
```

**Explanation:**  
The array has only one element, and that element itself gives the maximum sum = **1**.  

---

## 💡 Constraints  
- `1 <= arr.length <= 10^5`  
- `-10^4 <= arr[i] <= 10^4`  

---

## 🚀 Solution Approach (Kadane’s Algorithm)  
To efficiently solve this problem:  
✅ Initialize two variables:  
- `maxSum` → Tracks the **maximum sum** found so far.  
- `currentSum` → Tracks the **current subarray sum** while iterating.  

✅ Iterate through the array:  
- Continuously add elements to `currentSum`.  
- If `currentSum` becomes negative, reset it to **0** (start a new subarray).  
- Update `maxSum` whenever `currentSum` exceeds its value.  

✅ Print the maximum subarray sum and the subarray itself.

---
