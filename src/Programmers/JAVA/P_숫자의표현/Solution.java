package Programmers.JAVA.P_숫자의표현;

class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++){
            arr[i] = i;
        }

        int i = 1;
        int j = 1;
        int cnt = 0;
        while(i <= j && j <= n){
            int sum = 0;
            for (int k = i; k <= j; k++){
                sum += arr[k];
            }

            if (sum == n){
                cnt++;
                i++;
            }
            else if (sum < n)
                j++;
            else
                i++;
        }

        return cnt;
    }
}