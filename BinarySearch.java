package com.das.dhiraj.LeetCode_Solved_in_Java;
/*
    When a problem statement has something like sorted array , first thing that should come to your mind
    should be applying Binary Search.
    The below code is an implementation of a binary search.
    In Binary Search, 3 things are important
    1. Find the start and end range .
    2. Find the mid value.
    3. Based on the comparison of target value and mid value, reduce the search space

    The complexity of binary search is : O(log n)
 */
public class BinarySearch {

    public static void main(String[] args) {
	   // int[] arr_asc = {1, 3, 4, 5, 6, 9};
        int[] arr_desc = {9, 8, 7, 5, 4, 3};
        System.out.println(binary_search(arr_desc, 3));
    }
    // returns the index if target element is found , or -1 if not found.
    static int binary_search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        // check if the arr is in ascending order or descending order :
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                return mid;
            }
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = mid - 1;
                }
            }else{
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                }
            }
        }
        return  -1;
    }
}
