package Programmers.P_개인정보수집유효기간;

import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms){
            String[] tmp = term.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        String[] t = today.split("\\.");
        int ty = Integer.parseInt(t[0]);
        int tm = Integer.parseInt(t[1]);
        int td = Integer.parseInt(t[2]);

        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for (String privacie : privacies){
            String[] date = privacie.split("\\.");
            String[] pterm = date[2].split(" ");
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(pterm[0]);
            String type = pterm[1];

            // 1) 개월 더하기를 '총 개월수'로 처리 (다년 케이스 포함)
            int add = map.get(type);
            int totalMonths = y * 12 + m + add; // 1-based month 걸로 계산
            y = (totalMonths - 1) / 12;
            m = (totalMonths - 1) % 12 + 1;

            d--;
            if (d == 0) {
                d = 28;
                m--;
                if (m == 0) { m = 12; y--; }
            }

            if (ty > y){
                list.add(cnt++);
                continue;
            }
            else if (ty == y){
                if (tm > m){
                    list.add(cnt++);
                    continue;
                }
                else if (tm == m){
                    if (td > d){
                        list.add(cnt++);
                        continue;
                    }
                }
            }
            cnt++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
