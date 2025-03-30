package Baekjoon.Do_it;

import java.util.*;


// 문제 좀 그렇네.. 못 풀었음 다시 봐야함
// 그래프 -
public class Main_65_17472 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] parent;
    static int[][] map;
    static int n, m, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;
    static PriorityQueue<bEdge> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && visited[i][j] != true){
                    BFS(i, j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        queue = new PriorityQueue<>();
    }

    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int d = 0; d < 4; d++) {
                int tmpR = dr[d];
                int tmpC = dc[d];
                while (r + tmpR >= 0 && r + tmpR < n && c + tmpC >= 0 && c + tmpC < m){
                    if (visited[r + tmpR][c + tmpC] == false && map[r + tmpR][c + tmpC] != 0){
                        addNode(r + tmpR, c + tmpC, queue);
                    }
                    else break;
                    if (tmpR < 0)
                        tmpR--;
                    else if (tmpR > 0)
                        tmpR++;
                    else if (tmpC < 0)
                        tmpC--;
                    else if (tmpC > 0)
                        tmpC++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] tmp = {i, j};
        mlist.add(tmp);
        queue.add(tmp);
    }
}

class bEdge implements Comparable<bEdge>{
    int s, e, v;

    bEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(bEdge o) {
        return this.v - o.v;
    }
}