package Programmers.P_폰켓몬;

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;
        HashSet<Integer> hashset = new HashSet<>();
        for (int num : nums){
            hashset.add(num);
        }
        if (max > hashset.size())
            return hashset.size();
        else return max;
    }
}
