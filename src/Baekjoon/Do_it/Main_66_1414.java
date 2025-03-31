package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 그래프 - 불우이웃돕기
public class Main_66_1414 {
    static int[] parent;
    static int n, sum;
    static PriorityQueue<lEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
                int c = 0;
                if (tmp[j] >= 'a' && tmp[j] <= 'z'){
                    c = tmp[j] - 'a' + 1;
                } else if (tmp[j] >= 'A' && tmp[j] <= 'Z') {
                    c = tmp[j] - 'A' + 27;
                }
                sum = sum + c;
                if (i != j && c != 0)
                    queue.add(new lEdge(i, j, c));
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()){
            lEdge now = queue.poll();
            if (find(now.s) != find(now.e)){
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        if (useEdge == n - 1)
            System.out.println(sum - result);
        else
            System.out.println(-1);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    public static int find(int a){
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}

class lEdge implements Comparable<lEdge>{
    int s, e, v;

    lEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge o) {
        return this.v - o.v;
    }
}