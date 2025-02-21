package Programmers.P_프로세스;

import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        char[] arr = new char[priorities.length];
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++){
            arr[i] = (char)('A' + i);
            q.add(new Process(arr[i], priorities[i]));
        }
        Arrays.sort(priorities);
        int max = priorities[priorities.length - 1];
        int k = 0;
        int j = priorities.length - 1;
        char[] ans = new char[priorities.length];
        while(!q.isEmpty()){
            Process p = q.remove();
            if (p.pr < max){
                q.add(p);
            }
            else {
                ans[k] = p.c;
                k++;
                j--;
                if (j >= 0)
                    max = priorities[j];
            }
        }
        char target = (char)('A' + location);
        for (int i = 0; i < priorities.length; i++){
            if (ans[i] == target){
                answer = i+1;
            }
        }

        return answer;
    }
}
class Process{
    char c;
    int pr;

    Process(char c, int pr){
        this.c = c;
        this.pr = pr;
    }
}
