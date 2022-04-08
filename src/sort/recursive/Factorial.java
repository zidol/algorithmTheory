package sort.recursive;

import java.util.ArrayList;

public class Factorial {
    public int factorialFunc(int n) {
        if (n > 1) {
            return n * this.factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public int factorialFuncSecond(int n) {
        if (n <= 1) {
            return 1;
        } else {
           return n * factorialFuncSecond(n - 1);
        }
    }

    public int factorialFuncWithArray(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        } else {
            return dataList.get(0) + this.factorialFuncWithArray(new ArrayList<>(dataList.subList(1, dataList.size())));
        }
    }

    //ex) - 정수 4를 1, 2, 3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있음 - 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오
    public int factorialEx(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        }
        return this.factorialEx(data - 1) + this.factorialEx(data - 2) + this.factorialEx(data - 3);


    }
    public static void main(String[] args) {

        Factorial factorial = new Factorial();
        System.out.println(factorial.factorialFunc(5));

        System.out.println(factorial.factorialFuncSecond(5));

        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testData.add(i);
        }
        System.out.println(factorial.factorialFuncWithArray(testData));

        System.out.println(factorial.factorialEx(5));
    }
}
