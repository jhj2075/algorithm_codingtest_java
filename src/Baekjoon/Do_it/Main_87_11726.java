package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 2*N 타일 채우기
public class Main_87_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 단순한 피보나치 같아 보이지만
        // 전 거(D[i-1])에서 세로 직사각형 하나 추가 한 경우와
        // 전전거에서 가로 직사각형 두 개 추가한 경우를 합치는 방식
        int[] D = new int[n+1];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i <= n; i++) {
            D[i] = D[i-2] + D[i-1];
        }
        System.out.println(D[n]);
    }
}
