package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 스택과 큐 - 큐
public class Main_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int x = 0;
        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                x = sc.nextInt();
                queue.add(x);
            }
            else if (command.equals("pop")) {
                if (!queue.isEmpty())
                    System.out.println(queue.poll());
                else
                    System.out.println(-1);
            }
            else if (command.equals("size")) {
                System.out.println(queue.size());
            }
            else if (command.equals("empty")) {
                if (queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if (command.equals("front")) {
                if (!queue.isEmpty())
                    System.out.println(queue.peek());
                else
                    System.out.println(-1);
            }
            else if (command.equals("back")) {
                if (!queue.isEmpty())
                    System.out.println(x);
                else
                    System.out.println(-1);
            }
        }
    }
}
