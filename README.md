# Algorithms

Solving algorithm problems with java language.

# Contents
1. [String](#String)
2. [Array](#Array)
3. [LinkedList](#LinkedList)
4. [DP](#DP)
5. Binary Search

# String
1. Sliding window
   - [LeetCode_3](/src/arraysAndStrings/LeetCode3.java)
   - [LeetCode_5](/src/arraysAndStrings/LeetCode5.java)
   - [LeetCode_11](/src/arraysAndStrings/LeetCode11.java)
   - [LeetCode_42](/src/arraysAndStrings/LeetCode42.java)
   
2. Stable Sorting
   - [LeetCode_937](/src/arraysAndStrings/LeetCode937.java)

3. for loop
   - [LeetCode_929](/src/arraysAndStrings/LeetCode929.java)
   - [LeetCode_66](/src/arraysAndStrings/LeetCode66.java)
   - [LeetCode696](/src/arraysAndStrings/LeetCode696.java): two pointer 풀이도 가능
   - [LeetCode13](/src/arraysAndStrings/LeetCode13.java)
    
# Array
   1. Matrix rotation
      - [LeetCode_48](/src/arraysAndStrings/LeetCode48.java)
   2. 구현
      - [LeetCode_163](/src/arraysAndStrings/LeetCode163.java)
      - [LeetCode_215](/src/arraysAndStrings/LeetCode215.java)

# LinkedList
   - [LRU cache(LeetCode146)](/src/linkedList/LeetCode146.java)

# DP
   - [LeetCode_55](/src/arraysAndStrings/LeetCode55.java)

# Recursion
   - [백준 N과 M (1)](/src/recursion/n과m1.java)

# Binary Search
   - [LeetCode4](/src/arraysAndStrings/LeetCode4.java):
   - [LeetCode704](/src/arraysAndStrings/LeetCode704.java)

# Graph 탐색
  1. 그래프 구현하기
     - [인접행렬](src/DFS/AdjacencyMatrix.java)
     - [인접리스트](src/DFS/AdjacencyList.java)
       
       |    |특징|공간복잡도|
       |------|---|---|
       |인접 행렬|간선이 많이 존재하는 밀집 그래프<br> 인접 노드를 찾기 위해선 모든 노드를 순회<br>V개의 노드 표현위해 V^2만큼의 공간 필요|O(v^2)|
       |인접 리스트|간선이 적게 존재하는 희소 그래프<br> 인접 노드를 쉽게 찾을 수 있음<br>V개의 리스트에 간선(E) 만큼 원소가 들어있음|O(V+E)|

  2. DFS, BFS 구현하기
     - [DFS 풀이](/src/DFS/Dfs.java)
     - [BFS 풀이](/src/BFS/Bfs.java)
  3. DFS, BFS 활용하기
     - [연결요소의개수](/src/DFS/Solution_11724.java): 연결된 그래프의 개수 count
    