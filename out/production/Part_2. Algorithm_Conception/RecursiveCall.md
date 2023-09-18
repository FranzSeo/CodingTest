## 재귀 용법 (Recursive Call, 재귀 호출)

* 고급 정렬 알고리즘에서 많이 쓰임

### 1. 재귀 용법 (Recursive Call, 재귀 호출)
  * 함수 안에서 동일한 함수를 호출하는 형태
  * 여러 알고리즘 작성시 사용됨

### 2. 재귀 용법 이해
* ex) 팩토리얼
    * 시간 복잡도 : 해당 함수를 몇 번 재귀호출 했는지 O(n-1)
    * 공간 복잡도 : 해당 함수를 호출 할 때 변수 n 선언 O(n-1) 
    * 따라서 시간/공간 복잡도는 O(n)

```java
public class Main {

   public static void main(String[] args) {
      Main factorialObj = new Main();
      int result = factorialObj.factorial(5);
      System.out.println(result);
   }

   public int factorial(int n) {
      if (n > 1) {
         return n * this.factorial(n-1);
      } else {
         return 1;
      }
   }
}
```

### 3. 재귀 호출의 일반적인 형태
   * 일정한 패턴 존재

```java
/*
-- pseudo code -- 
        
function(input) {
    if (input > threshold) {
        return function(input -1);
    } else {
        // end of call
     return specificValue; 
    }
}

function(input) {
    if (input <= threshold) {
        return specificValue;
    } else {
        return function(input -1);
    }
}
*/
```

### 4. 재귀 호출은 스택의 전형적인 예이다.
   * 함수는 내부적으로 스택처럼 관리된다.
   * OS에서 함수는 스택 메모리에 저장된다.

### 5. subList Method
```java
import java.util.*;
public class Main{
    ArrayList<Integer> testData = new ArrayList<>();
    public ArrayList<Integer> setTestData(){
       for (int data = 0; data < 10 + 1; data++){
           testData.add(data);
       }
       return testData;
    }
    public static void main(String[] args){
       System.out.println(testData());
       // 인텍스 -1 까지 subList에 담아준다
       System.out.println(testData.subList(1, testData.size()));
    }
}
```

```java
public class Main  {
   public int addList(ArrayList<Integer> dataList){
      if ( dataList.size() <= 0){
         return 0;
      }
      return dataList.get(0) +
              this.addList(new ArrayList<Integer>(
                      dataList.subList(1,dataList.size())));
   }

   public static void main(String[] args) {
      Main a = new Main();
      ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
      int result = a.addList(list);
      System.out.println(result);
   }
}
```