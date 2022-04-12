package mergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public List<Integer> splitFunc(List<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int splitIdx = dataList.size() / 2;

        List<Integer> leftArr = new ArrayList<Integer>();
        List<Integer> rightArr = new ArrayList<Integer>();

        //0부터 splitIdx - 1 인덱스 번호까지 해당배열 아이템을 서브 배열 추출
        leftArr = splitFunc(new ArrayList<Integer>(dataList.subList(0, splitIdx)));
        rightArr = splitFunc(new ArrayList<Integer>(dataList.subList(splitIdx, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public List<Integer> mergeFunc(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        //CASE1 : left/right 둘다 있을떼
        while (leftList.size() > leftIndex && rightList.size() > rightIndex) { //인덱스가 커져 리스트 사이즈와 같아지면 다 사용했다는 의미
            if (leftList.get(leftIndex) > rightList.get(rightIndex)) {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            } else {
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            }
        }
        //CASE2 : right 데이터가 없을 때
        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        //CASE3 : left 데이터가 없을 때
        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        //test
//        MergerSort mergerSort = new MergerSort();
//        mergerSort.splitFunc(new ArrayList<>(Arrays.asList(4,1,2,3,5,7)));

        List<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int)(Math.random() * 100));
        }

        MergeSort mergeSort = new MergeSort();
        List<Integer> sortedList = mergeSort.splitFunc(testData);
        System.out.println(sortedList);
        
    }
}
