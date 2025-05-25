package Programmers.P_소수찾기;

import java.util.*;

class Solution {
    Set<Integer> set;
    boolean[] visited;

    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        DFS(numbers, "", 0);

        int ans = 0;
        for (Integer i : set){
            if (isPrime(i)){
                ans++;
            }
        }
        return ans;
    }

    void DFS(String numbers, String tmp, int depth){
        if (depth > numbers.length()){
            return;
        }

        for (int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(tmp + numbers.charAt(i)));
                DFS(numbers, tmp + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n){
        if (n < 2)
            return false;

        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
