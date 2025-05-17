class CodingTest2 {
    public static int longestRoad(String road, int n) {
        int[] arr = new int[road.length()];
        for (int i = 0; i < road.length(); i++) {
            arr[i] = road.toCharArray()[i] - '0';
        }

        int start = 0;
        int end = 0;
        int max = 0;
        int cnt = 0;
        while (end < road.length()){
            if (arr[end] == 0){
                cnt++;
            }

            while (cnt > n){
                if (arr[start] == 0){
                    cnt--;
                }
                start++;
            }

            int length = end - start + 1;
            max = Math.max(max, length);

            end++;
        }


        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestRoad("111011110011111011111100011111", 3));  // ➜ 18
        System.out.println(longestRoad("001100", 5));                        // ➜ 6
    }

}
