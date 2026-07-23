package Programmers.JAVA;

public class P_연속된부분수열의합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {

            int[] ans = new int[2];

            boolean found = false;
            int l = 0;
            int r = 0;
            int sum = sequence[0];
            while(r < sequence.length){

                if(sum > k){
                    sum -= sequence[l];
                    l++;
                }
                else if(sum == k){
                    if (!found) {
                        ans[0] = l;
                        ans[1] = r;
                        found = true;
                    }
                    else if (ans[1] - ans[0] > r - l) {
                        ans[0] = l;
                        ans[1] = r;
                    }
                    r++;
                    if (r < sequence.length)
                        sum += sequence[r];
                }
                else{
                    r++;
                    if (r < sequence.length)
                        sum += sequence[r];
                }
            }

            return ans;
        }
    }
}
