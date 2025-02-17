package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 동적 계획법 - 행렬 곱 연산 횟수의 최솟값 구하기
public class Main_94_11049 {
    public static int n;
    public static Matrix[] m;
    public static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n+1][n+1];
        m = new Matrix[n+1];
        for (int i = 0; i < d.length; i++){
            for (int j = 0; j < d[i].length; j++){
                d[i][j] = -1;
            }
        }
        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            m[i] = new Matrix(y, x);
        }
        System.out.println(execute(1, n));
    }
    static int execute(int s, int e){
        int result = Integer.MAX_VALUE;
        if (d[s][e] != -1)
            return d[s][e];

        if (s == e){
            return 0;
        }
        if (s + 1 == e){
            return m[s].y * m[s].x * m[e].x;
        }
        for (int i = s; i < e; i++){
            result = Math.min(result, m[s].y * m[i].x * m[e].x + execute(s, i) + execute(i+1, e));
        }
        return d[s][e] = result;
    }
    static class Matrix{
        private int y, x;
        Matrix(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}

