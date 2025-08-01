package Baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


// 그리디 - 강의실 배정
public class Main_11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr[i] = new Node(s, t);
        }

        // 시작시간 기준 오름차순 정렬
        Arrays.sort(arr, Comparator.comparingInt(o -> o.s));

        // 끝시간 기준 오름차순 정렬되도록 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0].t);

        for (int i = 1; i < n; i++) {
            // 끝시간이 가장 빠른 강의랑 시작시간이 가장 빠른 강의랑 비교해서
            // 시작시간이 가장 빠른 강의가 더 크면 그 강의실에 배치할 수 있으므로 그 앞 강의인
            // 끝시간이 가장 빠른 강의는 우선순위 큐에서 빼주고
            if (queue.peek() <= arr[i].s){
                queue.poll();
            }
            // 새로운 강의는 넣어줌
            // 만약 기존 강의들 중에 끝난게 없으면 새로운 강의실에 배치한다는 의미
            queue.add(arr[i].t);
        }
        // 남은 강의 갯수가 사용돼야하는 강의실 갯수
        System.out.println(queue.size());
    }

    private static class Node{
        int s,t;

        Node(int s, int t){
            this.s = s;
            this.t = t;
        }
    }
}
