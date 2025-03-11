Here's the problem statement presented in a professional README format with clear structure and styling for your DSA repository:  

---

# 📈 Best Time to Buy and Sell Stock

## 📝 Problem Statement  
You are given an array of `prices` where `prices[i]` is the price of a given stock on the **i-th day**.  

You want to maximize your profit by choosing **a single day to buy** one stock and **a different day in the future to sell** that stock.  

**Return the maximum profit** you can achieve from this transaction.  
If you cannot achieve any profit, return **0**.

---

## 🔍 Example 1  
**Input:**  
```
prices = [7, 1, 5, 3, 6, 4]
```

**Output:**  
```
5
```

**Explanation:**  
- Buy on **day 2** (price = 1) and sell on **day 5** (price = 6).  
- Profit = `6 - 1 = 5`.  

**Note:** Buying on day 2 and selling on day 1 is **not allowed** since you must buy before you sell.  

---

## 🔍 Example 2  
**Input:**  
```
prices = [7, 6, 4, 3, 1]
```

**Output:**  
```
0
```

**Explanation:**  
In this case, no transactions are done, and the maximum profit is `0`.

---

## 💡 Constraints  
- `1 <= prices.length <= 10^5`  
- `0 <= prices[i] <= 10^4`  

---

## 🚀 Solution Approach  
To solve this problem efficiently:  
✅ Track the **minimum price** while iterating through the array.  
✅ Calculate the **maximum profit** by comparing the current price with the minimum tracked value.  
✅ Return the maximum profit found.

---

If you'd like me to add the code solution with detailed comments, let me know! 😊
