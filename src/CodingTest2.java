class CodingTest2 {
    public int longestRoad(String road, int n) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for (int right = 0; right < road.length(); right++) {
            if (road.charAt(right) == '0') {
                zeroCount++;  // 손상된 부분 발견 시 카운트 증가
            }

            while (zeroCount > n) {
                if (road.charAt(left) == '0') {
                    zeroCount--;  // 왼쪽 포인터 이동 시 손상된 부분 감소
                }
                left++;  // 윈도우 축소
            }

            // 현재 윈도우 크기 갱신
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
