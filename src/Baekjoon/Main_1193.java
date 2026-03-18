package Baekjoon;

import java.util.Scanner;

public class Main_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int prev_sum = 0;
        int cross_cnt = 1;

        while (true){

            if (X <= prev_sum + cross_cnt){
                if (cross_cnt % 2 == 1){
                    System.out.println((cross_cnt - (X - prev_sum - 1)) + "/" + (X - prev_sum));
                    break;
                }
                else {
                    System.out.println((X - prev_sum) + "/" + (cross_cnt - (X - prev_sum - 1)));
                    break;
                }
            }
            else {
                prev_sum += cross_cnt;
                cross_cnt++;
            }
        }
    }
}
