import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            testData.add((int) (Math.random() * 100));
        }
        InsertionSort insertionSort = new InsertionSort();
        ArrayList<Integer> sortedData = insertionSort.sortList(testData);
        for (int i = 0; i < sortedData.size(); i++) {
            System.out.print(sortedData.get(i) + " ");
        }
    }
    public ArrayList<Integer> sortList(ArrayList<Integer> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int index = i + 1; index > 0; index--) {
                if (dataList.get(index) < dataList.get(index - 1)) {
                    Collections.swap(dataList, index, index - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }
}
