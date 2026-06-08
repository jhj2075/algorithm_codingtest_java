package Programmers.JAVA.P_점프와순간이동;

public class Solution {
    public int solution(int n) {
        int ans = 1;

        while (true){
            if (n == 1)
                break;

            if (n % 2 == 1)
                ans++;

            n /= 2;
        }

        return ans;
    }
}