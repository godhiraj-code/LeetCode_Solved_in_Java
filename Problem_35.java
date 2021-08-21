package com.das.dhiraj.LeetCode_Solved_in_Java;
//https://leetcode.com/problems/search-insert-position/
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
 */


public class Problem_35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(binary_search(nums, 0));
        System.out.println(binary_search(nums, 1));
        System.out.println(binary_search(nums, 2));
        System.out.println(binary_search(nums, 3));
        System.out.println(binary_search(nums, 4));
        System.out.println(binary_search(nums, 5));
        System.out.println(binary_search(nums, 6));
        System.out.println(binary_search(nums, 7));
    }
    static int binary_search(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int potentialTargetPosition = 0;
        while(start <= end){
            int mid = start + (end - start)/2;

            if (target < arr[mid]) {
                end = mid -1;
                potentialTargetPosition = mid;

            }else if(target > arr[mid]){
                start = mid + 1;
                potentialTargetPosition = start;

            }else{
                return mid;
            }
        }
        if(target >= arr[arr.length -1]){
            potentialTargetPosition = arr.length;
        }else if(target <= arr[0]){
            potentialTargetPosition = 0;
        }
        return potentialTargetPosition;
    }
}
