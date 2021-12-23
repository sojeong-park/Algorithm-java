# Queue & Stack
1. FIFO and LIFO에 대한 이해
2. Queue와 Stack 구현 방법
3. Queue를 통해 BFS 구현 방법 이해
4. Stack을 통해 DFS, recursion 구현 방법 이해

# Queue

- First In First Out
    - Enqueue: 새로운 데이터는 큐의 가장 끝 인덱스에 삽입
    - Dequeue: 0번째 인덱스에서 데이터 가져오기
  
- [선형큐 구현](/queueAndstack/Queue.java)
  - 동적 배열과 큐의 헤드를 가리키는 인덱스를 사용(인덱스 단위로 큐의 연산을 진행)
  - Drawback
    - 큐에 삽입,삭제(dequeue, enqueue) 반복 하다보면 head가 맨 마지막 인덱스를 가리키고, 앞에는 비어있지만 이를 꽉 찼다고 인식
    - 원형큐로 위의 문제 해결
  
- 원형큐 구현
  - [원형큐 구현_1](/queueAndstack/CircularQueue.java): front, rear 인덱스 포인터 구현
  - [원형규 구현_2](/queueAndstack/CircularQueue2.java): front 인덱스 포인터, 입력/추출시 count 개수로 rear 포인터 대체
  - 정적 배열에서 front와 rear 인덱스 값을 이용해 구현
  - (rear + 1) % size 를 하여 배열의 인덱스를 초과하지 않고 정적 배열을 순회 할 수 있도록 구현

- 큐 활용 문제
  - [leetCode 346](/queueAndstack/LeetCode346.java) (easy)
  
- 큐를 이용한 BFS 구현
  - [BFS 기본 구현](/BFS/Bfs.java)
  - [LeetCode286](/BFS/LeetCode286.java)
  - [LeetCode200](/BFS/LeetCode200.java)
  - [LeetCode752](/BFS/LeetCode752.java)
# Stack
- Last In First Out : 최신 데이터가 가장 먼저 나온다.
  - Push: 스택의 마지막에 새로운 요소 추가
  - Pop: 스택의 마지막 요소를 출력
  
- [스택 구현](/queueAndstack/MyStack.java)

- 스택 활용 문제
  - [LeetCode155](/queueAndstack/LeetCode155.java) : 스택의 기능(FIFO, push, pop)을 유지하면서 스택 내에서 가장 작은 값을 구해보자