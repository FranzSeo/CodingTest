import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }

        QuickSort obj = new QuickSort();
        ArrayList<Integer> result = obj.sort(testData);
        System.out.println(result);
    }

    // 피벗을 기준으로 좌우로 나누는 함수
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > pivot) {
                rightArr.add(dataList.get(i));
            } else {
                leftArr.add(dataList.get(i));
            }
        }
        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));

        return mergedArr;
    }


}
