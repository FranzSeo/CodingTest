## 탐욕 알고리즘 (Greedy Algorithm)

### 1. 탐욕 알고리즘 (Greedy Algorithm) 이란?

* 최적의 해에 가까운 값을 구하기 위해 사용 됨
* 여러 경우 중 하나를 결정해야할 때 마다, **매순간 최적이라고 생각되는 경우를 선택** 하는 방식으로 진행하여, 최정적인 값을 구하는 방식

### 2. 탐욕 알고리즘의 예

* 문제 1 : 동전 문제
    * 지불 해야하는 값이 n원 일 때 동전의 수가 가장 적게 지불하시오.
        * 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
        * 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 10));
        obj.coinCount(1230, coinList);
    }

    public void coinCount(int price, ArrayList<Integer> coinList) {

        int totalCoinCount = 0;
        int coinNum = 0;
        ArrayList<Integer> dataList = new ArrayList<Integer>();

        for (int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            dataList.add(coinNum);
            System.out.println(coinList.get(i) + "원 : " + coinNum + "개");
        }
        System.out.println("총 동전 개수 : " + totalCoinCount);
    }
}
```

* 문제 2 : 부분 배낭 문제 ( Fractional Knapsack Problem )
    * 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
        * 각 물건은 무게 (w) 와 가치 (v) 로 표현 됨
        * 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음
            * Fractional Knapsack Problem : 쪼갤 수 있음
            * 0/1 Knapsack Problem : 쪼갤 수 없음

| 물건(i)  | 물건 1 | 물건 2 | 물건 3 | 물건 4 | 물건 5 |
|--------|------|------|------|------|------|
| 무게 (w) | 10   | 15   | 20   | 25   | 30   |
| 가치 (v) | 10   | 12   | 10   | 8    | 5    |

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] objList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        obj.knapsack(objList, 48);
    }

    public void knapsack(int[][] dataList, double capacity) {
        double totalValue = 0.0;
        // 해당 물건을 넣지 못하는 경우
        double fraction = 0.0;

        Arrays.sort(dataList, new Comparator<int[]>() {
            @Override
            public int compare(int[] objItem01, int[] objItem02) {
                // 가치 : objItem02[1] / 무게 : objItem02[0]
                return (objItem02[1] / objItem02[0]) - (objItem01[1] / objItem01[0]);
            }
        });
        for (int i = 0; i < dataList.length; i++) {
            if (capacity - (double) dataList[i][0] > 0) {
                capacity -= (double) dataList[i][0];
                totalValue += (double) dataList[i][1];
                System.out.println("무게 : " + dataList[i][0] + ", 가치 : " + dataList[i][1]);
            } else {
                fraction = capacity / (double) dataList[i][0];
                totalValue += (double) dataList[i][1] * fraction;
                System.out.println("무게 : " + dataList[i][0] + ", 가치 : " + dataList[i][1] + ", 비율 : " + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }
}
```

***

### 자바의 정렬 기준

* Comparable 과 Comparator 인터페이스
    * Comparable 인터페이스 compareTo() 메서드를 Override 해서 구현
        * 일반적으로 정렬할 객체에 implements 로 Comparable 인터페이스를 추가하여 구현
    * Comparator 인터페이스는 compare9) 메서드를 Override 해서 구현
        * 일반적으로 별도 클래스를 정의해서 구현하며, 동일 객체에 다양한 정렬 기준을 가진 클래스를 작성
    * Comparable 인터페이스가 정의되어 있어도 Comparator 클래스 기준으로 정렬이 됨

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1차원 정렬
        Integer[] iArray = new Integer[]{1, 8, 9, 5, 3, 2};
        Arrays.sort(iArray);
        System.out.println(Arrays.toString(iArray));
    }
}
```

***

* Comparable 구현

```java
public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }
}
```

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Edge edge01 = new Edge(10, "A");
        Edge edge02 = new Edge(8, "A");
        Edge edge03 = new Edge(15, "A");

        Edge[] edges = new Edge[]{edge01, edge02, edge03};
        // 다차원 정렬 출력
        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i].distance);
        }
    }
}
```

* Comparator 구현

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Edge edge01 = new Edge(10, "A");
        Edge edge02 = new Edge(8, "A");
        Edge edge03 = new Edge(15, "A");

        Edge[] edges = new Edge[]{edge01, edge02, edge03};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge objItem01, Edge objItem02) {
                return objItem01.distance - objItem02.distance;
            }
        });
        // 다차원 정렬 출력
        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i].distance);
        }
    }
}
```

***
