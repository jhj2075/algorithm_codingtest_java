package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.Scanner;


// 트리 - 트리의 부모 찾기
public class Main_67_11725 {
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n+1];
        tree = new ArrayList[n+1];
        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
    static void DFS(int number){
        visited[number] = true;
        for (int i : tree[number]){
            if (!visited[i]){
                answer[i] = number;
                DFS(i);
            }
        }
    }
}
