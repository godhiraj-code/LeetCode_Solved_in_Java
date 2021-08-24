package com.das.dhiraj.LeetCode_Solved_in_Java;

public class Problem_1095 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(search(array, target));

    }
    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int first_try = binary_search(arr, target, 0, peak);
        if(first_try != -1){
            return first_try;
        }
        return binary_search(arr, target, peak+1, arr.length -1);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                // then it means , that array is getting in decreasing mode.
                // so this may be potential answer, but still need to search for left part of the array
                // so now my end becomes mid
                end = mid;
            }else{
                // it means that array is in inceaseing mode.
                // so we need to see in the right part of the array
                start = mid + 1;
            }
        }
        return start;

    }
    static int binary_search(int[] arr, int target, int start, int end){
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


