package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_68_1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int parent = sc.nextInt();
            if (parent != -1)
                tree[parent].add(i);
        }
    }
}
