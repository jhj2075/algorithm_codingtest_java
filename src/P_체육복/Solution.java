package P_체육복;

import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
        Arrays.fill(student, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++){
            student[lost[i] - 1]--;
        }
        for (int i = 0; i < reserve.length; i++){
            student[reserve[i] - 1]++;
        }
        for (int i = 0; i < n; i++){
            if (student[i] == 0){
                if (i == 0){
                    if (student[i+1] > 1){
                        student[i]++;
                        student[i+1]--;
                    }
                }
                else if (i == n-1){
                    if (student[i-1] > 1){
                        student[i]++;
                        student[i-1]--;
                    }
                }
                else {
                    if (student[i-1] > 1){
                        student[i]++;
                        student[i-1]--;
                    }
                    else if (student[i+1] > 1){
                        student[i]++;
                        student[i+1]--;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (student[i] > 0)
                answer++;
        }


        return answer;
    }
}
