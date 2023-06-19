## 배열(Array)

* 데이터를 나열하고, 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조
* 자바 -> Array / 파이썬 -> List
* 같은 종류의 데이터를 효율적으로 관리하기 쉬움
* 같은 종류의 데이터를 순차적으로 저장

<hr/>

* 장점
    * 빠른 접근 가능
        * 첫 데이터의 위치에서 상대적인 위치로 데이터 접근(인덱스 번호)
* 단점
    * 데이터 추가 / 삭제의 어려움
        * 미리 최대 길이를 지정해야 함

<hr/>
Primitive / Wrapper Class
<br/>

Wrapper Class 의 장점
* null 처리에 용의
* ArrayList 등 객체만 핸들링하는 기능을 사용하기 위해

```java
Integer[] dataList = new Integer[10];
data_list[0] = 1
```

```java
Integer dataList01[] = {1,2,3,4,5};
Integer[] dataList02 = {2,3,4,5,6};
```

### List 와 ArrayList
* List<Integer> list001 = new ArrayList<Integer>();
* ArrayList<Integer> list002 = new ArrayList<Integer>();
* ArrayList<Integer> list003 = new ArrayList<>();

* List는 인터페이스고, ArrayList는 클래스
    * 클래스는 크게 일반 클래스와 클래스 내의 '추상 메서드가'가 하나 이상 있거나, abstract로 정의 된 추상 클래스로 나뉨
    * 인터페이스는 모든 메서드가 추상 메서드인 경우를 의미하며, 인터페이스를 상속받는 클래스는 인터페이스에서 정의된 추상 메서드를 모두 구현 해야함 (__따라서 다양한 클래스를 상속받는 특정 인터페이스는 결국 동일한 메스드를 제공함__)
    * ArrayList 가 아니라, List로 선언된 변수는 다음과 같이 필요에 따라 다른 리스트 클래스를 쓸 수 있는 __구현상의 유연성__을 제공함