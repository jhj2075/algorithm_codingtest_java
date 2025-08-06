package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 그래프 - 작업 (위상 정렬)
public class Main_2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] time = new int[n+1];
        int[] D = new int[n+1];
        int[] result = new int[n+1];
        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            int workCnt = sc.nextInt();
            for (int j = 0; j < workCnt; j++) {
                int a = sc.nextInt();
                arrayLists[a].add(i);
                D[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (D[i] == 0){
                queue.add(i);
                result[i] = time[i];
            }
        }

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int next : arrayLists[now]){
                D[next]--;

                result[next] = Math.max(result[next], result[now] + time[next]);

                if (D[next] == 0)
                    queue.offer(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }
}