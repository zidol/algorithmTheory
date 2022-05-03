package sort.insertionSort;

import sort.bubbleSort.BubbleTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSortTest {

    static class InsertionSort {
        List<Integer> sort(List<Integer> dataList) {
            for (int i = 1; i < dataList.size(); i++) {
                int key = 0;
                for (int j = i; j > 0; j--) {
                    if (dataList.get(j) < dataList.get(j - 1)) {
                        Collections.swap(dataList, j, j - 1);
                    } else {
                        break;
                    }
                }

            }
            return dataList;
        }
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 20));
        }
        System.out.println("=== 변경 전 ===");
        System.out.println(dataList);

        InsertionSort insertionSort = new InsertionSort();
        System.out.println("=== 변경 후 ===");
        System.out.println(insertionSort.sort(dataList));;

    }
}
