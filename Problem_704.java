package com.das.dhiraj.LeetCode_Solved_in_Java;
//https://leetcode.com/problems/binary-search/submissions/
public class Problem_704 {
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


