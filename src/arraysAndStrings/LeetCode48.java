package arraysAndStrings;

public class LeetCode48 {
    /**
     * Rotate Image : 90도 회전하기
     * - 2차원 배열을 한번에 90도 회전하는것보다 나눠서 회전하면 더 쉽다.
     *
     * 기존이미지    대각선 기준 변경   중앙 축 기준 변경 (90도 회전한 모습, 정답)
     * 1 2 3        1 4 7            7 4 1
     * 4 5 6        2 5 8            8 5 2
     * 7 8 9        3 6 9            9 6 3
     * */

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    // 대각선 기준 변경
    public static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    // 중앙 축 기준 변경
    public static void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
