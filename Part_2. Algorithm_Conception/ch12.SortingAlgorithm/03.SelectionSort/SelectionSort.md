## 선택 정렬 (Selection Sort)

* 선택 정렬(Insertion Sort) : 가장 작은 수를 "선택"하여 가장 앞으로 가져오는 정렬

### 알고리즘 구현
* 특이점 찾아보기
    * 두개라면 둘 중의 하나를 비교
    * 셋중 가장 작은 숫자를 앞에 놓고 다시 두수를 비교
    * dataList[0] > dataList[i] 라면 선택된 리스트의 i번째 숫자를 0과 교환
    * dataList[1] ... dataList[n]까지 교환

