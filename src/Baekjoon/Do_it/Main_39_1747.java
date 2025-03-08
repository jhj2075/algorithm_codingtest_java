package Baekjoon.Do_it;

import java.util.Scanner;


// 정수론 - 소수 & 팰린드롬 수 중에서 최솟값 찾기
public class Main_39_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1003002];
        int ans = 0;
        for (int i = 2; i <= 1003001; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(1003001); i++) {
            if (arr[i] != 0){
                for (int j = i + i; j <= 1003001; j = j + i) {
                    arr[j] = 0;
                }
            }
        }
        for (int i = 2; i <= 1003001; i++) {
            if (arr[i] != 0){
                if (arr[i] < 10){
                    arr[i] = i;
                }
                else {
                    char[] tmp = Integer.toString(arr[i]).toCharArray();
                    int s = 0;
                    int e = tmp.length - 1;
                    while (s < e){
                        if (tmp[s] == tmp[e]){
                            s++;
                            e--;
                        }
                        else {
                            arr[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = n; i <= 1003001; i++) {
            if (arr[i] != 0){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
