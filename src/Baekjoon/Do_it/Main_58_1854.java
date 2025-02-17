package Baekjoon.Do_it;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 그래프 - k번째 최단 경로 찾기
public class Main_58_1854 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] w = new int[n+1][n+1];
        PriorityQueue<Integer>[] queue = new PriorityQueue[n+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        };
        for (int i = 0; i < n+1; i++){
            queue[i] = new PriorityQueue<>(k, cp); // 큐 크기, comparator 지정
        }
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            w[a][b] = c;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        queue[1].add(0);
        while (!pq.isEmpty()){
            Node now = pq.poll();
            for (int i = 1; i <= n; i++){
                if (w[now.node][i] != 0){
                    if (queue[i].size() < k){
                        queue[i].add(now.cost + w[now.node][i]);
                        pq.add(new Node(i, now.cost + w[now.node][i]));
                    }
                    else if (queue[i].peek() > now.cost + w[now.node][i]){
                        queue[i].poll();
                        queue[i].add(now.cost + w[now.node][i]);
                        pq.add(new Node(i, now.cost + w[now.node][i]));
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++){
            if (queue[i].size() == k){
                bw.write(queue[i].peek() + "\n");
            }
            else
                bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
class Node implements Comparable<Node>{
    int node;
    int cost;
    Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost < o.cost ? -1 : 1;
    }
}
