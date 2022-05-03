package sort.insertionSort;

import sort.selectionSort.SelectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {

    public List<Integer> sort(List<Integer> dataList) {

        System.out.println(dataList);

        System.out.println("--- start sort ---");
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (dataList.get(j) < dataList.get(j - 1)) {
                    Collections.swap(dataList, j, j - 1);

                    System.out.println(dataList);
                } else {
                    break;
                }
                System.out.println(dataList);
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 20));
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(dataList);
    }
}
