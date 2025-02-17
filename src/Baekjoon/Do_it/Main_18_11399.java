package Baekjoon.Do_it;

import java.util.Scanner;


// 정렬 - ATM 인출 시간 계산하기 (Arrays.sort 사용하지 않고 삽입정렬으로)
public class Main_18_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++){
            int insert_index = i;
            int insert_value = arr[i];

            for (int j = i - 1; j >= 0; j--){
                if (arr[i] > arr[j]){
                    insert_index = j + 1;
                    break;
                }
                if (j == 0){
                    insert_index = 0;
                }
            }

            for (int j = i; j > insert_index; j--){
                arr[j] = arr[j-1];
            }

            arr[insert_index] = insert_value;
        }

        int[] s = new int[n];
        s[0] = arr[0];
        for (int i = 1; i < n; i++){
            s[i] = s[i-1] + arr[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += s[i];
        }

        System.out.println(sum);
    }
}
