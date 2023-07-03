import java.util.*;

public class BubbleSort {
    public ArrayList<Integer> sortList(ArrayList<Integer> dataList) {
        // 반복되는 횟수
        for (int index01 = 0; index01 < dataList.size() - 1; index01++) {
            // 자리 교환이 안될 때 로직을 마치는 false -> true
            boolean swap = false;

            for (int index02 = 0; index02 < dataList.size() - 1 - index01; index02++) {
                if (dataList.get(index02) > dataList.get(index02 + 1)) {
                    Collections.swap(dataList, index02, index02 + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            testData.add((int) (Math.random() * 100));
        }
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Integer> sortedData = bubbleSort.sortList(testData);
        for (int i = 0; i < sortedData.size(); i++) {
            System.out.print(sortedData.get(i) + " ");
        }
    }
}
