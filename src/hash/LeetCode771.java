package hash;

import java.util.*;

public class LeetCode771 {
    /**
     * 1. hashmap 풀이
     * 시간복잡도: O(jewels.length + stones.length)
     * 공간복잡도: O(jewels.length)
     * */
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : jewels.toCharArray()) {
            map.put(c, 0);
        }

        for (char stone : stones.toCharArray()) {
            if (map.containsKey(stone)) {
                map.put(stone, map.get(stone)+1);
            }
        }

        int sum = 0;
        for (int cnt : map.values()) {
            sum += cnt;
        }
        System.out.println(sum);
        return sum;
    }

    /**
     * 2. hashset 풀이
     * 시간복잡도: O(jewels.length + stones.length)
     * 공간복잡도: O(jewels.length)
     * */
    public static int numJewelsInStones2(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int sum = 0;
        for (char stone: stones.toCharArray()) {
            if (set.contains(stone)) {
                sum += 1;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        numJewelsInStones2("aAA", "aAAbbbbb");

    }
}
