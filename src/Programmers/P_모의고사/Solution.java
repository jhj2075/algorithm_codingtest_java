package Programmers.P_모의고사;

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] ans1 = new int[answers.length];
        int[] ans2 = new int[answers.length];
        int[] ans3 = new int[answers.length];
        int[] arr = {1, 3, 4, 5};
        int[] arr2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int j = 0;
        int k = 0;

        for (int i = 0; i < answers.length; i++){
            ans1[i] = (i % 5) + 1;
            if (i % 2 == 0)
                ans2[i] = 2;
            else {
                ans2[i] = arr[j];
                j++;
                if (j == 4) j = 0;
            }
            ans3[i] = arr2[k];
            k++;
            if (k == 10) k = 0;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == ans1[i])
                cnt1++;
            if (answers[i] == ans2[i])
                cnt2++;
            if (answers[i] == ans3[i])
                cnt3++;
        }

        if (cnt1 > cnt2 && cnt1 > cnt3) answer[0] = 1;
        else if (cnt2 > cnt1 && cnt2 > cnt3) answer[0] = 2;
        else if (cnt3 > cnt1 && cnt3 > cnt2) answer[0] = 3;
        else if (cnt1 == cnt2 && cnt1 > cnt3) {answer[0] = 1; answer[1] = 2;}
        else if (cnt1 == cnt3 && cnt1 > cnt2) {answer[0] = 1; answer[1] = 3;}
        else if (cnt2 == cnt3 && cnt2 > cnt1) {answer[0] = 2; answer[1] = 3;}
        else {answer[0] = 1; answer[1] = 2; answer[2] = 3;}


        return Arrays.stream(answer).filter(i -> i != 0).toArray();
    }
}
