package sort.selectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public List<Integer> sort(List<Integer> dataList) {
        int min;
        System.out.println(dataList);
        System.out.println("--- Before Sort");
        for (int i = 0; i < dataList.size() - 1; i++) {
            //맨처음 인덱스의 값이 가장작다고 가정 후 시작
            min = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(min) > dataList.get(j)) {
                    min = j;
                }
            }
            Collections.swap(dataList, min, i);
            System.out.println(dataList);
        }
        return dataList;
    }
    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            dataList.add((int)(Math.random() * 20));
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(dataList);
    }
}
