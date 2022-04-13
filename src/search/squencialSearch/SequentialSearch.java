package search.squencialSearch;

import java.util.ArrayList;

public class SequentialSearch {

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index).equals(searchItem)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            testData.add((int)(Math.random() * 100));
        }

        SequentialSearch sequentialSearch = new SequentialSearch();
        System.out.println(testData);
        System.out.println(sequentialSearch.searchFunc(testData, 99));
    }
}
