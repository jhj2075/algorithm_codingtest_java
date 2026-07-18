package Programmers;

public class P_땅따먹기 {
    class Solution {
        int solution(int[][] land) {

            int[][] d = new int[land.length][land[0].length];

            for(int i = 0; i < land.length; i++){
                for(int j = 0; j < land[0].length; j++){
                    if(i == 0){
                        d[i][j] = land[i][j];
                    }
                    else {
                        for(int k = 0; k < land[0].length; k++){
                            if(k != j){
                                d[i][j] = Math.max(d[i][j], land[i][j] + d[i-1][k]);
                            }
                        }
                    }
                }
            }

            int max = 0;
            for(int i = 0; i < land[0].length; i++){
                max = Math.max(max, d[land.length-1][i]);
            }

            return max;
        }
    }
}
