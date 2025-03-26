package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


// 통계학 (구현)
public class Main_2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 산술 평균
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round((double) sum / n));

        // 중앙값
        System.out.println(arr[n / 2]);
        // 최빈값
        int[] visited = new int[8001];
        for (int i = 0; i < n; i++) {
            visited[arr[i] + 4000]++;
        }
        int f = 0;
        ArrayList<Integer> fList = new ArrayList<>();
        for (int i = 0; i <= 8000; i++) {
            if (visited[i] != 0){
                if (visited[i] > f){
                    f = visited[i];
                    fList.clear();
                    fList.add(i - 4000);
                }
                else if (visited[i] == f){
                    fList.add(i - 4000);
                }
            }
        }
        if (fList.size() > 1){
            System.out.println(fList.get(1));
        }
        else System.out.println(fList.get(0));

        // 범위
        int max = -4001;
        int min = 4001;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        System.out.println(max - min);

    }
}
