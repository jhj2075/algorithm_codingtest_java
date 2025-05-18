import java.util.*;

public class CodingTest1 {
    // s1, s2로 표현된 연속된 자연수 n, n+1 찾기
    public static int[] solution(String s1, String s2) {
        List<int[]> list = new ArrayList<>();

        // 탐색 범위는 적절히 조정 가능 (예제 기준 100000까지)
        for (int i = 1; i <= 100_000; i++) {
            String a = intToFreqString(i);
            String b = intToFreqString(i + 1);

            if ((a.equals(s1) && b.equals(s2)) || // 여기까지만 쓰고 돌리고 밑 줄은 나중에 추가
                    (a.equals(s2) && b.equals(s1))) {
                list.add(new int[]{i, i + 1});
            }
        }

        // 여러 후보 중 가장 작은 쌍 반환
        list.sort(Comparator.comparingInt(a -> a[0]));
        return list.get(0);
    }

    // 숫자 -> 빈도 표현 문자열로 변환
    public static String intToFreqString(int num) {
        int[] freq = new int[10];
        char[] chars = String.valueOf(num).toCharArray();

        for (char c : chars) {
            freq[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (freq[i] > 0) {
                sb.append(i).append(freq[i]);
            }
        }
        return sb.toString();
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("21", "31")));       // [2, 3]
        System.out.println(Arrays.toString(solution("1103", "1202")));   // [1000, 1001]
        System.out.println(Arrays.toString(solution("94", "1104")));     // [9999, 10000]
        System.out.println(Arrays.toString(solution("92817101", "81711102"))); // [78099, 78100]
    }
}
//
//import java.util.*;
//
//public class CodingTest1 {
//    // s1, s2로 표현된 연속된 자연수 n, n+1 찾기
//    public static int[] solution(String s1, String s2) {
//        List<int[]> list = new ArrayList<>();
//
//        for (int i = 1; i <= 100_000; i++) {
//            // intToFreqString(i)
//            int[] freqA = new int[10];
//            for (char c : String.valueOf(i).toCharArray()) {
//                freqA[c - '0']++;
//            }
//            StringBuilder sbA = new StringBuilder();
//            for (int d = 9; d >= 0; d--) {
//                if (freqA[d] > 0) {
//                    sbA.append(d).append(freqA[d]);
//                }
//            }
//            String a = sbA.toString();
//
//            // intToFreqString(i + 1)
//            int[] freqB = new int[10];
//            for (char c : String.valueOf(i + 1).toCharArray()) {
//                freqB[c - '0']++;
//            }
//            StringBuilder sbB = new StringBuilder();
//            for (int d = 9; d >= 0; d--) {
//                if (freqB[d] > 0) {
//                    sbB.append(d).append(freqB[d]);
//                }
//            }
//            String b = sbB.toString();
//
//            if ((a.equals(s1) && b.equals(s2)) || (a.equals(s2) && b.equals(s1))) {
//                list.add(new int[]{i, i + 1});
//            }
//        }
//
//        list.sort(Comparator.comparingInt(a -> a[0]));
//        return list.get(0);
//    }
//
//    // 테스트
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution("21", "31")));       // [2, 3]
//        System.out.println(Arrays.toString(solution("1103", "1202")));   // [1000, 1001]
//        System.out.println(Arrays.toString(solution("94", "1104")));     // [9999, 10000]
//        System.out.println(Arrays.toString(solution("92817101", "81711102"))); // [78099, 78100]
//    }
//}
