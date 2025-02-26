package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;


// N과 M(3) (백트래킹, 시간초과 때문에 sout이 아닌 bw로 출력)
public class Main_15651 {
    static int n;
    static int m;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[m];
        backtracking(0);
        bw.flush();
        bw.close();
    }
    static void backtracking(int depth) throws IOException {
        if (depth == m){
            for (int i : ans) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++){
            ans[depth] = i;
            backtracking(depth + 1);
        }
    }
}
