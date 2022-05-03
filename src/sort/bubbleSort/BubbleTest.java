package sort.bubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleTest {
    static class BubbleSort {

        public List<Integer> sort(List<Integer> list) {

            for (int i = 0; i < list.size() - 1; i++) {
                int isSwap = 0;
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.get(j) > list.get(j + 1)) {
                        Collections.swap(list, j, j + 1);
                        isSwap += 1;
                    }
                }
                if (isSwap == 0) {
                    break;
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        List<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 20));
        }
        System.out.println("=== 변경 전 ===");
        System.out.println(dataList);

        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("=== 변경 후 ===");
        bubbleSort.sort(dataList);
        System.out.println(dataList);
    }
}
