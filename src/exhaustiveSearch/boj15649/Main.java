package exhaustiveSearch.boj15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected, used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        //인덱스의 숫자가 쓰였는지 안쓰였는지 체크하기 위해(해당 인덱스가 1이면 인덱스 숫자가 쓰였다는 의미)
        used = new int[n + 1];
        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= n; cand++) {
                //case 1.
//                boolean isUsed = false;
//                for (int i = 0; i < k; i++) {
//                    if (cand == selected[i]) {
//                        isUsed = true;
//                    }
//                }
//                if (!isUsed) {
//                    selected[k] = cand;
//                    rec_func(k + 1);
//                    selected[k] = 0;
//                }

                //case 2.
                //cand 인덱스가 1이면 해당 인덱스 숫자가 쓰였다는 의미
                if(used[cand] == 1) {
                    continue;
                }
                selected[k] = cand;
                used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;
            }
        }
    }
}
