## 순차 탐색

### 1. 순차 탐색 (Sequential Search) 이란?
* 탐색은 여러 데이터 중에서 원하는 데이터를 찾아내는 것을 의미
* 데이터가 담겨있는 리스트를 앞부터 하나씩 비교해서 원하는 데이터를 검출

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            testData.add((int) (Math.random() * 100));
        }
        Main obj = new Main();
        int result = obj.seqSearch(testData, 30);
        System.out.println(result);
    }

    public int seqSearch(ArrayList<Integer> dataList, Integer searchItem) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i) == searchItem) {
                return i;
            }
        }
        return -1;
    }
}
```