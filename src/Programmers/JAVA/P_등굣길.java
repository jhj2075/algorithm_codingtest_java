package Programmers.JAVA;

public class P_등굣길 {

    public int solution(int m, int n, int[][] puddles) {

        int[][] d = new int[m+1][n+1];

        for(int i = 0; i < puddles.length; i++){
            d[puddles[i][0]][puddles[i][1]] = -1;
        }
        d[1][1] = 1;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1) continue;
                if(d[i][j] != -1){
                    if(d[i-1][j] == -1 && d[i][j-1] == -1){
                        d[i][j] = 0;
                    }
                    else if(d[i-1][j] == -1 || d[i][j-1] == -1){
                        d[i][j] = (d[i-1][j] + d[i][j-1] + 1) % 1_000_000_007;
                    }
                    else {
                        d[i][j] = (d[i-1][j] + d[i][j-1]) % 1_000_000_007;
                    }
                }
            }
        }

        return d[m][n];
    }
}
