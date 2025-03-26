package Baekjoon;

import java.util.Scanner;


// 진법 변환 (구현)
public class Main_2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        int b = sc.nextInt();

        long sum = 0;
        for (int i = 0; i < n.length; i++) {
            if ((int)n[i] >= 65 && (int)n[i] <= 90)
                sum += ((long)n[i] - 55) * (long)Math.pow(b, n.length - i - 1);
            else
                sum += Long.parseLong(String.valueOf(n[i])) * (long)Math.pow(b, n.length - i - 1);
        }
        System.out.println(sum);
    }
}
