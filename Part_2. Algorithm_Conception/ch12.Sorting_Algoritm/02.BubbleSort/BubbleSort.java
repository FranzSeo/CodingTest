import java.util.*;

public class BubbleSort {

    public static List<Integer> dataList;
    public static void main(String[] args){
        // System.out.print(compare2number(4,2));
        // System.out.print(compare3number(4,8,1));
        dataList = new ArrayList<>();
        getData();
    }
    /*
     public static void sort(int[] arr) {
        int end = arr.length - 1;
        while (end > 0) {
            int last_swap = 0;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    last_swap = i;
                }
            }
            end = last_swap;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    } 
     */
    //Bubble Sort

    public static List<Integer> getData(){
        List<Integer> getList = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Insert data size : ");
        int dataSize = scan.nextInt();

        for(int i = 0; i < dataSize; i++){
            int data = scan.nextInt();
            getList.add(data);
        }

        return getList;
    }
    
    public static List<Integer> bubbleSort(ArrayList<Integer> dataList){
        int endpoint = dataList.size() - 1;
        for(int i = endpoint; i > 0; i--){
            boolean swapped = false;
            for(int j = 0; j < i; j++){
                Collections.swap(dataList, j, j+1);
                swapped = true;
            }
            if(!swapped) break;
        }
        return dataList;
    }



    // public static List<Integer> compare2number(int a, int b){
    //     List<Integer> datas = new ArrayList<Integer>();

    //     datas.add(a);
    //     datas.add(b);

    //     if(datas.get(0) > datas.get(1)){
    //         Collections.swap(datas, 0, 1);
    //     }
    //     return datas;
    // }

    // // 문제 발생 !!! 
    // public static List<Integer> compare3number(int a, int b, int c){
    //     List<Integer> datas = new ArrayList<Integer>();

    //     datas.add(a);
    //     datas.add(b);
    //     datas.add(c);

    //     for(int i = 0; i < datas.size() - 1; i++){
    //         if(datas.get(i) > datas.get(i + 1)){
    //             Collections.swap(datas, i, i + 1);
    //         }
    //     }
    //     return datas;
    // }
}
