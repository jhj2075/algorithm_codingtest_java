package Programmers.JAVA.P_N개최소공배수;

class Solution {
    public int solution(int[] arr) {
        int ans = 1;

        for(int i = 0; i < arr.length; i++){
            ans = lcm(ans, arr[i]);
        }

        return ans;
    }

    int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}
