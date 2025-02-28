package Baekjoon;

import java.util.Scanner;
import java.util.Stack;


// 제로 (구현 문제인데 스택 사용해서 풀었음)
public class Main_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input == 0){
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
