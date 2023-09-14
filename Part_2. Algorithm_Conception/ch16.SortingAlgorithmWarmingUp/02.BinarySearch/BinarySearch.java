import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        Collections.sort(testData);
        System.out.println(testData);

        BinarySearch obj = new BinarySearch();
        boolean result = obj.biSearch(testData, 30);
        System.out.println(result);
    }

    public boolean biSearch(ArrayList<Integer> dataList, int searchItem) {
        if (dataList.size() == 0) {
            return false;
        }
        if (dataList.size() == 1 && dataList.get(0) == searchItem) {
            return true;
        }
        if (dataList.size() == 1 && dataList.get(0) != searchItem) {
            return false;
        }

        int middle = dataList.size() / 2;

        if (searchItem == dataList.get(middle)) {
            return true;
        } else {
            if (searchItem < dataList.get(middle)) {
                return this.biSearch(new ArrayList<Integer>(dataList.subList(0, middle)), searchItem);
            } else {
                return this.biSearch(new ArrayList<Integer>(dataList.subList(middle, dataList.size())), searchItem);
            }
        }
    }
}
