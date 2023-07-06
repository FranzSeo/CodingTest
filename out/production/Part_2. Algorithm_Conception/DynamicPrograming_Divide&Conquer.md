## 동적 계획법 (Dynamic Programing)과 분할 정복(Divide and Conquer)

<hr>

1. 정의
    * 동적 계획법 (DP : Dynamic Programing)
        * 하나의 큰 문제를 해결하기 위해, 큰 문제를 작은 문제들로 나누어 부분적으로 해결한 후 파생된 값인 해를 이용하여 최종적으로 전체 문제를 해결하는 알고리즘
        * 상향식 접근법 : 가장 최하위 문제의 답을 구해서 상위 문제를 풀어나가는 방식
        * 메모이제이션(Memoization) : 프로그램 실행 시 이전에 계산한 값을 저장하여, 다시 계산하지 않도록 하여 전체 실행 속도를 빠르게 하는것
        * 문제를 잘게 쪼갤 때, 부분 문제는 중복되어, 재활용함
            * ex) 피보나치 수열

      <br>

    * 분할 정복(Divide and Conquer)
        * 문제를 나눌 수 없을 때까지 나누어 각각의 문제를 풀어서 다시 합병하여 문제의 답을 얻는 알고리즘
        * 하양식 접근법 : 상위의 해답을 구하기 위해, 아래로 내려가면서 하위의 해답을 구하는 방식
            * 재귀함수로 구현
        * 문제를 잘게 쪼갤 때, 부분 문제는 서로 중복되지 않음
            * ex) 병합 정렬, 퀵 정렬 ...

<br>

2. 공통점과 차이점
    * 공통점
        * 큰문제를 잘게 쪼개서, 가장 작은 단위로 분할
    * 차이점
        * 동적 계획법
            * 부분 문제는 중복되어, 상위 문제 해결 시 재사용
            * Memoization 기법 사용 (부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용)
        * 분할 정복
            * 부분 문제는 서로 중복되지 않음
            * Memoization 기법을 사용하지 않음

<br>

3. 동적 계획법 알고리즘 이해

* 피보나치 수열 구현

```java 
// 재귀
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.fibonacciSeq(10);
        System.out.println(result);
    }

    public int fibonacciSeq(int data) {
        if (data <= 1) {
            return data;
        }
        retun this.fibonacciSeq(data - 1) + this.fibonacciSeq(data - 2);
    }
}
```

```java
// 동적 계획법
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.dynamicFiboSeq(10);
        System.out.println(result);
    }

    public int dynamicFiboSeq(int data) {
        Integer[] cache = new Integer[data + 1];
        cashe[0] = 0;
        cashe[1] = 1;
        for (int index = 2; index < data + 1; index++) {
            // Memoization : 한번 계산한 값은 저장해서 다시 사용하지 않음 
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }
}
```

<br>