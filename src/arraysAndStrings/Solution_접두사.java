package arraysAndStrings;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1141
 * 접두사
 * */
public class Solution_접두사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);
        Set<String> ans = new HashSet<>();

        for (int i = 0; i < words.length; i++){
            boolean flag = true;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() > words[j].length()) break;
                String tmp = words[j].substring(0, words[i].length());
                if (tmp.equals(words[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(words[i]);
            }
        }
        System.out.println(ans.size());
    }
}
