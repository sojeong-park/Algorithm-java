package math;

public class LeetCode9 {
    /**
     * 숫자 팰린드롬인지 판별하라. int를 string으로 변환하지 말고 int로 판별
     * */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x %10;
            x /= 10;
        }
        return x == revert || x == revert / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
