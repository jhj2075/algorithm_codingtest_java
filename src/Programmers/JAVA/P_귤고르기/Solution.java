package Programmers.JAVA.P_귤고르기;

import java.util.*;

class Solution {
  public int solution(int k, int[] tangerine) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i : tangerine){
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int[] arr = new int[map.size()];
    int idx = 0;
    for (int i : map.keySet()){
      arr[idx++] = map.get(i);
    }

    Arrays.sort(arr);

    int ans = 0;
    int sum = 0;
    for (int i = arr.length-1; i >= 0; i--){
      ans++;
      sum += arr[i];
      if (sum >= k) return ans;
    }

    return -1;
  }
}
