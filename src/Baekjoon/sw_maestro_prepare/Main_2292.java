package Baekjoon.sw_maestro_prepare;

import java.util.Scanner;

public class Main_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;
        int i = 2;
        int j = 0;
        while (true){
            i = i + 6 * j;
            if (n >= i)
                cnt++;
            else break;
            j++;
        }
        System.out.println(cnt);
    }
}
