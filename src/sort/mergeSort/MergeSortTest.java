package sort.mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

    public List<Integer> splitFunc(List<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int splitIdx = dataList.size() / 2;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        leftList = splitFunc(new ArrayList<>(dataList.subList(0, splitIdx)));
        rightList = splitFunc(new ArrayList<>(dataList.subList(splitIdx, dataList.size())));

        return mergeFunc(leftList, rightList);

    }

    private List<Integer> mergeFunc(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        // left/right 둘다 있을때
        while (leftList.size() > leftIndex && rightList.size() > rightIndex) {
            if (leftList.get(leftIndex) > rightList.get(rightIndex)) {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            } else{
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            }
        }

        //right 데이터가 없을때
        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        //left 데이터가 없을떼
        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }
        MergeSortTest mergeSort = new MergeSortTest();
        List<Integer> integers = mergeSort.splitFunc(testData);
        System.out.println(integers);
    }
}
