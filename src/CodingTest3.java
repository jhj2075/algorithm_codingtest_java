import java.util.*;

public class CodingTest3 {
    public int[] calculateSales(int[][] goods, int[][] relations, int[] customers) {
        int maxProduct = 0;

        // 상품의 최대 번호 찾기
        for (int[] row : goods) {
            for (int product : row) {
                maxProduct = Math.max(maxProduct, product);
            }
        }

        // 그래프 초기화 (상품 연결 정보 저장)
        ArrayList<Integer>[] graph = new ArrayList[maxProduct + 1];
        for (int i = 1; i <= maxProduct; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연관성 정보를 바탕으로 그래프 구축
        for (int[] relation : relations) {
            int a = relation[0]; // 상품 번호는 1 이상
            int b = relation[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] union = new int[maxProduct+1];
        for (int i = 1; i <= maxProduct; i++){
            union[i] = i;
        }
        for (int i = 0; i < goods.length; i++){
            for (int j = 0; j < goods[i].length; j++){
                union[goods[i][j]] = goods[i][0];
            }
        }
        int[] ans = new int[maxProduct];
        for (int i = 0; i < maxProduct; i++){
            ans[i] = customers[i];
        }
        for (int i = 1; i <= maxProduct; i++){
            for (int j : graph[i]){
                if (union[i] == union[j]) // 같은 진열대
                    ans[j-1] += customers[i-1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CodingTest3 sol = new CodingTest3();
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

        int[] result = sol.calculateSales(goods, relations, customers);
        System.out.println(Arrays.toString(result));
    }
}
