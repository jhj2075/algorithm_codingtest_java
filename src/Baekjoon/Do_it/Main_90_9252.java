package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// 동적 계획법 - 최장 공통 부분 수열 찾기
public class Main_90_9252 {
    public static char[] a;
    public static char[] b;
    public static long[][] d;
    public static ArrayList<Character> path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        d = new long[a.length+1][b.length+1];
        path = new ArrayList<>();

        for (int i = 1; i <= a.length; i++){
            for (int j = 1; j <= b.length; j++){
                if (a[i-1] == b[j-1]){
                    d[i][j] = d[i-1][j-1] + 1;
                }
                else d[i][j] = Math.max(d[i][j-1], d[i-1][j]);
            }
        }
        System.out.println(d[a.length][b.length]);
        getText(a.length, b.length);
        for (int i = path.size()-1; i >= 0; i--){
            System.out.print(path.get(i));
        }

    }
    public static void getText(int r, int c){
        if (r == 0 || c == 0)
            return;
        if (a[r - 1] == b[c - 1]){
            path.add(a[r - 1]);
            getText(r - 1, c - 1);
        }
        else {
            if (d[r -1][c] > d[r][c -1])
                getText(r - 1, c);
            else getText(r, c-1);
        }
    }
}
