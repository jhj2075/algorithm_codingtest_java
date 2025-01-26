import java.util.Arrays;

class CodingTest1 {
    public int[] s1(long s1, long s2){
        int[] answer = {};
        char[] S1 = Long.toString(s1).toCharArray();
        long[] s1Arr = new long[10];
        for (int i = 0; i < S1.length; i += 2){
            s1Arr[S1[i] - '0'] = S1[i+1] - '0';
        }
        // s2로 만들 수 있는 숫자를 막 만드는 반복문 중에 s2로 만든 숫자 - 1 == s1 으로 만든 숫자 나오면 break?
        for (int i = 1; i < 10; i++){
            if (s1Arr[i] != 0){

            }
        }
        return answer;

    }
}
