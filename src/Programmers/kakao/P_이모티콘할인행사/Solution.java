package Programmers.kakao.P_이모티콘할인행사;

class Solution {
    int[] ans = new int[2];
    int[][] users;
    int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;

        back(arr, 0);
        return ans;
    }

    void back(int[] arr, int depth){
        if (arr.length == depth){
            cal(arr);
            return;
        }

        for (int i = 10; i <= 40; i += 10){
            arr[depth] = i;
            back(arr, depth+1);
        }
    }

    void cal(int[] arr){
        int[] result = new int[2];
        for (int i = 0; i < users.length; i++){
            int sum = 0;
            for (int j = 0; j < emoticons.length; j++){
                if (arr[j] >= users[i][0]){
                    sum += emoticons[j] * (100 - arr[j]) / 100;
                }
            }

            if (sum >= users[i][1]){
                result[0]++;
            }
            else {
                result[1] += sum;
            }
        }

        if (ans[0] < result[0]){
            ans[0] = result[0];
            ans[1] = result[1];
        }

        if (ans[0] == result[0] && ans[1] < result[1]){
            ans[0] = result[0];
            ans[1] = result[1];
        }
    }
}
