---

# 🚩 Sort Colors (0s, 1s, and 2s) — Dutch National Flag Algorithm  

## 📝 Problem Statement  
Given an array consisting of only `0`s, `1`s, and `2`s, write a program to **in-place sort** the array without using any inbuilt sort functions.  

✅ **Expected Complexity:**  
- **Time Complexity:** `O(N)` (Single pass)  
- **Space Complexity:** `O(1)` (Constant space)  

---

## 🔍 Example 1  
**Input:**  
```
nums = [2, 0, 2, 1, 1, 0]
```

**Output:**  
```
[0, 0, 1, 1, 2, 2]
```

---

## 🔍 Example 2  
**Input:**  
```
nums = [2, 0, 1]
```

**Output:**  
```
[0, 1, 2]
```

---

## 🔍 Example 3  
**Input:**  
```
nums = [0]
```

**Output:**  
```
[0]
```

---

## 💡 Constraints  
- `1 <= nums.length <= 300`  
- `nums[i]` is either `0`, `1`, or `2`.  

---

## 🚀 Solution Approach (Dutch National Flag Algorithm)  
To efficiently solve this problem in **one pass** with **constant space**:  

✅ Use **three pointers**:  
- `low` → Tracks the position for `0`s.  
- `mid` → Traverses the array.  
- `high` → Tracks the position for `2`s.  

✅ Algorithm Steps:  
1. Initialize `low = 0`, `mid = 0`, and `high = nums.length - 1`.  
2. Traverse the array while `mid <= high`:  
   - If `nums[mid] == 0` → **Swap `nums[mid]` with `nums[low]`**, then increment both `low` and `mid`.  
   - If `nums[mid] == 1` → Leave it as is and increment `mid`.  
   - If `nums[mid] == 2` → **Swap `nums[mid]` with `nums[high]`**, then decrement `high`.  
3. The array will be sorted in **one pass**.  

---
