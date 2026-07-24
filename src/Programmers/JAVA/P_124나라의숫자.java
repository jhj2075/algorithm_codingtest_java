package Programmers.JAVA;

public class P_124나라의숫자 {
    class Solution {
        public String solution(int n) {
            StringBuilder ans = new StringBuilder();

            while(n >= 3){
                if(n % 3 == 0){
                    ans.append(4);
                    n = n / 3  - 1;
                }
                else{
                    ans.append(n % 3);
                    n /= 3;
                }
            }
            if(n != 0)
                ans.append(n);
            ans.reverse();

            return ans.toString();

        }
    }
}
