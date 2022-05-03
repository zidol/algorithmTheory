package sort.quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortTest {

    public List<Integer> sort(List<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > pivot) {
                rightList.add(dataList.get(i));
            } else {
                leftList.add(dataList.get(i));
            }
        }
        List<Integer> mergedList = new ArrayList<>();

        mergedList.addAll(sort(leftList));
        mergedList.addAll(List.of(pivot));
        mergedList.addAll(sort(rightList));
        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        QuickSortTest quickSort = new QuickSortTest();

        System.out.println(quickSort.sort(testData));
    }
 }
