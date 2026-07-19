package Programmers.JAVA;

public class P_정수삼각형 {

    public int solution(int[][] triangle) {

        int[][] d = new int[triangle.length][triangle[triangle.length-1].length];

        d[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                int left = 0;
                int right = 0;

                if (j-1 >= 0)
                    left = triangle[i][j] + d[i-1][j-1];

                if (i != j)
                    right = triangle[i][j] + d[i-1][j];


                d[i][j] = Math.max(left, right);
            }
        }

        int ans = 0;
        for(int i = 0; i < triangle.length; i++){
            ans = Math.max(ans, d[triangle.length-1][i]);
        }

        return ans;
    }
}
