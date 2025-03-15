/*
It can be solve by four approach :-
  1. Brute Force Approach
  2. Better Approach
  3. Optimal Approach
  4. Follow-up
*/

// Brute Force Approach

/*
Intuition:
We will check the sum of every possible subarray and consider the maximum among them. To get every possible subarray sum, we will be using three nested loops. The first loops(say i and j) will iterate over every possible starting index and ending index of a subarray. Basically, in each iteration, the subarray range will be from index i to index j. Using another loop we will get the sum of the elements of the subarray [i…..j]. Among all values of the sum calculated, we will consider the maximum one.

Approach:
The steps are as follows:

1. First, we will run a loop(say i) that will select every possible starting index of the subarray. The possible starting indices can vary from index 0 to index n-1(n = size of the array).
2. Inside the loop, we will run another loop(say j) that will signify the ending index of the subarray. For every subarray starting from the index i, the possible ending index can vary from index i to n-1(n = size of the array).
3. After that for each subarray starting from index i and ending at index j (i.e. arr[i….j]), we will run another loop to calculate the sum of all the elements(of that particular subarray).

Note: We are selecting every possible subarray using two nested loops and for each of them, we add all its elements using another loop.

Time Complexity: O(N3), where N = size of the array.
Reason: We are using three nested loops, each running approximately N times.
Space Complexity: O(1) as we are not using any extra space.
*/



/*-------------------------------------------------------------------------------------------------------------------------*/

// Optimal Approach

/*
Intuition: The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0. A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.
Here, we will iterate the given array with a single loop and while iterating we will add the elements in a sum variable. Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to consider any subarray with a negative sum. Among all the sums calculated, we will consider the maximum one.
Thus we can solve this problem with a single loop.

Approach:
The steps are as follows:

1. We will run a loop(say i) to iterate the given array.
2. Now, while iterating we will add the elements to the sum variable and consider the maximum one.
3. If at any point the sum becomes negative we will set the sum to 0 as we are not going to consider it as a part of our answer.

Note: In some cases, the question might say to consider the sum of the empty subarray while solving this problem. So, in these cases, before returning the answer we will compare the maximum subarray sum calculated with 0(i.e. The sum of an empty subarray is 0). And after that, we will return the maximum one.
For e.g. if the given array is {-1, -4, -5}, the answer will be 0 instead of -1 in this case. 

This is applicable to all the approaches discussed below.

But if this case is not explicitly mentioned we will not consider this case.

Time Complexity: O(N), where N = size of the array.
Reason: We are using a single loop running N times.
Space Complexity: O(1) as we are not using any extra space.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum > maxi) {
                maxi = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
}

/*-------------------------------------------------------------------------------------------------------------------------*/
