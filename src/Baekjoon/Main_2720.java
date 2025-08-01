package Baekjoon;

import java.util.Scanner;


// 그리디 - 세탁소 사장 동혁
public class Main_2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();
            int[] arr = new int[4];

            arr[0] = C / 25;
            C %= 25;
            arr[1] = C / 10;
            C %= 10;
            arr[2] = C / 5;
            C %= 5;
            arr[3] = C;

            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
        }
    }
}
