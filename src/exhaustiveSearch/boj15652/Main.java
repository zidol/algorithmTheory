package exhaustiveSearch.boj15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m + 1];
        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            int start = selected[k - 1];
            //0은 쓸수 없고 1부터 n까지 쓸수 있기 때문에.
            if(start == 0) start = 1;
            for (int cand = start; cand <= n; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
}
