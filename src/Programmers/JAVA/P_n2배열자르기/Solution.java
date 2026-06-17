package Programmers.JAVA.P_n2배열자르기;

class Solution {
  public int[] solution(int n, long left, long right) {

    int[] ans = new int[(int)(right - left + 1)];
    int index = 0;
    for(long i = left; i <= right; i++){
      long idx = i % n + 1;
      long min = i / n + 1;
      ans[index] = (int)(idx >= min ? idx : min);
      index++;
    }

    return ans;
  }
}
