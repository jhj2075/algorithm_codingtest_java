package Baekjoon.Do_it;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


// 정수론 - 최대 공약수 구하기
public class Main_43_1850 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = gcd(a, b);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (long i = 0; i < ans; i++) {
            bw.write('1');
        }
        bw.flush();
        bw.close();
    }
    public static Long gcd(Long a, Long b){
        if (b == 0){
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}
