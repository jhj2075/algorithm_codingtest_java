package Programmers.P_피로도;

class Solution {
    int ans;
    boolean visited[];
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        visited = new boolean[dungeons.length];
        DFS(k, dungeons, 0);
        return ans;
    }
    void DFS(int k, int[][] dungeons, int depth){
        for (int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                DFS(k - dungeons[i][1], dungeons, depth + 1);
                visited[i] = false;
            }
        }
        ans = Math.max(ans, depth);
    }
}