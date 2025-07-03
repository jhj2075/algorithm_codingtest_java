package Baekjoon;

import java.util.Scanner;


// 그리디 - A -> B
public class Main_16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int cnt = 1;
        while (B != A){
            if (B < A) {
                cnt = -1;
                break;
            }

            if (B % 2 == 0){
                B /= 2;
                cnt++;
            }
            else if (B % 10 == 1){
                B /= 10;
                cnt++;
            }
            else {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
