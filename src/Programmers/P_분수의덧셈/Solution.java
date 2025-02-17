package Programmers.P_분수의덧셈;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        if (denom1 % denom2 == 0 || denom2 % denom1 == 0){
            if (denom1 > denom2){
                int changeDenom2 = denom1;
                numer2 = numer2 * (changeDenom2 / denom2);
                answer[0] = numer1 + numer2;
                answer[1] = changeDenom2;
            }
            else {
                int changeDenom1 = denom2;
                numer1 = numer1 * (changeDenom1 / denom1);
                answer[0] = numer1 + numer2;
                answer[1] = changeDenom1;
            }
        }
        else {
            answer[1] = denom1 * denom2;
            numer1 = numer1 * (answer[1] / denom1);
            numer2 = numer2 * (answer[1] / denom2);
            answer[0] = numer1 + numer2;
        }
        int max = Math.max(answer[0], answer[1]);

        for (int i = 2; i < max; i++){
            if (answer[0] % i == 0 && answer[1] % i == 0){
                answer[0] = answer[0] / i;
                answer[1] = answer[1] / i;
                i--;
            }
        }
        return answer;
    }
}