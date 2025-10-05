package Programmers.kakao.P_신고결과받기;

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++){
            map.put(id_list[i], 0);
        }

        Set<String> set = new HashSet<>(Arrays.asList(report));
        String[] uniq = set.toArray(new String[0]);

        for(int i = 0; i < uniq.length; i++){
            String bp = uniq[i].split(" ")[1];
            int tmp = map.get(bp);
            map.put(bp, tmp+1);
        }

        for (int i = 0; i < id_list.length; i++){
            if (map.get(id_list[i]) < k){
                map.remove(id_list[i]);
            }
        }

        for (int i = 0; i < uniq.length; i++){
            String rp = uniq[i].split(" ")[0];
            String bp = uniq[i].split(" ")[1];
            if (map.containsKey(bp)){
                for (int j = 0; j < id_list.length; j++){
                    if (id_list[j].equals(rp)){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}
