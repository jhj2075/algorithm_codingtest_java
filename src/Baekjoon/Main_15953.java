package Baekjoon;


import java.util.Scanner;

// 카카오 코드 페스티벌 2018 - 상금헌터
public class Main_15953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = 0;

            if (a == 1){
                sum += 5_000_000;
            } else if (a > 1 && a <= 3) {
                sum += 3_000_000;
            } else if (a > 3 && a <= 6) {
                sum += 2_000_000;
            } else if (a > 6 && a <= 10) {
                sum += 500_000;
            } else if (a > 10 && a <= 15) {
                sum += 300_000;
            } else if (a > 15 && a <= 21) {
                sum += 100_000;
            } else sum += 0;

            if (b == 1){
                sum += 5_120_000;
            } else if (b > 1 && b <= 3) {
                sum += 2_560_000;
            } else if (b > 3 && b <= 7) {
                sum += 1_280_000;
            } else if (b > 7 && b <= 15) {
                sum += 640_000;
            } else if (b > 15 && b <= 31) {
                sum += 320_000;
            } else sum += 0;

            System.out.println(sum);
        }
    }
}
