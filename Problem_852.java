package com.das.dhiraj.LeetCode_Solved_in_Java;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
/*
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

 */
public class Problem_852 {
    public static void main(String[] args) {
        int []arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    // it shourld return the index where the peak is
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
}
