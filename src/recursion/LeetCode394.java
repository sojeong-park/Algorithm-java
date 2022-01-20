package recursion;

public class LeetCode394 {
    /**
     * 시간복잡도: O(N) - s.length만큼 걸린다.
     * 풀이
     * 1. s 문자열을 끝까지 순회한다. 아래의 로직을 문자열이 끝날때까지 반복
     *  - 숫자를 만난경우 int 변수에 저장한다.
     *  - [ : index를 1개 증가, 재귀실행
     *  - 문자: StringBuffer에 append
     *  - ] : break
     *
     * */
    private static int index = 0;
    public static String decodeString(String s) {
        StringBuffer resultString = new StringBuffer();
        int repeat = 0;
        while (index < s.length()) {
            char c = s.charAt(index);

            if (c == '[') {
                index++;
                String substr = decodeString(s);
                for (int i = 0; i < repeat; i++) {
                    resultString.append(substr);
                }
                repeat = 0;
            } else if (c >= '0' && c <= '9') {
                repeat = repeat * 10 + (c - '0');
            } else if (c == ']') {
                break;
            } else {
                resultString.append(c);
            }
            index++;
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[b]]"));

    }
}
