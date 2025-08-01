package Baekjoon;

import java.util.Scanner;


// 그리디 - 설탕 배달
public class Main_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0){
                cnt += n / 5;
                break;
            }
            else {
                n -= 3;
                cnt++;
            }

            if (n < 0){
                cnt = -1;
            }
        }

        System.out.println(cnt);
    }
}
