package Programmers.P_주식가격;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
//         Queue<Integer> q = new LinkedList<>();
//         Queue<Integer> tmp = new LinkedList<>();

//         for (int i : prices){
//             q.add(i);
//         }
//         int j = 0;
//         while(!q.isEmpty()){
//             int now = q.poll();
//             if (q.isEmpty()) {
//                 answer[j] = 0;
//                 break;
//             }
//             for (int i : q){
//                 tmp.add(i);
//             }
//             for (int i = 0; i < q.size(); i++){
//                 answer[j]++;
//                 if (now > tmp.poll()){
//                     break;
//                 }
//             }
//             j++;
//         }
//         return answer;
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++; // 초 증가
                if (prices[j] < prices[i]) {
                    break; // 가격이 떨어지면 중단
                }
            }
        }
        return answer;
    }
}
