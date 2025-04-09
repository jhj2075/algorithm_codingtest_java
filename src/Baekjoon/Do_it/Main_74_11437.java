package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 트리 - 최소 공통 조상 구하기 1
public class Main_74_11437 {
    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        visited = new boolean[n+1];
        arrayLists = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        arr = new int[2][n+1];

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }
        // BFS 사용해서 부모 노드, 깊이 저장하는 배열 만들기
        BFS(1);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 두 노드 중 깊이가 더 깊은 노드부터 한 칸씩 위로 올라가기
            while (arr[1][a] > arr[1][b]) {
                a = arr[0][a];
            }
            while (arr[1][b] > arr[1][a]) {
                b = arr[0][b];
            }
            // 두 노드의 깊이가 같아지면 두 노드가 같아질 때까지 같이 한 칸씩 위로 올라가기
            while (a != b) {
                a = arr[0][a];
                b = arr[0][b];
            }
            System.out.println(a);
        }
    }
    static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i : arrayLists[now]){
                if (!visited[i]) {
                    visited[i] = true;
                    arr[0][i] = now;
                    arr[1][i] = arr[1][now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
