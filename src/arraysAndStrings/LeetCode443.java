package arraysAndStrings;

public class LeetCode443 {
    /**
     * Map 이용할 수 없는 이유: 연속된 문자열을 압축하는 것이기 때문에 연속되게 문자열이 나왔는지 판별하는 코드가 필요하다.
     * 투포인터를 활용해 체크하고 chars 배열 이외의 공간에 저장하지 않는다.
     * */
    public static int compress(char[] chars) {
        int indexAns = 0, index = 0;

        while (index < chars.length) {
            char currChar = chars[index];

            int count = 0;
            while(index < chars.length && chars[index] == currChar) {
                index++;
                count++;
            }

            chars[indexAns++] = currChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }

    public static void main(String[] args) {
        compress(new char[]{'a','a','b','b','c','c','c'});
        compress(new char[]{'a'});
        compress(new char[]{});
        compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
    }
}
