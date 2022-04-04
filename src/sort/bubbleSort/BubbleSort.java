package sort.bubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {

        //리스트 전체 체크 반복
        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;

            //2개 비교 반복
            for (int j = 0; j < dataList.size() - 1 - i; j++) {
                if (dataList.get(j) > dataList.get(j + 1)) {
                    Collections.swap(dataList, j, j + 1);
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println(testData);;
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(testData));;
    }
}
