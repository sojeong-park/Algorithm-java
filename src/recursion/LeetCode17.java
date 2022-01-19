package recursion;

import java.util.*;

public class LeetCode17 {
    public static final String[] datas = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        combination("", digits, 0, result);
        return result;
    }

    /**
     * 재귀 구현
     * */
    public void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = datas[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset+1, result);
        }
    }

    /**
     * 반복문 구현
     * */
    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> ret = new LinkedList<String>();
        if (digits.isEmpty()) return ret;
        ret.add("");
        while (ret.peek().length() != digits.length()) {
            String remove = ret.remove();
            String letters = datas[digits.charAt(remove.length()) -'0'];
            for (char c : letters.toCharArray()) {
                ret.addLast(remove+c);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        letterCombinations2("23");
    }
}
