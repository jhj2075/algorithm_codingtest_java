package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 트리 - 리프 노드의 개수 구하기
public class Main_68_1068 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int leafCnt;
    static int delete;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree = new ArrayList[n];
        visited = new boolean[n];
        leafCnt = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if (parent != -1) {
                tree[parent].add(i);
            }
            else root = i;
        }
        delete = sc.nextInt();
        BFS(root);
        System.out.println(leafCnt);
    }
    static void BFS(int n){
        if (n == delete) return;
        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()){
            int now = queue.poll();

            int childCnt = 0;
            for (int i : tree[now]) {
                if (i == delete) continue;
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    childCnt++;
                }
            }
            if (childCnt == 0){
                leafCnt++;
            }
        }
    }
}
