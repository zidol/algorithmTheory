package sort.quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public List<Integer> sort(List<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);

        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > pivot) {
                rightArr.add(dataList.get(i));
            } else{
                leftArr.add(dataList.get(i));
            }
        }
        List<Integer> mergedList = new ArrayList<>();

        //재귀함수로 다시 분할
        mergedList.addAll(sort(leftArr));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(sort(rightArr));

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        QuickSort quickSort = new QuickSort();
        System.out.println(quickSort.sort(testData));;
    }
}
