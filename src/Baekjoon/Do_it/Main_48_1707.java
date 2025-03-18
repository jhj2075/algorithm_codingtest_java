package Baekjoon.Do_it;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 그래프 - 이분 그래프 판별하기
public class Main_48_1707 {
    static int[] check;
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static boolean isYes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            check = new int[v + 1];
            visited = new boolean[v + 1];
            A = new ArrayList[v + 1];
            isYes = true;
            for (int j = 1; j <= v; j++) {
                A[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start); // 모든 노드에서 탐색하므로 한쪽 방향으로만 저장해 놓으면 안됨
            }
            // 그래프가 모두 연결되어 있지 않을 수 있으므로 각 노드에서 전부 탐색
            for (int j = 1; j <= v; j++) {
                if (isYes)
                    DFS(j);
                else
                    break;
            }
            if (isYes)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
    private static void DFS(int node){
        visited[node] = true;
        for (int i : A[node]){
            if (!visited[i]){
                check[i] = (check[node] + 1) % 2; // 0과 1 두 집합으로 나뉠 수 있게 하는 계산
                DFS(i);
            }
            else if (check[i] == check[node]){
                isYes = false;
            }
        }
    }
}
