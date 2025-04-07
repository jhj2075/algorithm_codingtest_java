package Baekjoon.Do_it;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 트리 - 최솟값 찾기 2 (세그먼트 트리)
public class Main_72_10868 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 2^k >= n을 만족하는 k에 대해 2^k * 2 크기 배열 만들기
        int k = 0;
        while (Math.pow(2, k) < n){
            k++;
        }
        int[] arr = new int[(int)Math.pow(2, k) * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        // 세그먼트 트리에 값 입력하기
        for (int i = 0; i < n; i++) {
            arr[(int)Math.pow(2, k) + i] = sc.nextInt();
        }
        // 최소값 찾기 이므로 min으로 부모 노드 채우기
        for (int i = (int)Math.pow(2, k) - 1; i >= 1; i--) {
            arr[i] = Math.min(arr[i * 2], arr[i * 2 + 1]);
        }
        // 질의값 구하기
        for (int i = 0; i < m; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int start_index = sc.nextInt();
            int end_index = sc.nextInt();
            start_index = start_index + (int)Math.pow(2, k) - 1;
            end_index = end_index + (int)Math.pow(2, k) - 1;
            while (start_index <= end_index){
                if (start_index % 2 == 1)
                    queue.add(arr[start_index]);
                if (end_index % 2 == 0)
                    queue.add(arr[end_index]);
                start_index = (start_index + 1) / 2;
                end_index = (end_index - 1) / 2;
            }
            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()){
                min = Math.min(min, queue.poll());
            }
            System.out.println(min);
        }
    }
}
