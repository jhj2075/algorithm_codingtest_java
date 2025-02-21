package Programmers.P_카펫;

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        HashSet<Integer> set = new HashSet<>();
        // 약수를 모두 구함
        for (int i = 1; i <= area; i++){
            if (area % i == 0) set.add(i);
        }
        // 두 개를 곱해서 area가 되는 약수 두 개 a, b 중 (a - 2) * (b - 2) = yellow 인 a, b를 찾음
        for (int i : set){
            int a = i;
            int b = area / a;
            if ((a - 2) * (b - 2) == yellow){
                // 두 개 중에 큰게 앞에
                answer[0] = Math.max(a, b);
                answer[1] = Math.min(a, b);
            }
        }

        return answer;
    }
}
