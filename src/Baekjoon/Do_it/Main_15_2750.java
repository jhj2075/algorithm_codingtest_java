package Baekjoon.Do_it;

import java.util.Scanner;


// 정렬 - 수 정렬하기 1 (Arrays.sort 하면 바로 풀 수 있지만 버블정렬으로 구현)
public class Main_15_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // 주석 처럼 해도 가능함
        for (int i = n; i > 0; i--){ // for (int i = 0; i < n - 1; i++)
            for (int j = 1; j < i; j++){ // for (int j = 0; j < n - 1 - i; j++)
                int tmp;
                if (arr[j-1] > arr[j]){ // arr[j-1]이 아니라 arr[j]를, arr[j]가 아니라 arr[j+1]
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
