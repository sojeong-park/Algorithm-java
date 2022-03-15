package DFS;

import java.util.*;

public class LeetCode332 {
    static HashMap<String, List<String>> flightMap = new HashMap<>();
    static HashMap<String, boolean[]> visitMap = new HashMap<>();
    static int flights = 0;
    static List<String> result = null;

    /**
     * 1. 주어진 목적지들을 그래프로 구성한다.
     * 2. 어휘순 방문이 필요하므로 정렬을 한다.
     * 3. DFS로 탐색한다.
     * */
    public static List<String> findItinerary(List<List<String>> tickets) {
        // 1) 주어진 목적지들을 그래프로 구성한다.
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (flightMap.containsKey(origin)) {
                List<String> destList = flightMap.get(origin);
                destList.add(dest);
            } else {
                List<String> destList = new LinkedList<String>();
                destList.add(dest);
                flightMap.put(origin, destList);
            }
        }

        //2) 목적지들을 정렬하고 방문체크하는 visitMap 을 초기화 한다.
        for (Map.Entry<String, List<String>> entry : flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            System.out.println(entry.getKey() + ", "+ entry.getValue());
            visitMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        flights = tickets.size();
        LinkedList<String> route = new LinkedList<String>();
        route.add("JFK"); // 시작점 추가

        //3) DFS로 탐색한다.
        dfs("JFK", route);
        return result;
    }

    public static boolean dfs(String start, LinkedList<String> route) {
        if (route.size() == flights + 1) {
            result = (List<String>) route.clone();
            return true;
        }
        if (!flightMap.containsKey(start))
            return false;
        
        List<String> destinations = flightMap.get(start);
        for (int i = 0; i < destinations.size(); i++) {
            boolean[] visited = visitMap.get(start);
            if (visited[i] == false) { // 방문하지 않은 경우
                visited[i] = true;
                boolean ret = route.add(destinations.get(i));
                dfs(destinations.get(i), route);
                route.pollLast();
                visited[i] = false;

                if (ret)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("JFK","SFO")));
        list.add(new ArrayList<>(Arrays.asList("JFK","ATL")));
        list.add(new ArrayList<>(Arrays.asList("SFO","ATL")));
        list.add(new ArrayList<>(Arrays.asList("ATL","JFK")));
        list.add(new ArrayList<>(Arrays.asList("ATL","SFO")));
//        list.add(new ArrayList<>(Arrays.asList("MUC","LHR")));
//        list.add(new ArrayList<>(Arrays.asList("JFK","MUC")));
//        list.add(new ArrayList<>(Arrays.asList("SFO","SJC")));
//        list.add(new ArrayList<>(Arrays.asList("LHR","SFO")));

        System.out.println(findItinerary(list));
    }
}
