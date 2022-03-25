package Kakao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Programers1 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winNumsSet = new HashSet<>();
        int[] rank = {6, 6, 5, 4, 3, 2};

        int zeroCnt = 0, hasNums = 0;

        for (int num : win_nums) {
            winNumsSet.add(num);
        }

        for (int lotto : lottos) {
            if (lotto == 0) zeroCnt++;
            if (winNumsSet.contains(lotto)) hasNums++;
        }

        return new int[]{rank[zeroCnt + hasNums], rank[hasNums]};
    }

    public static void main(String[] args) {
        solution(new int[]{7, 1, 2, 23, 24, 25}, new int[]{20, 9, 3, 45, 4, 35});
    }
}
