package Kakao;

import java.util.*;


public class Solution_주차요금계산 {
    public static int[] solution(int[] fees, String[] records) {
        Map<Integer, List<String>> mapList = new TreeMap<>();

        //records 배열을 순회하면서 차량 번호당 입차,출차를 모은다.
        for (String record : records) {
           String[] data = record.split(" ");
           int carNumber = Integer.parseInt(data[1]);
           if (mapList.containsKey(carNumber)) {
               mapList.get(carNumber).add(data[0]);
           } else {
               mapList.put(carNumber, new ArrayList<>(Arrays.asList(data[0])));
           }
        }

        //위에서 모은 리스트를 순회하면서 out이 없는경우 23:59분으로 계산하고 주차요금을 계산한다.
        for (int key : mapList.keySet()) {
            List<String> times = mapList.get(key);
            int i = 0;
            int sum = 0;
            while (i < times.size()) {
                int calcTime = 0;
                int inTime = calcTime(times.get(i));
                if (i+1 < times.size()) {
                    calcTime = calcTime(times.get(i+1)) - inTime;
                } else {
                    calcTime = 1439 - inTime;
                }

                sum += calcTime; // 누적시간 구하기
                i += 2;
            }
            int totalSum = 0;
            if (sum <= fees[0]) {
                totalSum += fees[1];
            } else {
                totalSum += Math.ceil((sum - fees[0])/(double)fees[2]) * fees[3] + fees[1];
            }
            mapList.put(key, new ArrayList<>(Arrays.asList(Long.toString(totalSum))));
        }


        int[] answer = new int[mapList.size()];
        int i = 0;

        for (int key : mapList.keySet()) {
            answer[i++] = Integer.parseInt(mapList.get(key).get(0));
        }

        return answer;
    }

    public static int[] solution2(int[] fees, String[] records) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> result = new TreeMap<>();

        // 주차기록 계산하기
        for (String data : records) {
            String[] datas = data.split(" ");
            int carNumber = Integer.parseInt(datas[1]);
            int nowTime = calcTime(datas[0]);
            if (datas[2].equals("OUT")) {
                int inTime = map.get(carNumber);
                int useTime = nowTime - inTime;
                if (result.containsKey(carNumber)) {
                    useTime += result.get(carNumber);
                }
                result.put(carNumber, useTime);
                map.remove(carNumber);
                continue;
            }
            map.put(carNumber, nowTime);
        }

        // 나가지 않은 차량 처리
        for (int carNum : map.keySet()) {
            int inTime = map.get(carNum);
            int calcTime = 1439 - inTime;
            if (result.containsKey(carNum)) {
                result.put(carNum, result.get(carNum) + calcTime);
            } else {
                result.put(carNum, calcTime);
            }
        }
        System.out.println(result);

        int[] ans = new int[result.size()];
        int i = 0;
        // 주차시간 계산해 출력하기
        for (int key : result.keySet()) {
            int time = result.get(key);

            if (time <= fees[0]) {
                time = fees[1];
            } else {
                time = fees[1] + (int)Math.ceil((time - fees[0])/(double)fees[2]) * fees[3];
            }
            ans[i++] = time;
        }
        return ans;
    }

    public static int calcTime (String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int min = Integer.parseInt(tmp[1]);
        return hour + min;
    }
    public static void main(String[] args) {
        solution(new int[]{180, 5000, 10, 600}
        ,new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        solution2(new int[]{1, 461, 1, 10}
                ,new String[]{"00:00 1234 IN"});
    }
}
