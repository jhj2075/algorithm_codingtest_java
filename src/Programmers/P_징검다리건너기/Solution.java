package Programmers.P_징검다리건너기;
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;  // stones[i]의 최대값
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;     // mid 명은 건널 수 있으므로, 더 많은 명수 시도
                left = mid + 1;
            } else {
                right = mid - 1;  // mid 명은 못 건너니까 줄여야 함
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;

        for (int stone : stones) {
            if (stone < people) {
                count++;
                if (count >= k) {
                    return false; // 연속으로 k개 이상 못 밟으면 실패
                }
            } else {
                count = 0;  // 다시 밟을 수 있는 돌 만나면 리셋
            }
        }

        return true;
    }
    // 이렇게 슬라이딩 윈도우로 풀면 정답은 나오지만 효율성 검사 통과를 못함
    // 아무래도 이중 for문 때문인듯
//    public int solution(int[] stones, int k) {
//        int answer = Integer.MAX_VALUE;
//
//        for (int i = 0; i <= stones.length - k; i++) {
//            int maxInWindow = 0;
//            for (int j = i; j < i + k; j++) {
//                maxInWindow = Math.max(maxInWindow, stones[j]);
//            }
//            answer = Math.min(answer, maxInWindow);
//        }
//        return answer;
//    }
}