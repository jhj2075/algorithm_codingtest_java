package Programmers.JAVA.P_멀리뛰기;

class Solution {
  public long solution(int n) {
    int[] d = new int[n+1];
    d[1] = 1;
    if (n > 1)
      d[2] = 2;

    if(n < 3)
      return d[n];

    for(int i = 3; i < d.length; i++){
      d[i] = (d[i-1] + d[i-2]) % 1234567;
    }

    return d[n];
  }
}
