package com.das.dhiraj.LeetCode_Solved_in_Java;
//https://leetcode.com/problems/sqrtx/
public class Problem_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(625));

    }
    static int mySqrt(int x) {
        int answer = 0;
        answer = binary_search(x);

        System.out.println("approximate square root is "+answer);

        return (int)(answer);
    }
    static int binary_search(int x) {
        int start = 1;
        int end = x;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(mid <= x/mid){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}

