package Baekjoon.Do_it;

import java.util.Scanner;


// 트리 - 트리 순회하기
public class Main_70_1991 {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[2][n];
        for (int i = 1; i <= n; i++) {
            char[] root = sc.next().toCharArray();
            char[] left = sc.next().toCharArray();
            char[] right = sc.next().toCharArray();
            arr[0][root[0] - 65] = left[0];
            arr[1][root[0] - 65] = right[0];
        }
        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
    }
    public static void preOrder(char now){
        if (now == '.')
            return;

        System.out.print(now);
        preOrder(arr[0][now - 65]);
        preOrder(arr[1][now - 65]);
    }

    public static void inOrder(char now){
        if (now == '.')
            return;

        inOrder(arr[0][now - 65]);
        System.out.print(now);
        inOrder(arr[1][now - 65]);
    }

    public static void postOrder(char now){
        if (now == '.')
            return;

        postOrder(arr[0][now - 65]);
        postOrder(arr[1][now - 65]);
        System.out.print(now);
    }
}
