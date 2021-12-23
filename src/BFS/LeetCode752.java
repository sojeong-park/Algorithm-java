package BFS;

import java.util.*;

public class LeetCode752 {
    /**
     * 4개의 숫자를 회전할 수 있는 자물쇠가 있고 숫자는 0 ~ 9까지 자유롭게 이동할 수 있다.
     * deadends 에 주어진 숫자와 마주하면 진행 불가
     * target 숫자까지 가는데 필요한 최소 회전 수를 반환하거나 불가능한 경우 -1을 반환하라
     *
     * ex) deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 유효한 시퀀스  "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"
     * 유효하지 않은 시퀀스 "0000" -> "0001" -> "0002" -> "0102" -> "0202"
     *
     * To solve a shortest path problem, we use a breadth-first search.
     * 1) Queue에 시작점인 "0000"과 간선임을 나타내는 "check" 값을 추가한다. deadends(진행불가능한 숫자), seen(방문한 숫자) -> set 자료구조에 담고 contains 메소드 활용해 체크
     * 2) Queue에가 null일때까지 반복한다.
     *    - 현재 값이 "check"일 경우 간선이므로 count의 개수를 1개 증가시키고, Queue에 "check" 값을 넣어 간선임을 나타낸다.
     *    - 1개의 숫자에서 다음 수로 나아갈 수 있는 숫자의 개수 최대 8개이고 이중 방문했던 적이 없는(seen에서 체크) 숫자를 큐에 넣는다.
     * */
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(); //진행 불가값 체크, String 배열보다는 set에 저장되어있는 것이 체크하기 간편하다.
        for (String str : deadends) dead.add(str);

        Set<String> seen = new HashSet<>(); // 방문한 숫자 저장
        seen.add("0000");

        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.offer("0000");
        queue.offer("check");// 다음 숫자로 나아가는 간선 체크하기 위해. 간선일경우 +1을 하여 최소 거리수 구함

        while (!queue.isEmpty()) {
            String value = queue.poll();
            if (value == "check") {
                count++;
                if (queue.peek() != null) {
                    queue.offer("check");
                }
            } else if (value.equals(target)){
                return count;
            } else if (!dead.contains(value)) {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d+=2) {
                        int y = ((value.charAt(i) - '0') + d + 10) % 10; //0에서 -1 할 경우 9가 되어야하고, 9에서 +1할 경우 0이 되도록 계산
                        String node = value.substring(0, i) + ("" + y) + value.substring(i+1); // 이어붙이기. 4자리숫자로 만들기
                        if (!seen.contains(node)){
                            seen.add(node);
                            queue.offer(node);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
