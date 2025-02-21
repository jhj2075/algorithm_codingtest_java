package Programmers.P_다리를지나는트럭;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waiting = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>(); // 무게, 다리를 다 건너는 순간의 시간

        for (int i : truck_weights){
            waiting.add(i);
        }
        int time = 0;
        int currentWeight = 0;
        while(!waiting.isEmpty() || !bridge.isEmpty()){
            time++;

            if (!bridge.isEmpty() && bridge.peek()[1] == time){
                currentWeight -= bridge.poll()[0];
            }

            if (!waiting.isEmpty() && (currentWeight + waiting.peek() <= weight)){
                int t = waiting.poll();
                bridge.add(new int[] {t, time + bridge_length});
                currentWeight += t;
            }

        }
        return time;
    }
}
