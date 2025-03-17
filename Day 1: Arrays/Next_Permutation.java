// Next_Permutation : find next lexicographically greater permutation

/*
It can be solve by two approach :-
  1. Brute Force Approach
  2. Optimal Approach
*/

// Brute Force Approach

/*
Brute Force: Finding all possible permutations. 

Approach :

Step 1: Find all possible permutations of elements present and store them.
Step 2: Search input from all possible permutations.
Step 3: Print the next permutation present right after it.

For reference of how to find all possible permutations, follow up https://www.youtube.com/watch?v=f2ic2Rsc9pU&t=32s. This video shows for distinct elements but code works for duplicates too.

For finding, all possible permutations, it is taking N!xN. N represents the number of elements present in the input array. Also for searching input arrays from all possible permutations will take N!. Therefore, it has a Time complexity of O(N!xN).
Space Complexity : Since we are not using any extra spaces except stack spaces for recursion calls. So, it has a space complexity of O(1).
*/

// Optimal Approach

/*
The steps are the following:

1. Find the break-point, i: Break-point means the first index i from the back of the given array where arr[i] becomes smaller than arr[i+1].
For example, if the given array is {2,1,5,4,3,0,0}, the break-point will be index 1(0-based indexing). Here from the back of the array, index 1 is the first index where arr[1] i.e. 1 is smaller than arr[i+1] i.e. 5.
To find the break-point, using a loop we will traverse the array backward and store the index i where arr[i] is less than the value at index (i+1) i.e. arr[i+1].
2. If such a break-point does not exist i.e. if the array is sorted in decreasing order, the given permutation is the last one in the sorted order of all possible permutations. So, the next permutation must be the first i.e. the permutation in increasing order.
So, in this case, we will reverse the whole array and will return it as our answer.
3. If a break-point exists:
      a. Find the smallest number i.e. > arr[i] and in the right half of index i(i.e. from index i+1 to n-1) and swap it with arr[i].
      b. Reverse the entire right half(i.e. from index i+1 to n-1) of index i. And finally, return the array.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Find the pivot (first element from the left that is smaller than the next one)
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // If no pivot found, array is in descending order
        if(pivot == -1) {
            reverse(nums, 0, n-1);  // reverse the whole array
            return;
        }

        // Find the successor (smallest number greater than pivot)
        for(int i = n - 1; i > pivot; i--) {
            if(nums[i] > nums[pivot]) {
                // Swap with successor
                swap(nums, i, pivot);
                break;
            }
        }

        // Reverse the elements after the pivot
        reverse(nums, pivot + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Visualization of the above code
  Let's walk through the code visually step-by-step with an example to better understand the logic and flow.

---

🔎 Example Walkthrough
Input Array:  
```
[1, 3, 2]
```

Step 1: Identify the Pivot
- Traverse the array from right to left.  
- Find the **first element** that is smaller than the element next to it.  
- In this case:  

```
[1, 3, 2] 
     ↑
   Pivot → 1 (at index 0)
```

---

Step 2: Identify the Successor
- Traverse the array from the end.  
- Find the smallest element greater than the pivot.  
- In this case:  

```
[1, 3, 2] 
        ↑
  Successor → 2 (at index 2)
```

---

Step 3: Swap Pivot and Successor
- Swap the pivot (value `1`) with the successor (value `2`).  

Before Swap:  
```
[1, 3, 2] 
```

After Swap:  
```
[2, 3, 1]
```

---

Step 4: Reverse the Elements After the Pivot
- Reverse the portion of the array after the pivot's position.  
- In this case, reverse the subarray starting at index `1` to the end.  

Before Reverse:  
```
[2, 3, 1] 
```

After Reverse:  
```
[2, 1, 3] 
```

---

Final Output:  
```
Next Permutation: [2, 1, 3]
```

---

🔥 Visual Flowchart  

```
Input Array: [1, 3, 2]
----------------------------------------
Step 1: Find Pivot
[1, 3, 2] → Pivot = 1 (Index 0)
----------------------------------------
Step 2: Find Successor
[1, 3, 2] → Successor = 2 (Index 2)
----------------------------------------
Step 3: Swap Pivot and Successor
[2, 3, 1]
----------------------------------------
Step 4: Reverse Elements After Pivot
[2, 1, 3]
----------------------------------------
Output Array: [2, 1, 3]
```

---

🧠 Key Insights
✅ Identifying the pivot is crucial — it marks the point where the sequence can be improved.  
✅ Swapping ensures the next greater number.  
✅ Reversing ensures it's the next lexicographical order.  
*/
