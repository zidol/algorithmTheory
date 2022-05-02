package exhaustiveSearch.boj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static int[] nums, operators, order;
    static StringBuilder sb = new StringBuilder();

    //완성된 식에 맞게 계산을 햇허 정답에 갱신하는 작업
    static int calculator() {
        //nums, order
        int value = nums[1];
        for (int i = 1; i <= n - 1; i++) {
            //value, order[i], nums[i+1]
            if (order[i] == 1) { // +
                value = value + nums[i + 1];
            }
            if (order[i] == 2) { // -
                value = value - nums[i + 1];
            }
            if (order[i] == 3) { // *
                value = value * nums[i + 1];
            }
            if (order[i] == 4) { // /
                value = value / nums[i + 1];
            }
        }
        return value;
    }
    static void rec_func(int k) {
        if (k == n) {
            //완성된 식에 맞게 계산을 햇허 정답에 갱신하는 작업
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            //
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        operators = new int[5];
        order = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

    }
}
