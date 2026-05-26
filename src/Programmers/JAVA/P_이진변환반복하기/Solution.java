package Programmers.JAVA.P_이진변환반복하기;

class Solution {
    public int[] solution(String s) {

        String result = s;
        String tmp = "";
        int cnt = 0;
        int zeroCnt = 0;

        while (result.length() > 1){
            for (int i = 0; i < result.length(); i++){
                if (result.charAt(i) != '0')
                    tmp += "1";
                else
                    zeroCnt++;
            }
            result = Integer.toBinaryString(tmp.length());
            tmp = "";
            cnt++;
        }
        return new int[]{cnt, zeroCnt};
    }
}
