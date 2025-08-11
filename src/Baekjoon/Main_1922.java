package Baekjoon;


import java.util.PriorityQueue;
import java.util.Scanner;

// 그래프 - 네트워크 연결(최소 신장 트리)
public class Main_1922 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            pq.add(new edge(a, b, c));
        }

        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()){
            edge now = pq.poll();

            if (find(now.s) != find(now.e)){
                union(now.s, now.e);
                sum += now.v;
                cnt++;
                if (cnt == N-1)
                    break;
            }
        }
        System.out.println(sum);
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        parent[pb] = pa;
    }

    static int find(int n){
        if (parent[n] == n)
            return n;
        else {
            return parent[n] = find(parent[n]);
        }
    }
    static class edge implements Comparable<edge>{
        int s, e, v;

        edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(edge o) {
            return this.v - o.v;
        }
    }
}
