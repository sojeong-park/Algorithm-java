package arraysAndStrings;

import java.util.*;

public class LeetCode1249 {
    /**
     * stack을 활용해 쌍이 맞지 않는 괄호가 있는 인덱스 번호 set에 추가
     * 주어진 문자열을 순회하면서 set에 들어가 있지 않은 인덱스의 문자만 추가
     * 시간복잡도: O(N) -> N은 s.length
     * 공간복잡도: O(N) -> N은 s.length
     * */
    public static String minRemoveToMakeValid(String s) {
        Set<Integer> indexesRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')'){
                if (stack.isEmpty()) {
                    indexesRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) indexesRemove.add(stack.pop());
        for (int i = 0; i < s.length(); i++) {
            if (!indexesRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        minRemoveToMakeValid("lee(t(c)o)de)");
    }
}
