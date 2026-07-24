package Programmers.JAVA;

public class P_퍼즐게챌린지 {
    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {

            int l = 1;
            int r = 100_000;
            int ans = Integer.MAX_VALUE;
            while(l <= r){

                int level = (l + r) / 2;
                long consume_time = times[0];
                for(int i = 1; i < diffs.length; i++){

                    int diff = diffs[i];
                    int time_cur = times[i];
                    int time_prev = times[i-1];

                    if(diff <= level){
                        consume_time += time_cur;
                    }
                    else{
                        consume_time += ((time_cur + time_prev) * (diff - level) + time_cur);
                    }
                }

                if(consume_time <= limit){
                    ans = Math.min(ans, level);
                    r = level - 1;
                }
                else{
                    l = level + 1;
                }
            }

            return ans;
        }
    }
}
