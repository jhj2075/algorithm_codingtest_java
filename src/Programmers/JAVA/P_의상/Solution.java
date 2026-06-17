package Programmers.JAVA.P_의상;

import java.util.*;

class Solution {
  public int solution(String[][] clothes) {
    int comb = 1;

    Map<String, Integer> map = new HashMap<>();

    for (String[] cloth : clothes){
      map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
    }

    for (String key : map.keySet()){
      comb *= map.get(key) + 1; // 해당 종류 안 입는 경우 + 1
    }

    return comb - 1; // 아무것도 안 입는 경우 - 1
  }
}
