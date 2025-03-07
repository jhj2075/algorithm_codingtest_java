package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 - 구간 합 구하기 (버퍼리더, 스트링토크나이저 사용)
public class Main_3_11659_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < M; q++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}
