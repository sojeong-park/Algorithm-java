package Kakao;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 * 문제 제목: 신규 아이디 추천
 * 난이도: Level1
 * 유형: String 조작, 정규식을 어느정도 알고있어야 쉽게 풀 수 있다.
 * 시간복잡도: O(N)
 * 공간복잡도: O(str.length)
 * */
public class Solution1 {
    public static void main(String[] args) {
        solution("...!@BaT#*..y.abcdefghijklm");
        solution("z-+.^.");
        solution("=.=");
        solution("123_.def");
        solution("abcdefghijklmn.p");
    }

    public static String solution(String new_id) {
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
        String str = new_id.toLowerCase();

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다. -> 정규식 활용
        String rex = "[^a-z0-9._-]";
        str = str.replaceAll(rex, "");

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다. -> 정규식 활용
        str = str.replaceAll("[.]{2,}", ".");

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다. -> 정규식 활용
        str = str.replaceAll("^[.]|[.]$", "");

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (str.length() == 0) str += "a";

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if (str.length() >= 16)
           str = str.substring(0, 15);

        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (str.charAt(str.length()-1) == '.')
            str = str.substring(0, str.length()-1);

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (str.length() <= 2) {
            while(str.length() < 3) {
                str += str.charAt(str.length() - 1);
            }
        }
        System.out.println(str);
        return str;
    }
}
