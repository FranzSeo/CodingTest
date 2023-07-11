## 깊이 우선 탐색 (Depth-First-Search) 

### 1. 깊이 우선 탐색 (Depth First Search) DFS 란? 

BreadthFirstSearch.md 참조해서 볼것!!!

* 깊이 우선 탐색 (Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식
    * 비순환, 무방향 그래프
    * 한 노드의 자식을 끝까지 순회한 후에, 다시 돌아와 다른 형제들의 자식을 타고 내려가며 순회
    * 한 개의 큐, 한 개의 스택을 사용하여 구현

***

### 2.시간 복잡도 :
  * DFSSearch 시간 복잡도
    * 노드 수 : V
    * 간선 수 : E
    * 시간 복잡도 : O(V + E)