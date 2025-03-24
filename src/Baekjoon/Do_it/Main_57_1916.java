package Baekjoon.Do_it;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


// 그래프 - 최소 비용 구하기
public class Main_57_1916 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Node1>[] arrayLists = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int value = sc.nextInt();
            arrayLists[s].add(new Node1(e, value));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node1> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        pq.add(new Node1(start, 0));
        while (!pq.isEmpty()){
            Node1 now = pq.poll();
            int now_t = now.target;
            if (!visited[now_t]){
                visited[now_t] = true;
                for (Node1 i : arrayLists[now_t]){
                    int tmp_t = i.target;
                    int tmp_v = i.value;
                    if (distance[tmp_t] > distance[now_t] + tmp_v){
                        distance[tmp_t] = distance[now_t] + tmp_v;
                        pq.add(new Node1(tmp_t, distance[tmp_t]));
                    }
                }
            }
        }
        System.out.println(distance[end]);
    }
}
class Node1 implements Comparable<Node1>{
    int target;
    int value;

    public Node1(int target, int value){
        this.target = target;
        this.value = value;
    }

    @Override
    public int compareTo(Node1 o) {
        return value - o.value;
    }
}
