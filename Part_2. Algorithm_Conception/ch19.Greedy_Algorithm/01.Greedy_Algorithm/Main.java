import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        int[][] objList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        obj.knapsack(objList, 48);
    }

    public void knapsack(int[][] dataList, double capacity) {
        double totalValue = 0.0;
        // 해당 물건을 넣지 못하는 경우
        double fraction = 0.0;

        Arrays.sort(dataList, new Comparator<int[]>() {
            @Override
            public int compare(int[] objItem01, int[] objItem02) {
                // 가치 : objItem02[1] / 무게 : objItem02[0]
                return (objItem02[1] / objItem02[0]) - (objItem01[1] / objItem01[0]);
            }
        });
        for (int i = 0; i < dataList.length; i++) {
            if (capacity - (double) dataList[i][0] > 0) {
                capacity -= (double) dataList[i][0];
                totalValue += (double) dataList[i][1];
                System.out.println("무게 : " + dataList[i][0] + ", 가치 : " + dataList[i][1]);
            } else {
                fraction = capacity / (double) dataList[i][0];
                totalValue += (double) dataList[i][1] * fraction;
                System.out.println("무게 : " + dataList[i][0] + ", 가치 : " + dataList[i][1] + ", 비율 : " + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }
}