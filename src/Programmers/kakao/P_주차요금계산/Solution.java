package Programmers.kakao.P_주차요금계산;

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> intime = new HashMap<>();
        TreeMap<String, Integer> result = new TreeMap<>();

        for (String record : records){
            String[] time = record.split(" ")[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);

            if (record.split(" ")[2].equals("IN")){
                intime.put(record.split(" ")[1], hour * 60 + min);
                if (!result.containsKey(record.split(" ")[1]))
                    result.put(record.split(" ")[1], 0);
            }
            else if (record.split(" ")[2].equals("OUT")){
                int intimeSum = intime.get(record.split(" ")[1]);
                int sum = hour * 60 + min - intimeSum;
                result.put(record.split(" ")[1], result.get(record.split(" ")[1]) + sum);
                intime.remove(record.split(" ")[1]);
            }
        }

        intime.forEach((key, val) -> {
            result.put(key, result.get(key) + 23 * 60 + 59 - val);
        });

        int[] ans = new int[result.size()];

        int idx = 0;
        for (int val : result.values()){
            ans[idx] = fees[1];
            if (val > fees[0]){
                ans[idx] += Math.ceil((val - fees[0]) / (double)fees[2]) * fees[3];
            }
            idx++;
        }

        return ans;
    }
}