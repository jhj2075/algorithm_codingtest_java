package Baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


// 그래프 - 파티 (다익스트라)
public class Main_1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 학생 수 (= 마을 수)
        int M = sc.nextInt(); // 도로 수
        int X = sc.nextInt(); // 파티가 열리는 마을 번호

        // 모든 마을에서 각각 출발하는 최단 경로 배열 구하고
        // 파티가 열리는 마을에서 출발하는 최단 경로 배열과 이외 배열에서 파티 마을로의 최단 경로 값을 더한 값 중 최댓값 구하기

        ArrayList<Node>[] arrayLists = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            arrayLists[s].add(new Node(e, v));
        }

        int[][] D = new int[N+1][N+1];
        // 모든 마을에 대해 다익스트라
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    D[i][j] = 0;
                else
                    D[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> queue;
        boolean[] visited;
        for (int i = 1; i <= N; i++) {
            queue = new PriorityQueue<>();
            visited = new boolean[N+1];
            queue.add(new Node(i, 0));
            while (!queue.isEmpty()){
                Node now = queue.poll();
                int now_node = now.node;
                if (visited[now_node])
                    continue;
                visited[now_node] = true;

                for (Node tmp : arrayLists[now_node]){
                    int next = tmp.node;
                    int edge = tmp.edge;
                    if (D[i][next] > D[i][now_node] + edge){
                        D[i][next] = D[i][now_node] + edge;
                        queue.add(new Node(next, D[i][next]));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, D[X][i] + D[i][X]);
        }

        System.out.println(max);

    }
}
class Node implements Comparable<Node>{
    int node;
    int edge;

    Node(int node, int edge){
        this.node = node;
        this.edge = edge;
    }


    @Override
    public int compareTo(Node o) {
        if (this.edge > o.edge) return 1;
        else return -1;
    }
}
