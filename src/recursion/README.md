# Recursion

### 조합
[LeetCode 17번 풀이](/recursion/LeetCode17.java)
- 모든 경우의 조합 구하기
- 재귀로 구현할 경우 아래와 같은 순서로 진행된다.
```
combination(“”, “23”, 0, result)
letters = “abc”;
	prefix = “”
	combination(“a”, “23”, 1, ())
		prefix = “a”
		letters = “def”;
			combination(“ad”, “23”, 2, ());
				offset(2) >= digits.length(2): result.add, return
			combination(“ae, “23”, 2, (ad));
				offset(2) >= digits.length(2); result.add, return
			combination(“af”, “23”, 2, (ad, ae))
				offset(2) >= digits.length(2); result.add, return
	combination(“b”, “23”, 1, (ad,ae,af))
		prefix = “b”
		letters = “def”
			combination(“bd”, “23”, 2, (ad,ae,af));
				offset(2) >= digits.length(2): result.add, return
			combination(“be”, “23”, 2, (ad,ae,af, bd));
				offset(2) >= digits.length(2): result.add, return
			combination(“bf”, “23”, 2, (ad,ae,af, bd, be));
				offset(2) >= digits.length(2): result.add, return
	combination(“c”, “23”, 1, (ad,ae,af, bd, be, bf))
		prefix = “c”
		letters = “def”
			combination(“cd”, “23”, 2, (ad,ae,af));
				offset(2) >= digits.length(2): result.add, return
			combination(“ce”, “23”, 2, (ad,ae,af, bd, cd));
				offset(2) >= digits.length(2): result.add, return
			combination(“cf”, “23”, 2, (ad,ae,af, bd,, bf, cd, ce));
				offset(2) >= digits.length(2): result.add(cf), return
```

- 소스코드 설명

```java
    String letters = datas[digits.charAt(offset) - '0'];
```
- 문자열을 charAt()으로 추출하면 char type(문자)으로 추출되며 아스키 코드값으로 나온다.
- 아스키 코드는 숫자와 문자를 매핑하는 테이블이고, 컴퓨터는 문자를 기억 할 수 없으므로 숫자 번호에 문자를 연결하여 기억한다.
    - ex) 문자'0'의 아스키 코드는 48, 문자'9'의 아스키코드는 57
- 따라서 위의 코드와 같이 문자 '0'을 뺴주면 char에서 int로 변환된것과 동일한 결과가 나온다.
    - '0'(48) - '0'(48) = 0
  

### 순열
[LeetCode46](/recursion/LeetCode46.java)

- 순열은 모든 가능한 경우를 그래프 형태로 나열한 결과
- recursion 활용하며 dfs 혹은 Collections.swap 두가지 방식으로 구현 가능
