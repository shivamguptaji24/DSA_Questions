// Optimal Approach

/*
Intuition: We will linearly travel the array. We can maintain a minimum from the start of the array and compare it with every element of the array, if it is greater than the minimum then take the difference and maintain it in max, otherwise update the minimum.

Approach:

1. Create a variable maxPro and store 0 initially.
2. Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
3. Run a for loop from 0 to n.
4. Update the minPrice if it is greater than the current element of the array
5. Take the difference of the minPrice with the current element of the array and compare and maintain it in maxPro.
6. Return the maxPro.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        return maxPro;
    }
}

/*-------------------------------------------------------------------------------------------------------------------------------------------*/

// Brute Force Approach

/*
Intuition: We can simply use 2 loops and track every transaction and maintain a variable maxPro to contain the max value among all transactions.

Approach: 

1. Use a for loop of ‘i’ from 0 to n.
2. Use another for loop of j from ‘i+1’ to n.
3. If arr[j] > arr[i] , take the difference and compare  and store it in the maxPro variable.
4. Return maxPro.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxPro = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] > prices[i]) {
                    maxPro = Math.max(prices[j] - prices[i], maxPro);
                }
            }
        }
        return maxPro;
    }
}
