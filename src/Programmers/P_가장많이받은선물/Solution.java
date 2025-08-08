package Programmers.P_가장많이받은선물;

import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int[] giftDegree = new int[friends.length];
        int[][] giftGraph = new int[friends.length][friends.length];

        for(int i = 0; i < friends.length; i++){
            map.put(friends[i], i);
        }

        for (String gift : gifts){
            String[] giftName = gift.split(" ");
            giftDegree[map.get(giftName[0])]++;
            giftDegree[map.get(giftName[1])]--;
            giftGraph[map.get(giftName[0])][map.get(giftName[1])]++;
        }

        for(int i = 0; i < friends.length; i++){
            int num = 0;

            for(int j = 0; j < friends.length; j++){
                if (i == j) continue;
                if (giftGraph[i][j] > giftGraph[j][i] ||
                        (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j]))
                    num++;
            }

            if (answer < num)
                answer = num;
        }

        return answer;
    }
}