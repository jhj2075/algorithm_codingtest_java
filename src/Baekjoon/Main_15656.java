package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// N과 M(7) (백트래킹, Scanner와 br은 차이가 많이 없는데 sout이랑 bw는 시간에서 차이가 많이 나나봄)
public class Main_15656 {
    static int n;
    static int m;
    static int[] input;
    static int[] ans;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n];
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
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

        for (int i = 0; i < n; i++) {
            ans[depth] = input[i];
            backtracking(depth + 1);
        }
    }
}
