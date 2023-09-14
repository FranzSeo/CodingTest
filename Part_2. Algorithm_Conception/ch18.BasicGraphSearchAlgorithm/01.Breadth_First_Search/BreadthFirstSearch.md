## 너비 우선 탐색 (Bwreadth-First Search)

### 1. BFSSearch 와 DFSSearch 란?

<hr>

* **대표적인 그래프 탐색 알고리즘**
  * 너비 우선 탐색 (Breadth First Search) : 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
    * 비순환, 무방향 그래프
    * 같은 레벨의 Vertex (Node) 를 먼저 탐색
    * 한 단계씩 내려서, 해당 노드와 같은 레벨에 있는 노드들을 먼저 순회
    * 노드를 **Key**로 해당 노드의 연결된 노드를 **Value**로 표현하는 **HashMap**을 만들어 구현
    * 두 개의 큐를 사용하여 구현

  * 깊이 우선 탐색 (Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식
    * 비순환, 무방향 그래프 
    * 한 노드의 자식을 끝까지 순회한 후에, 다시 돌아와 다른 형제들의 자식을 타고 내려가며 순회
    * 한 개의 큐, 한 개의 스택을 사용하여 구현

<br>
  
![BFSSearch/DFSSearch.png](BFSDFS.png)

<br>
<br>

### 참고 : 해쉬맵

<hr>

1. HashMap<Integer, String> hashMap01 = new HashMap<Integer, String>();
   * Key / Value는 여러 Type 지원 -> ArrayList\<String\> 도 지원


2. HashMap<Integer, String> hashMap02 = new HashMap<Integer, String>(hashMap01);
   * 기존에 작성된 다른 HashMap 변수를 가지고 초기화 가능


3. HashMap<Integer, String> hashMap03 = new HashMap<Integer, String>(10);
   * 초기에 일정 크기를 넣어서 제한 할 수 있음


4. CRUD
   1. 생성/선언 (Create) : 
      * hashMap01.put(1, "data01");
      * hashMap01.put(2, "data02");
   2. 읽기 (Read) :
      * System.out.println(hashMap01);
      * System.out.println(hashMap01.get(1));
   3. 수정 (Update) :
      * hashMap01.put(2, "updated_data02");
   4. 삭제 (Delete) :
      * hashMap01.remove(2);


5. 시간 복잡도 : 
   * BFSSearch 시간 복잡도
     * 노드 수 : V
     * 간선 수 : E
     * 시간 복잡도 : O(V + E)