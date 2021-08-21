package com.das.dhiraj.LeetCode_Solved_in_Java;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/

/*
Given a characters array letters that is sorted in non-decreasing order and a character target,
return the smallest character in the array that is larger than target.
Note that the letters wrap around.
For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
Input: letters = ["c","f","j"], target = "c"
Output: "f"
 */

/*
    Approach to solve the problem :
    1. Since the character array is sorted, it's better to apply a binary search with some tweak
    2. We don't have to return the target , instead the smallest char that is larger than the target.
    3. so after the loop is completed, we will just return the start pointer
    4. Also, since the letters wrap around, we need to take care of that too, for that instead of just returning
       start , we can do like start % arr.length
       Let's say if the target is 'z' and the character array contains only letter a and b , then we need to return
       the first element that is a.
       so if we do start % arr.length , it will become , 2 % 2 , which makes it 0 . 

 */

public class Problem_744 {
    public static void main(String[] args){
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters, 'j'));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int first = 0;
        int last = letters.length - 1;
        while( first <= last ){
            int mid = first + (last - first)/2;
            if ( target < letters[mid] ){
                last = mid - 1;
            }else{
                first = mid + 1;
            }
        }
        return letters[first % letters.length];
    }
}
