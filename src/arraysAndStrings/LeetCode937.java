package arraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode937 {
    /**
     * 첫번째 문자는 식별자
     * 문자열 로그: 영문 소문자로 구성
     * 숫자 로그: 숫자로 구성
     * 재정렬 기준
     *  1. 문자열 로그는 숫자 로그보다 항상 앞에 온다.
     *  2. 문자열 로그는 사전순으로 정렬되며 동일할 경우 식별자순으로 정렬된다.
     *  3. 숫자 로그는 상대적 순서를 따른다 -> 입력순서대로 나온다.
     * */
    public static void main(String[] args) {
        String[] str = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] test = reorderLogFiles(str);
        for (String t : test) {
            System.out.println(t);
        }
    }
    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // 두번째 문자열까지만 정렬하는데 필요하므로 limit 2로 둔다
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }

                if (!isDigit1 && isDigit2)
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    return 0;
            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }
}
