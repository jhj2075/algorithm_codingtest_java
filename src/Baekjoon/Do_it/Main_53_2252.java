package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 그래프 - 줄 세우기
public class Main_53_2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] D = new int[n+1];
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            D[b]++;
            arrayLists[a].add(b);
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (D[i] == 0) {
                    visited[i] = true;
                    list.add(i);
                    for (int j : arrayLists[i]) {
                        D[j]--;
                    }
                    i = 0;
                }
            }
        }

        for (int i : list){
            System.out.print(i + " ");
        }
    }
}
