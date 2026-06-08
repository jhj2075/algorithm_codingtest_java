package Programmers.JAVA.P_다음큰숫자;

class Solution {
    public int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int nOneCnt = 0;
        for (int i = 0; i < binaryN.length(); i++){
            if (binaryN.charAt(i) == '1')
                nOneCnt++;
        }

        int ans = n+1;
        while (true){
            String binaryAns = Integer.toBinaryString(ans);
            int ansOneCnt = 0;
            for (int i = 0; i < binaryAns.length(); i++){
                if (binaryAns.charAt(i) == '1')
                    ansOneCnt++;
            }
            if (ansOneCnt == nOneCnt)
                return ans;
            ans++;
        }
    }
}
