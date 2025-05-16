import java.util.*;

public class CodingTest1 {

    public static int[] solve(long s1, long s2) {
        // 1. 자기 기술 수를 빈도 배열로 변환
        int[] freq1 = parse(s1);
        int[] freq2 = parse(s2);

        // 2. 가능한 수 집합 생성
        Set<Integer> s1Set = generateNumbers(freq1);
        Set<Integer> s2Set = generateNumbers(freq2);

        // 3. 조건에 맞는 수 탐색
        List<Integer> answerList = new ArrayList<>();
        for (int num : s2Set) {
            if (s1Set.contains(num - 1)) {
                answerList.add(num);
            }
        }

        // 4. 결과 변환
        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    // 자기 기술 수 파싱 (ex. 1201 -> 1이 2개, 0이 1개)
    private static int[] parse(long s) {
        String str = Long.toString(s);
        int[] freq = new int[10];
        for (int i = 0; i < str.length(); i += 2) {
            int digit = str.charAt(i) - '0';
            int count = str.charAt(i + 1) - '0';
            freq[digit] = count;
        }
        return freq;
    }

    // 주어진 freq 배열을 기반으로 만들 수 있는 모든 숫자 순열
    private static Set<Integer> generateNumbers(int[] freq) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < freq[i]; j++) {
                digits.add(i);
            }
        }
        Set<Integer> results = new HashSet<>();
        permute(digits, 0, results);
        return results;
    }

    // 숫자 순열 생성 (중복 제거 포함)
    private static void permute(List<Integer> arr, int depth, Set<Integer> results) {
        if (depth == arr.size()) {
            if (arr.get(0) != 0) {  // 0으로 시작하는 숫자 제외
                int num = 0;
                for (int d : arr) {
                    num = num * 10 + d;
                }
                results.add(num);
            }
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = depth; i < arr.size(); i++) {
            if (used.contains(arr.get(i))) continue;
            used.add(arr.get(i));

            Collections.swap(arr, depth, i);
            permute(arr, depth + 1, results);
            Collections.swap(arr, depth, i);
        }
    }

    // 테스트 예시
    public static void main(String[] args) {
        long s1 = 211202;
        long s2 = 51211101;

        int[] answer = solve(s1, s2);
        System.out.println("Answer: " + Arrays.toString(answer));  // [102]
    }
}
