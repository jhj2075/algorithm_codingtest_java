package Baekjoon;

import java.util.Scanner;


// 슬라이딩 윈도우 - 꿀 아르바이트
public class Main_12847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 문제 잘 보고 자료형 선택해야함 int로 하면 틀림
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] S = new long[n];
        S[0] = arr[0];
        for (int i = 1; i < n; i++) {
            S[i] = S[i-1] + arr[i];
        }

        long ans = S[m-1];
        int i = 1;
        int j = m;
        while (j < n){
            long tmp = S[j] - S[i-1];
            ans = Math.max(ans, tmp);
            i++;
            j++;
        }
        System.out.println(ans);
    }
}
