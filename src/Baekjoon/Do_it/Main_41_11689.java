package Baekjoon.Do_it;

import java.util.Scanner;


// 정수론 - 오일러 피 함수 구현하기
public class Main_41_11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = n;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0){
                ans = ans - (ans / i);
                while (n % i == 0){
                    n /= i;
                }
            }
        }
        if (n > 1){
            ans = ans - ans / n;
        }
        System.out.println(ans);
    }
}
