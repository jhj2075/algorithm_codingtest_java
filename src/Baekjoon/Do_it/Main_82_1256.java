package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 조합 - 사전 찾기
public class Main_82_1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] d = new int[n+m+1][n+m+1];
        for (int i = 0; i < n+m+1; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    d[i][j] = 1;
                }
                else {
                    d[i][j] = d[i-1][j] + d[i-1][j-1];
                    if (d[i][j] > 1000000000){
                        d[i][j] = 1000000001;
                    }
                }
            }
        }
        if (d[n+m][m] < k){
            System.out.print("-1");
        }
        else {
            while (!(n == 0 && m == 0)){
                if (d[n-1+m][m] >= k){
                    System.out.print("a");
                    n--;
                }
                else {
                    System.out.print("z");
                    k -= d[n-1+m][m];
                    m--;
                }
            }
        }
    }
}
