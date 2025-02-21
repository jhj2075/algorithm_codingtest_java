package Programmers.P_최소직사각형;

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] arr1 = new int[sizes.length];
        int[] arr2 = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++){
            int tmp = 0;
            if (sizes[i][0] < sizes[i][1]){
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            arr1[i] = sizes[i][0];
            arr2[i] = sizes[i][1];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        answer = arr1[sizes.length-1] * arr2[sizes.length-1];

        return answer;
    }
}