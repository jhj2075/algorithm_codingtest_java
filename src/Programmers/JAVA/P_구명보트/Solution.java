package Programmers.JAVA.P_구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int ans = 0;

        Arrays.sort(people);

        int i = 0;
        int j = people.length-1;

        while (i <= j){
            if (people[i] + people[j] <= limit){
                i++;
            }
            j--;
            ans++;
        }

        return ans;
    }
}