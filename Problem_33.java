package com.das.dhiraj.LeetCode_Solved_in_Java;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [4,5,6,7,0,1,2], target = 0
Output = 4

 */
public class Problem_33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int pivot = find_pivot(nums);
        int first_search = search(nums, 0, pivot, 0);
        int second_search = search(nums, pivot+1, nums.length - 1, 0 );
        if ((first_search != -1 ) || (second_search != -1)) {
            System.out.println("Target element found in the rotated array");
            if (first_search != -1) {
                System.out.println(first_search);
            }else{
                System.out.println(second_search);
            }
        }else{
            System.out.println("No target element found in the rotated array");
        }
    }
    static int find_pivot(int[] arr){
        int pivot = search_pivot(arr);
        return pivot;
    }
    static int search_pivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
            start = start + 1;
        }
        return -1;
    }


    static int search(int[] arr, int start, int end, int target) {

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
