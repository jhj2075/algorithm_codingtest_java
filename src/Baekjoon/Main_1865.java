package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 그래프 - 웜홀 (벨만 - 포드)
public class Main_1865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int i = 0; i < TC; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int W = sc.nextInt();

            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int w = sc.nextInt();
                edges.add(new Edge(s, e, w));
                edges.add(new Edge(e, s, w));
            }

            for (int j = 0; j < W; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int w = sc.nextInt();
                edges.add(new Edge(s, e, -w));
            }

            // 가상 정점 0에서 모든 정점으로 가중치 0의 간선 추가
            for (int j = 1; j <= N; j++) {
                edges.add(new Edge(0, j, 0));
            }

            int[] D = new int[N+1];
            for (int j = 1; j <= N; j++) {
                D[j] = Integer.MAX_VALUE;
            }
            D[0] = 0;

            boolean hasNCycle = false;
            for (int j = 0; j <= N; j++) {
                for (Edge edge : edges) {
                    if (D[edge.s] != Integer.MAX_VALUE && D[edge.e] > D[edge.s] + edge.w) {
                        D[edge.e] = D[edge.s] + edge.w;
                        if (j == N)
                            hasNCycle = true;
                    }
                }
            }
            if (hasNCycle)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
class Edge{
    int s, e, w;

    Edge(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
