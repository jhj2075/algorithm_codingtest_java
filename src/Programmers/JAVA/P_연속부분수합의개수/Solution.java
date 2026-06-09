package Programmers.JAVA.P_연속부분수합의개수;

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++){ // i개 합
            for (int j = 0; j < elements.length; j++){ // 시작 idx
                int sum = 0;
                for (int k = j; k < i+j; k++){
                    int realk = k;
                    if (k >= elements.length)
                        realk %= elements.length;
                    sum += elements[realk];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
