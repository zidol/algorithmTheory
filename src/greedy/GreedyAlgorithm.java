package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GreedyAlgorithm {
    public void findCoin(Integer price, List<Integer> coins) {

        //전체 사용 동전 수
        Integer totalCoinCount = 0;
        //각각의 동전으로 지불 금액을 매꿀 때 갯수
        Integer coinNum = 0;

        //실제 내부적으로 어떻게 계산되는지 기록 하기 위해
        List<Integer> details = new ArrayList<>();

        for (Integer coin : coins) {
            coinNum = price / coin;
            totalCoinCount += coinNum;
            //각동전의 갯수만큼 빼고 남은 금액(다음 동전으로 위 계산 하기 위해)
            price -= coinNum * coin;
            details.add(coinNum);

            System.out.println(coin + "원 : " + coinNum + "개");
        }
        System.out.println("총 동전의 갯수 : " + totalCoinCount);
    }

    public void knapsack(Integer[][] objList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                //무게당 가치 비율
                return (o2[1]/o2[0]) - (o1[1]/o1[0]);
            }
        });

        for (int i = 0; i < objList.length; i++) {
            //
            if (capacity - (double) objList[i][0] > 0) {
                capacity -= (double) objList[i][0];
                totalValue += (double) objList[i][1];
                System.out.println("무게 : " +objList[i][0] + " , 가치 : " + objList[i][1]);
            } else {
                fraction = capacity / (double) objList[i][0];
                totalValue += (double) objList[i][1] * fraction;
                System.out.println("무게 : " + objList[i][0] + " , 가치 : " + objList[i][1] + ", 비율 : " + fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치 : " + totalValue);
    }

    public static void main(String[] args) {
        //동전 개수 구하기
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        List<Integer> coins = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        greedyAlgorithm.findCoin(4720, coins);
        System.out.println("--------------------------------------");
        //부분 배낭 문제
        Integer[][] objList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        greedyAlgorithm.knapsack(objList, 30.0);
    }
}
