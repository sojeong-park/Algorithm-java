package arraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode253 {
    /**
     * sort, priorityQueue 활용
     * 1. 시작시간 기준으로 정렬
     * 2. min-heap 초기화하고 첫 미팅이 끝나는 시간을 힙에 추가
     *  -> 회의실이 비워지는 시간인 끝나는 시간만 추적하면 됨
     * 3. 힙 맨 위에 있는 방이 비어있는지 확인한다.
     *  3-1.방이 비어있는 경우 최상위 요소 추출하고 현재 회의의 종료시간과 함께 다시 추가한다.
     *  3-2. 방이 차있는 경우 새 방을 할당하고 힙에 추가한다.
     * 4. 위의 과정이 끝난 이후 힙의 size는 최소한으로 필요한 회의실 방의 개수이다.
     *
     * 시간복잡도 : O(N log N)
     * - Arrays.sort 수행시간은 최악의 경우 O(N log N) 이며 데이터가 어느정도 정렬이 되어있는 경우 O(N) 이다.
     * - Priority Heap 의 경우 add(입력)의 경우 O(lon g) 이고 peek(조회)의 경우 O(1) 이다.
     * -> 두가지 경우 모두 합해 시간복잡도는 O(N log N) 이다.
     *
     * 공간복잡도: O(N)
     * - priority heap 에 최악의 경우 N개 데이터가 저장될 공간이 필요하므로 O(N) 이다.
     * */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(
                intervals.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                }
        );

        // 시작시간을 기준으로 정렬
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                }
        );

        // 최소힙에 첫번째 미팅의 끝나는 시간 입력
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // i번째 미팅 시작시간과 이전 미팅의 끝나는 시간 비교
            System.out.println(allocator.peek());
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static void main(String[] args) {
        minMeetingRooms(new int[][]{{1, 10}, {2,7}, {3,19}, {8,12}, {10,20}, {11,30}});
    }
}
