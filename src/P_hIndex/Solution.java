package P_hIndex;

import java.util.*;
class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++){
            if (citations[i] >= citations.length - i){
                answer = citations.length - i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
    }
}
