package Baekjoon.Do_it;

import java.util.Arrays;
import java.util.Scanner;


// 정렬 - ATM 인출 시간 계산하기 (삽입정렬 사용하지 않고 sort 쓰고 답지 안보고 직접 푼 풀이, 그리디도 안씀)
public class Main_18_11399_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] s = new int[n];
        s[0] = arr[0];
        int sum = 0;
        for (int i = 1; i < n; i++){
            s[i] = s[i-1] + arr[i];
            sum += s[i];
        }

        System.out.println(sum + s[0]);
    }
}
