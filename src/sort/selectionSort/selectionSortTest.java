package sort.selectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class selectionSortTest {

    public List<Integer> sort(List<Integer> dataList) {

        int min;

        System.out.println("=== Before Sort ===");

        System.out.println(dataList);
        for (int i = 0; i < dataList.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < dataList.size(); j++) {
                if (dataList.get(min) > dataList.get(j)) {
                    min = j;
                }
            }
            Collections.swap(dataList, min, i);
        }
        return dataList;
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            dataList.add((int)(Math.random() * 100));
        }
        selectionSortTest selectionSort = new selectionSortTest();
        selectionSort.sort(dataList);

        System.out.println("=== After Sort ===");
        System.out.println("selectionSort = " + dataList);
    }
}
