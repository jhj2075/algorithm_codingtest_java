package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 정수를 1로 만들기
public class Main_84_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        for (int i = 2; i <= n; i++){
            d[i] = d[i-1] + 1;
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i/2] + 1);
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i/3] + 1);
        }
        System.out.println(d[n]);
    }
}
