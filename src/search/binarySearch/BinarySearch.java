package search.binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

    public boolean contains(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int mid = dataList.size() / 2;

        if (searchItem == dataList.get(mid)) {
            return true;
        } else {
            if (searchItem < dataList.get(mid)) {
                return contains(new ArrayList<Integer>(dataList.subList(0, mid)),searchItem);
            } else {
                return contains(new ArrayList<Integer>(dataList.subList(mid, dataList.size())),searchItem);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        Collections.sort(testData);
        System.out.println(testData);
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.contains(testData, 4));;
    }
}
