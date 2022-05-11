package exhaustiveSearch.boj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static int[] nums, operators, order;// operators: 각연산자가 몇 개 있는지 담는 배열, order : 어떤 순서로 연산자를 배열 했는지 기록하는 배열
    static StringBuilder sb = new StringBuilder();

    //방법 1
    static int calculator(){
        int value = nums[1];
        for (int i = 0; i <= n; i++) {
            if(order[i] == 1) // +
                value += nums[i + 1];
            if(order[i] == 2) // +
                value -= nums[i + 1];
            if(order[i] == 3) // +
                value *= nums[i + 1];
            if(order[i] == 4) // +
                value /= nums[i + 1];
        }
        return value;
    }

    //방법 2
    //피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operator, int operand1, int operand2) {
        //value, order[i], nums[i+1]
        if (operator == 1) { // +
            return operand1 + operand2;
        }
        else if (operator == 2) { // -
            return operand1 - operand2;
        }
        else if (operator == 3) { // *
            return operand1 * operand2;
        }
        else {
            return operand1 / operand2;
        }
    }
    // order[1...n-1]에 연산자들이 순서대로 저장될 것이다.
    //k-1번째 연산자까지 계산한 결과가 value이다.
    static void rec_func(int k, int value) {
        if (k == n) {//모든 연산자들을 전부 나열하는 방법을 찾은 상태
            //완성된 식에 맞게 계산을 햇허 정답에 갱신하는 작업
//            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            //4가지의 연산자들 중에 뭘 쓸 것인지 선택하고 연산자를 계산한 후에 재귀 호출하기
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    //연산자 사용 했다는 의미로 횟수 감소
                    operators[cand]--;
                    //k번째 cand를 썼다는 의미
//                    order[k] = cand;
                    rec_func(k + 1, calculator(cand, value, nums[k + 1]));
                    operators[cand]++;
//                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        operators = new int[5];
        order = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

    }
}
