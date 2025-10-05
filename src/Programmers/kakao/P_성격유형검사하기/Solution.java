package Programmers.kakao.P_성격유형검사하기;

import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] mbti = new int[4];
        char[] ansArr = new char[4];

        for(int i = 0; i < choices.length; i++){
            char[] tmp = survey[i].toCharArray();
            int idx = findIdx(tmp[0]);
            if (tmp[0] == 'R' || tmp[0] == 'C' || tmp[0] == 'J' || tmp[0] == 'A'){
                mbti[idx] += choices[i] - 4;
            }
            else {
                mbti[idx] -= choices[i] - 4;
            }
        }
        if (mbti[0] > 0){
            ansArr[0] = 'T';
        }
        else if (mbti[0] < 0){
            ansArr[0] = 'R';
        }
        else {
            ansArr[0] = 'R';
        }

        if (mbti[1] > 0){
            ansArr[1] = 'F';
        }
        else if (mbti[1] < 0){
            ansArr[1] = 'C';
        }
        else {
            ansArr[1] = 'C';
        }

        if (mbti[2] > 0){
            ansArr[2] = 'M';
        }
        else if (mbti[2] < 0){
            ansArr[2] = 'J';
        }
        else {
            ansArr[2] = 'J';
        }

        if (mbti[3] > 0){
            ansArr[3] = 'N';
        }
        else if (mbti[3] < 0){
            ansArr[3] = 'A';
        }
        else {
            ansArr[3] = 'A';
        }

        return String.valueOf(ansArr);
    }

    int findIdx(char c){
        if (c == 'R' || c == 'T') return 0;
        else if (c == 'C' || c == 'F') return 1;
        else if (c == 'J' || c == 'M') return 2;
        else return 3;
    }
}