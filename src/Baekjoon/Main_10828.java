package Baekjoon;

import java.util.Scanner;
import java.util.Stack;


// 스택과 큐 - 스택
public class Main_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("push")){
                int x = sc.nextInt();
                stack.push(x);
            }
            else if (command.equals("pop")) {
                if (!stack.isEmpty())
                    System.out.println(stack.pop());
                else
                    System.out.println(-1);
            }
            else if (command.equals("size")) {
                System.out.println(stack.size());
            }
            else if (command.equals("empty")) {
                if (stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if (command.equals("top")) {
                if (!stack.isEmpty())
                    System.out.println(stack.peek());
                else
                    System.out.println(-1);
            }
        }
    }
}
