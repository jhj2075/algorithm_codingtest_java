package Baekjoon.Do_it;

import java.util.Scanner;


// 조합 - 선물 전달하기
public class Main_83_1947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] D = new long[n+1];
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= n; i++) {
            // A가 B에게 줬는데
            // 1. B도 A에게 준 경우 두 사람의 선물 전달이 완료된 거니까 나머지 D[i-2]의 경우를 알면 됨
            // 2. B는 A에게 안 준 경우 A 한 사람의 선물 전달이 완료된 거니까 D[i-1]의 경우를 알아야 함
            // A가 줄 수 있는 B는 본인 제외 i-1명 있으므로 1. 과 2. 에 각각 곱해주면 됨
            D[i] = (i-1) * (D[i-1] + D[i-2]) % 1_000_000_000;
        }
        System.out.println(D[n]);
    }
}
