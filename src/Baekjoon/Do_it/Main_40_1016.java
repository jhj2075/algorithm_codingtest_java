package Baekjoon.Do_it;

import java.util.Scanner;


// 정수론 - 제곱이 아닌 수 찾기
public class Main_40_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] arr = new boolean[(int)(max - min + 1)];
        for (long i = 2; i * i <= max; i++){
            long pow = i * i;
            long start = min / pow;
            if (min % pow != 0)
                start++;
            for (long j = start; pow * j <= max; j++) {
                arr[(int)(pow * j - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
