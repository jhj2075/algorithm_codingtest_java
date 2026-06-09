package Programmers.JAVA.P_할인행사;

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> map;

        int result = 0;
        int i = 0;
        int j = 9;
        while (j < discount.length){
            map = new HashMap<>();
            for (int k = 0; k < want.length; k++){
                map.put(want[k], number[k]);
            }

            int l = i;
            int r = j;

            boolean flag = true;
            while (l <= r){
                if (map.get(discount[l]) == null || map.get(discount[l]) == 0){
                    flag = false;
                    break;
                }

                map.put(discount[l], map.get(discount[l]) - 1);

                l++;
            }

            if (flag)
                result++;

            i++;
            j++;
        }
        return result;
    }
}