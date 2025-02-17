package Baekjoon.Do_it;

import java.util.Arrays;
import java.util.Scanner;


// 투 포인터 - '좋은 수' 구하기
public class Main_8_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int cnt = 0;

        for (int w = 0; w < N; w++){
            arr[w] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int k = 0; k < N; k++) {
            int find = arr[k];
            int i = 0;
            int j = N - 1;

            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    // 입력으로 같은 수가 두 번 올 수도 있으니 같은 위치의 수에 대해서는 예외처리를 해야함
                    if (i != k && j != k){
                        cnt++;
                        break;
                    }
                    else if (i == k){
                        i++;
                    }
                    else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] > find) {
                    j--;
                } else if (arr[i] + arr[j] < find) {
                    i++;
                }
            }
        }
        System.out.println(cnt);
    }
}
