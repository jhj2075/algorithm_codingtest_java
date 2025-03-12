package Baekjoon.Do_it;

import java.util.Scanner;


// 정수론 - 최소 공배수 구하기
public class Main_42_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = a * b / gcd(a, b);
            System.out.println(ans);
        }
    }
    public static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}
