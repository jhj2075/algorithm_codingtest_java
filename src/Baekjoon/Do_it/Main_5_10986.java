package Baekjoon.Do_it;

import java.util.Scanner;

// 구간 합 - 나머지 합 구하기
public class Main_5_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long cnt = 0;
        S[0] = sc.nextInt();

        for (int i = 1; i < N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }
// 이렇게 하면 시간 초과
//        for (int i = 1; i <= N; i++){
//            for (int j = i; j <= N; j++){
//                if (((S[j] - S[i-1]) % M) == 0){
//                    cnt++;
//                }
//            }
//        }
        for (int i = 0; i < N; i++){
            int remainder = (int) (S[i] % M);
            if (remainder == 0) cnt++;
            C[remainder]++;
        }

        for (int i = 0; i < M; i++){
            if (C[i] > 1)
                cnt = cnt + (C[i] * (C[i] - 1) / 2);
        }
        System.out.println(cnt);
    }
}
