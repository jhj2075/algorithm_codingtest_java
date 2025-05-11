package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;


// 탐색 - 바이러스 (DFS)
public class Main_2606 {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        arr = new ArrayList[v+1];
        visited = new boolean[v+1];
        cnt = 0;
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[start].add(end);
            arr[end].add(start);
        }
        DFS(1);
        System.out.println(cnt);
    }
    public static void DFS(int n){
        if (visited[n]){
            return;
        }

        visited[n] = true;
        for (int i : arr[n]){
            if (!visited[i]){
                cnt++;
                DFS(i);
            }
        }
    }
}
