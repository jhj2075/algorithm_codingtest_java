public class CodingTest5 {

    static int maxPower = 0;

    public static int solution(int[] players, int power, int k) {
        maxPower = 0;
        dfs(players, 0, power, 0, k);
        return maxPower;
    }

    private static void dfs(int[] players, int round, int power, int streak, int k) {
        if (round == players.length) {
            maxPower = Math.max(maxPower, power);
            return;
        }

        int enemy = players[round];

        // 1. 고의 패배
        dfs(players, round + 1, power + k, 0, k);

        // 2. 정상 경기
        if (power >= enemy) {
            dfs(players, round + 1, power + (streak + 1), streak + 1, k);
        }
    }

    public static void main(String[] args) {
        int[] players = {1, 1, 2};
        int power = 1;
        int k = 1;

        System.out.println(solution(players, power, k)); // 출력: 6
    }
}
