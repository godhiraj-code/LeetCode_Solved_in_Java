package com.das.dhiraj.LeetCode_Solved_in_Java;
//https://leetcode.com/problems/median-of-two-sorted-arrays/
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

 */

import java.util.Arrays;

public class Problem_4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double median;
        median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Final Median :" +median);
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2){
        System.out.println(Arrays.toString(nums1));
        double median=0.0;
        int[] merged_array = merge(nums1, nums2);
        System.out.println(Arrays.toString(merged_array));
        median = return_median_value(merged_array);
        return (double)Math.round(median * 100000d) / 100000d;
    }
    static double return_median_value(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        // check if the arr is in ascending order or descending order :
        boolean isAsc = arr[start] < arr[end];
        // check if the merged array has odd no of elements or even no of elements
        boolean isEven = end % 2 == 0;
        if (isEven){
            return arr[start+ (end-start)/2];
        }else{
            int mid_element = arr[start + (end-start)/2];
            int mid_element_another = arr[start + (end-start)/2 + 1];
            System.out.println("should be 2.5"+ (double)(mid_element + mid_element_another)/2);
            return (double)(mid_element + mid_element_another)/2;
        }

    }
     static int[] merge(int[] foo, int[] bar) {

        int fooLength = foo.length;
        int barLength = bar.length;

        int[] merged = new int[fooLength + barLength];

        int fooPosition, barPosition, mergedPosition;
        fooPosition = barPosition = mergedPosition = 0;

        while(fooPosition < fooLength && barPosition < barLength) {
            if (foo[fooPosition] < bar[barPosition]) {
                merged[mergedPosition++] = foo[fooPosition++];
            } else {
                merged[mergedPosition++] = bar[barPosition++];
            }
        }

        while (fooPosition < fooLength) {
            merged[mergedPosition++] = foo[fooPosition++];
        }

        while (barPosition < barLength) {
            merged[mergedPosition++] = bar[barPosition++];
        }
        //System.out.println(merged);
        return merged;
    }
}
