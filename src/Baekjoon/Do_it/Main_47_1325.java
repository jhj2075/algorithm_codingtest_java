package Baekjoon.Do_it;

import java.io.*;
import java.util.*;


// 그래프 - 효율적으로 해킹하기
public class Main_47_1325 {
    static boolean[] visited;
    static int[] ans;
    static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrayLists = new ArrayList[n + 1];
        ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayLists[s].add(e);
        }
        // BFS 함수 따로 빼면 시간초과 나고 이렇게 해야 안남
        for (int i = 1; i <= n; i++) {
            if (!arrayLists[i].isEmpty()) { // 이거 없으면 시간초과 남
                visited = new boolean[n + 1];
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (int j : arrayLists[now]) {
                        if (!visited[j]) {
                            visited[j] = true;
                            ans[j]++;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ans[i]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (ans[i] == max)
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
//    static void BFS(int node){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(node);
//        visited[node] = true;
//        while (!queue.isEmpty()) {
//            int now = queue.poll();
//            for (int i : arrayLists[now]) {
//                if (!visited[i]){
//                    visited[i] = true;
//                    ans[i]++;
//                    queue.add(i);
//                }
//            }
//        }
//    }
}

