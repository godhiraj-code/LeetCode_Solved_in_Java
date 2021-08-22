package com.das.dhiraj.LeetCode_Solved_in_Java;

import java.util.Arrays;

public class Problem_34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    static int[] searchRange(int[] nums, int target) {
        boolean findStartIndex = false;
        int[] ans = {-1, -1};
        int first = search(nums, target, findStartIndex = true);
        int last = search(nums, target, findStartIndex = false);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    static int search(int[] nums, int target, boolean findStartIndex){
            int first = 0;
            int ans = -1;
            int last = nums.length - 1;
            while( first <= last )
            {
                int mid = first + (last-first)/2;
                if ( nums[mid] < target )
                {
                    first = mid + 1;
                }
                else if ( nums[mid] == target )
                {
                    ans = mid;
                    if ( findStartIndex )
                    {
                        last = mid - 1;
                    }else
                    {
                        first = mid + 1;
                    }
                }
                else
                {
                    last = mid - 1;
                }
            }
            return ans;
        }
    }
