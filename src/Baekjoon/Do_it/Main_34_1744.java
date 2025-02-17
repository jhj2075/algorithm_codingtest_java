package Baekjoon.Do_it;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


// 그리디 - 수를 묶어서 최댓값 만들기
public class Main_34_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oneCnt = 0;
        int zeroCnt = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            if (a == 1)
                oneCnt++;
            else if (a == 0)
                zeroCnt++;
            else if (a > 1)
                pQueue.add(a);
            else
                mQueue.add(a);
        }
        int sum = 0;
        // 내림 차순으로 들어가는 pQueue에서 큰 수부터 꺼내서 곱해서 더하기
        while (pQueue.size() > 1){
            int a = pQueue.remove();
            int b = pQueue.remove();
            sum += a * b;
        }
        if (!pQueue.isEmpty())
            sum += pQueue.remove();

        // 오름 차순으로 들어가는 mQueue에서 작은 수 부터 꺼내서 곱해서 더하기
        while (mQueue.size() > 1){
            int a = mQueue.remove();
            int b = mQueue.remove();
            sum += a * b;
        }

        // 0이 없는 경우 mQueue의 남은 음수를 더하기 (0이 있으면 mQueue 남은 수와 곱해 없애므로 아무 연산도 하지 않음)
        if (!mQueue.isEmpty()) {
            if (zeroCnt == 0)
                sum += mQueue.remove();
        }
        // 1 갯수만큼 더하기
        sum += oneCnt;

        System.out.println(sum);
    }
}
