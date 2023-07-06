import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 25; i++) {
            testData.add((int) (Math.random() * 100));
        }

        MergeSort obj = new MergeSort();
        ArrayList<Integer> result = obj.splitFunc(testData);
        System.out.println(result);
    }

    /*
    public void splitFunc(ArrayList<Integer> dataList){
        if (dataList.size() <= 1){
            return ;
        }
        int medium = dataList.size() / 2;
        System.out.println("medium : " + medium);

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        // 0 부터 medium - 1 인덱스까지 해당 배열 아이템을 subList로 생성
        leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));

        System.out.println(leftArr);
        System.out.println(rightArr);
    }
     */
    public ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = this.splitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        rightArr = this.splitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE 1 : left/right 둘다 값이 있을때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE 2 : right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // CASE 3 : left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }
}
