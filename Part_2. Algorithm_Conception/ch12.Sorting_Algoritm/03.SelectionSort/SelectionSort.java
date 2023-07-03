import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            testData.add((int) (Math.random() * 100));
        }
        SelectionSort selectionSort = new SelectionSort();
        ArrayList<Integer> sortedData = selectionSort.sortList(testData);
        for (int i = 0; i < sortedData.size(); i++) {
            System.out.print(sortedData.get(i) + " ");
        }
    }

    public ArrayList<Integer> sortList(ArrayList<Integer> dataList) {
        int minCur;
        // 몇번째 배열인지 순회
        for (int stand = 0; stand < dataList.size() - 1; stand++) {
            // 커서와 현재 위치 비교
            minCur = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {
                if (dataList.get(minCur) > dataList.get(index)) {
                    minCur = index;
                }
            }
            Collections.swap(dataList, minCur, stand);
        }
        return dataList;
    }
}