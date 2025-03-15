package Baekjoon.Do_it;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (c % gcd(a, b) != 0)
            System.out.println(-1);
        else {
            int mok = (int) (c /gcd(a, b));
            long[] arr = execute(a, b);
            System.out.println(arr[0] * mok + " " + arr[1] * mok);
        }
    }
    static long[] execute(long a, long b){
        long[] arr = new long[2];
        if (b == 0){
            arr[0] = 1;
            arr[1] = 0;
            return arr;
        }
        long q = a / b;
        long[] v = execute(b, a % b);
        arr[0] = v[1];
        arr[1] = v[0] - v[1] * q;
        return arr;
    }
    static long gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
