package Programmers.kakao.P_실패율;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] arr = new float[N];
        for (int i = 1; i <= N; i++){
            int c = 0;
            int f = 0;
            for (int j = 0; j < stages.length; j++){
                if (stages[j] >= i){
                    c++;
                }
                if (stages[j] == i)
                    f++;
            }
            arr[i-1] = (c == 0) ? 0 : (float)f / c;
        }

        answer = IntStream.range(0, arr.length)
                .boxed()
                .sorted((a, b) -> Float.compare(arr[b], arr[a]))
                .mapToInt(Integer::intValue)
                .map(i -> i + 1)
                .toArray();

        return answer;
    }
}
