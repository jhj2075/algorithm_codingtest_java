package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 그래프 - 가장 빠른 버스 노선 구하기 (플로이드-워셜 알고리즘)
public class Main_61_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] d = new long[n+1][n+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (i != j)
                    d[i][j] = 10000001;
            }
        }
        for (int i = 1; i <= m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            d[a][b] = Math.min(d[a][b], c);
        }
        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    if (d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];
                }
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (d[i][j] == 10000001)
                    System.out.print("0 ");
                else
                    System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
