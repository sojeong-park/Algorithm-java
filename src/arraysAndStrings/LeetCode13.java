package arraysAndStrings;

import java.util.HashMap;

public class LeetCode13 {
    /**
     * 로마문자열로 넘어오는 값을 숫자로 변환하는 문제
     *  풀이1. Hash table에 저장하여 숫자 판별
     *  예외) 빼기가 사용되는 경우 6가지
     *      - 4는 IV, 9는 IX: V 와 X앞에 I가 있으면 -1
     *      - L and C 앞에 X가 있으면 -10
     *      - D and M 앞에 C가 있으면 -100
     *  힌트! 문자열을 앞에서 뒤로만 탐색하려하지 말고 뒤에서 앞으로 시도해보자.
     *  투포인터로 문자열 2개를 읽는것보다 이전 문자열의 값을 가지고 있는것이 더 쉽다.
     *  시간복잡도: O(N) - s.length 실행, 공간복잡도 O(1) - hash table에 저장되는 로마문자열과 숫자는 상수값임
     */

    private static HashMap<String, Integer> map = new HashMap<>();

    static
    {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    };

    public static int romanToInt(String s) {
        String lastSymbol = s.substring(s.length()-1);
        int lastValue = map.get(lastSymbol);
        int sum = lastValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = map.get(currentSymbol);
            if (currentValue < lastValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
            lastValue = currentValue;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
