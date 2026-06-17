package Programmers.JAVA.P_캐시;

import java.util.*;

class Solution {
  public int solution(int cacheSize, String[] cities) {
    Queue<String> cache = new LinkedList<>();

    if(cacheSize == 0){
      return cities.length * 5;
    }

    int cnt = 0;
    for (int i = 0; i < cities.length; i++){
      String cur = cities[i].toUpperCase();

      if (cache.size() < cacheSize){
        boolean f = false;
        String tmp = "";
        int size = cache.size();
        for(int j = 0; j < size; j++){
          String poll = cache.poll();
          if (poll.equals(cur)){
            f = true;
            tmp += poll;
          }
          else
            cache.add(poll);
        }
        if(f){
          cache.add(tmp);
          cnt += 1;
        } else {
          cache.add(cur);
          cnt += 5;

        }

      }
      else {
        boolean f = false;
        String tmp = "";
        for(int j = 0; j < cacheSize; j++){
          String poll = cache.poll();
          if (poll.equals(cur)){
            f = true;
            tmp += poll;
          }
          else
            cache.add(poll);
        }
        if(f){
          cache.add(tmp);
          cnt += 1;
        } else {
          cache.poll();
          cache.add(cur);
          cnt += 5;

        }

      }
    }

    return cnt;
  }
}
