package Baekjoon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


// 그리디 - 보물
public class Main_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        // A는 오름차순, B는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[i];
        }

        System.out.println(sum);
    }
}
