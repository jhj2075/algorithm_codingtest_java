package Baekjoon;

import java.util.Scanner;


// 슬라이딩 윈도우 - 게으른 백곰
public class Main_10025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int windowSize;
        if (k >= 500_000) windowSize = 1_000_000;
        else windowSize = k * 2 + 1;
        int[] arr = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            int g = sc.nextInt();
            int x = sc.nextInt();
            arr[x] = g;
        }

        int[] S = new int[1_000_001];
        S[0] = arr[0];
        for (int i = 1; i < S.length; i++) {
            S[i] = S[i-1] + arr[i];
        }

        int i = 0;
        int j = windowSize-1;
        int max = S[j];
        j++;
        while (j <= 1_000_000) {
            int sum = S[j] - S[i];
            max = Math.max(max, sum);
            i++;
            j++;
        }
        System.out.println(max);
    }
}
