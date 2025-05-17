import java.util.*;

public class CodingTest3 {
    public static int[] calculateSales(int[][] goods, int[][] relations, int[] customers) {
        int n = 0;

        // 상품의 최대 번호 찾기
        for (int[] row : goods) {
            for (int i : row) {
                n = Math.max(n, i);
            }
        }

        // 그래프 초기화 (상품 연결 정보 저장)
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        // 연관성 정보를 바탕으로 그래프 구축
        for (int[] relation : relations) {
            int a = relation[0]; // 상품 번호는 1 이상
            int b = relation[1];
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++){
            p[i] = i;
        }

        // 각 진열대의 맨 앞을 기준으로 부모 배열 만듦
        for (int[] good : goods) {
            for (int i : good) {
                p[i] = good[0];
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = customers[i];
        }
        for (int i = 1; i <= n; i++){
            for (int j : arrayLists[i]){
                if (p[i] == p[j]) // 같은 진열대
                    ans[j-1] += customers[i-1];
            }
        }

        return ans;

        // goods 배열은 유니온 파인드의 parent 배열로 만들고
        // relations 배열은 양방향 그래프 나타내는 arraylist로 만들고
        // 그래프에서 꺼내서 같은 진열대면 customers 배열에 더해주는 ans 배열 만들어주고 리턴
    }

    public static void main(String[] args) {
        int[][] goods = {
                {2, 3, 10, 11},
                {1, 4, 7, 8},
                {5, 6, 9, 12}
        };
        int[][] relations = {
                {1, 4}, {1, 2}, {2, 3}, {3, 10}, {3, 11},
                {4, 7}, {4, 8}, {4, 5}, {7, 9}, {10, 12}
        };
        int[] customers = {3, 2, 4, 1, 5, 2, 3, 0, 1, 1, 2, 6};

        System.out.println(Arrays.toString(calculateSales(goods, relations, customers)));
    }
}
