package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1507 {
    /**
     * String 관련 문제는 StringBuilder를 사용하는게 시간단축에 좋다
     * */
    private static Map<String, String> month = new HashMap<>();
    static {
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
    }

    public static String reformatDate(String date) {
        String[] dates = date.split(" ");
        String day = dates[0].replaceAll("[a-zA-Z]*$", "");
        if (day.length() == 1) {
            day = "0" + day;
        }
        return dates[2] + "-" + month.get(dates[1]) + "-"+ day;
    }

    public static String reformatDate2(String date) {
        String[] dates = date.split(" ");
        String day = dates[0].replaceAll("[a-zA-Z]*$", "");
        if (day.length() == 1) {
            day = "0" + day;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dates[2]).append("-");
        sb.append(month.get(dates[1])).append("-");
        sb.append(day);
        return sb.toString();
    }

    /**
     * 정규식보다 쉬운 풀이
     * 정규식 풀이는 평균 5ms시간이 걸린다면 이 풀이는 1ms 시간이 소요됨.
     * */
    public static String reformatDate3(String date) {
        String[] strs = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(strs[2]).append("-");
        sb.append(month.get(strs[1])).append("-");

        String day = "";
        if (strs[0].length() == 3) {
            day = strs[0].substring(0, 1);
            sb.append(0).append(day);
        } else {
            day = strs[0].substring(0, 2);
            sb.append(day);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reformatDate("5th Jan 2052"));
        System.out.println(reformatDate("5th Jan 2052"));
    }
}
