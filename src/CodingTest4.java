import java.util.*;

public class CodingTest4 {

    // 전체 solution
    public static String[] solution(String[] goods) {
        List<String> result = new ArrayList<>();
        List<String> goodsList = Arrays.asList(goods);

        for (String word : goodsList) {
            List<String> unique = getShortestUniqueKeywords(word, goodsList);
            result.add(String.join(" ", unique));  // 문자열로 join
        }

        return result.toArray(new String[0]);
    }

    // 특정 상품의 고유 검색어 중 가장 짧은 것들을 반환
    public static List<String> getShortestUniqueKeywords(String word, List<String> goods) {
        // goods 중 현재 단어를 제외한 나머지를 set에 넣음
        Set<String> others = new HashSet<>(goods);
        others.remove(word);

        // 각 키의 서브스트링이 몇 번 등장했는지 저장하는 맵
        Map<String, Integer> substringCount = new HashMap<>();

        // 다른 상품들의 모든 부분 문자열을 카운트
        for (String other : others) {
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < other.length(); i++) {
                for (int j = i + 1; j <= other.length(); j++) {
                    String sub = other.substring(i, j);
                    if (seen.add(sub)) {
                        substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
                    }
                }
            }
        }

        // 현재 단어의 고유한 부분 문자열 수집 (Set으로 중복 제거)
        Set<String> uniqueCandidates = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String sub = word.substring(i, j);
                if (!substringCount.containsKey(sub)) {
                    uniqueCandidates.add(sub);
                }
            }
        }

        if (uniqueCandidates.isEmpty()) return List.of("None");

        // 정렬 후 가장 짧은 길이의 문자열만 필터링
        List<String> sorted = new ArrayList<>(uniqueCandidates);
        sorted.sort((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });
        int minLen = sorted.get(0).length();

        List<String> result = new ArrayList<>();
        for (String s : sorted) {
            if (s.length() > minLen) break;
            result.add(s);
        }

        return result;
    }

    // 테스트
    public static void main(String[] args) {
        String[] input1 = {"pencil", "cilicon", "contrabase", "picturelist"};
        String[] input2 = {"abcdeabcd", "cdabe", "abce", "bcdeab"};

        System.out.println(Arrays.toString(solution(input1)));
        System.out.println(Arrays.toString(solution(input2)));
    }
}
