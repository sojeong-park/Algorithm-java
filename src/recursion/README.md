# Recursion

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