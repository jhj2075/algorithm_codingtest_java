package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 이친수 구하기
public class Main_86_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // d[i][0]은 길이가 i일 때 0으로 끝나는 이친수의 개수
        // d[i][1]은 길이가 i일 때 1로 끝나는 이친수의 개수
        long[][] d = new long[n+1][2];
        d[1][0] = 0;
        d[1][1] = 1;
        for (int i = 2; i <= n; i++){
            d[i][0] = d[i-1][0] + d[i-1][1]; // 뒤에 0이 올 수도 있고 1이 올 수도 있으므로 두 경우를 모두 더함
            d[i][1] = d[i-1][0]; // 뒤에 1이 올 수 없으므로 뒤에 0이 온 경우와 같음
        }
        System.out.println(d[n][0] + d[n][1]);
    }
}
