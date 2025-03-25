package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 그래프 - 세일즈맨의 고민
public class Main_60_1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edge3[] edges = new edge3[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new edge3(s, e, value);
        }
        st = new StringTokenizer(br.readLine());
        long[] income = new long[n];
        for (int i = 0; i < n; i++) {
            income[i] = Long.parseLong(st.nextToken());
        }
        long[] D = new long[n];
        for (int i = 0; i < n; i++) {
            D[i] = Long.MIN_VALUE;
        }
        D[start] = income[start];
        for (int i = 0; i <= n+100; i++) {
            for (int j = 0; j < m; j++) {
                int s = edges[j].s;
                int e = edges[j].e;
                int value = edges[j].value;
                if (D[s] == Long.MIN_VALUE) continue;
                else if (D[s] == Long.MAX_VALUE) {
                    D[e] = Long.MAX_VALUE;
                } else if (D[e] < D[s] + income[e] - value) {
                    D[e] = D[s] + income[e] - value;
                    if (i >= n-1){
                        D[e] = Long.MAX_VALUE;
                    }
                }
            }
        }
        if (D[end] == Long.MIN_VALUE)
            System.out.println("gg");
        else if (D[end] == Long.MAX_VALUE)
            System.out.println("Gee");
        else
            System.out.println(D[end]);
    }
}
class edge3{
    int s, e, value;

    public edge3(int s, int e, int value){
        this.s = s;
        this.e = e;
        this.value = value;
    }
}
