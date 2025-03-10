package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 정수론 - 오일러 피 함수 구현하기
public class Main_41_11689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0){
                ans = ans - ans / i;
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
