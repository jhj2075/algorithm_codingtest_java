package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 트리 - 최소 공통 조상 구하기 2
public class Main_75_11438 {
    public static ArrayList<Integer>[] tree;
    public static int[] depth;
    public static boolean[] visited;
    public static int[][] parent;
    public static int kmax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
         tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[n+1];
        visited = new boolean[n+1];
        int tmp = 1;
        kmax = 0;
        while (tmp <= n){
            tmp <<= 1; // 비트 연산 왼쪽으로 한 칸이면 2의 제곱 수 하나 증가이므로
            kmax++;
        }
        parent = new int[kmax+1][n+1];
        BFS(1);
        for (int k = 1; k <= kmax; k++){
            for (int i = 1; i <= n; i++){
                parent[k][i] = parent[k-1][parent[k-1][i]];
            }
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = LCA(a,b);
            System.out.println(result);
        }
    }
    public static int LCA(int a, int b){
        // b가 더 큰 depth인 것이 되도록 조정
        if (depth[a] > depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        // a, b의 depth 맞추기
        for (int k = kmax; k >= 0; k--){
            if (Math.pow(2, k) <= depth[b] - depth[a]){
                if (depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0; k--){
            if (parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int result = a;
        if (a != b){
            result = parent[0][result];
        }
        return result;
    }
    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        int level = 1;
        int now_size = 1;
        int cnt = 0;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i : tree[now]){
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    parent[0][i] = now;
                    depth[i] = level;
                }
            }
            cnt++;
            if (cnt == now_size){
                cnt = 0;
                now_size = queue.size();
                level++;
            }
        }

    }
}
