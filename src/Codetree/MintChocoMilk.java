package Codetree;

import java.util.*;

public class MintChocoMilk {
    static int N;
    static int[][] F;
    static int[][] B;
    static int[][] dxy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();

        F = new int[N][N];
        B = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                if(tmp[j] == 'T') F[i][j] = 4;
                else if(tmp[j] == 'C') F[i][j] = 2;
                else F[i][j] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < T; i++) {
            // 아침시간 생략
            // 점심시간
            List<Point> heads = noon();
            // 저녁시간
            evening(heads);
            // 출력
            printAll();
        }
    }

    static List<Point> noon() {
        // 그룹 형성, 대표자 선정
        boolean[][] visited = new boolean[N][N];

        List<Point> heads = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    heads.add(getHeadAndAdd(visited, i, j));
                }
            }
        }
        return heads;
    }

    static Point getHeadAndAdd(boolean[][] visited, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        int cnt = 1;
        int hx = x;
        int hy = y;

        while(!q.isEmpty()) {
            Point current = q.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dxy[i][0];
                int ny = cy + dxy[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || F[cx][cy] != F[nx][ny])
                    continue;

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                cnt++;

                if (B[nx][ny] > B[hx][hy]) {
                    hx = nx;
                    hy = ny;
                }
                else if (B[nx][ny] == B[hx][hy]){ //
                    if (nx < hx) {
                        hx = nx;
                        hy = ny;
                    }
                    else if (nx == hx && ny < hy) {
                        hx = nx;
                        hy = ny;
                    }
                }
            }
        }
        B[hx][hy] += cnt;

        return new Point(hx, hy);
    }

    static void evening(List<Point> heads) {
        // 전파 순서 설정을 위한 정렬
        heads.sort((a, b) ->{
            int foodCountA = getFoodCount(F[a.x][a.y]);
            int foodCountB = getFoodCount(F[b.x][b.y]);
            if (foodCountA != foodCountB)
                return Integer.compare(foodCountA, foodCountB); // 단일 음식 -> 이중 조합 -> 삼중 조합 순이니까 오름차순 정렬

            int beliefA = B[a.x][a.y];
            int beliefB = B[b.x][b.y];
            if (beliefA != beliefB)
                return Integer.compare(beliefB, beliefA); // 신앙심이 높은 순이니까 내림차순 정렬

            if (a.x != b.x)
                return Integer.compare(a.x, b.x);

            return Integer.compare(a.y, b.y);
        });

        boolean[][] isDefend = new boolean[N][N];

        for (Point head : heads) {
            int x = head.x;
            int y = head.y;

            if (isDefend[x][y])
                continue;

            int X = B[x][y] - 1; // 간절함
            int dirIdx = B[x][y] % 4; // 전파 방향
            B[x][y] = 1;
            int food = F[x][y];

            int curX = x;
            int curY = y;

            while(true) {
                curX += dxy[dirIdx][0];
                curY += dxy[dirIdx][1];

                if (curX < 0 || curX >= N || curY < 0 || curY >= N || X <= 0)
                    break;

                if (food == F[curX][curY])
                    continue;

                isDefend[curX][curY] = true;
                if (X > B[curX][curY]) {
                    // 강한 전파
                    F[curX][curY] = food;
                    X -= (B[curX][curY] + 1);
                    B[curX][curY] += 1;
                }
                else {
                    // 약한 전파
                    F[curX][curY] |= food;
                    B[curX][curY] += X;
                    break;
                }
            }
        }
    }

    static int getFoodCount(int food) {
        if (food == 1 || food == 2 || food == 4) return 1;
        if (food == 3 || food == 5 || food == 6) return 2;
        return 3;
    }

    static void printAll() {
        int[] sum = new int[7];
        // 7 6 5 3 1 2 4
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (F[i][j] == 7) sum[0] += B[i][j];
                else if (F[i][j] == 6) sum[1] += B[i][j];
                else if (F[i][j] == 5) sum[2] += B[i][j];
                else if (F[i][j] == 3) sum[3] += B[i][j];
                else if (F[i][j] == 1) sum[4] += B[i][j];
                else if (F[i][j] == 2) sum[5] += B[i][j];
                else if (F[i][j] == 4) sum[6] += B[i][j];
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(sum[i] + " ");
        }
        System.out.println();
    }
}
