package Programmers.kakao.P_택배배달과수거하기;

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0L;

        int di = n - 1; // 배달 마지막 인덱스
        int pi = n - 1; // 수거 마지막 인덱스

        // 뒤쪽의 0들은 미리 접기
        while (di >= 0 && deliveries[di] == 0) di--;
        while (pi >= 0 && pickups[pi] == 0) pi--;

        while (di >= 0 || pi >= 0) {
            // 이번 라운드 왕복 거리 = 더 먼 쪽 기준
            int far = Math.max(di, pi) + 1;
            ans += 2L * far;

            // 배달: cap만큼 소진
            int dCap = cap;
            while (di >= 0 && dCap > 0) {
                if (deliveries[di] == 0) { di--; continue; }
                int use = Math.min(dCap, deliveries[di]);
                deliveries[di] -= use;
                dCap -= use;
                if (deliveries[di] == 0) di--;
            }

            // 수거: cap만큼 소진
            int pCap = cap;
            while (pi >= 0 && pCap > 0) {
                if (pickups[pi] == 0) { pi--; continue; }
                int take = Math.min(pCap, pickups[pi]);
                pickups[pi] -= take;
                pCap -= take;
                if (pickups[pi] == 0) pi--;
            }

            while (di >= 0 && deliveries[di] == 0) di--;
            while (pi >= 0 && pickups[pi] == 0) pi--;
        }
        return ans;
    }
}

