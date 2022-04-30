package exhaustiveSearch.boj15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] selected;
    public static void main(String[] args) throws IOException {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(sb.toString());
    }
    private static void input() {
        FastReader scan = new FastReader();
        n = scan.nextInt();
        m = scan.nextInt();
        selected = new int[m + 1];
    }

    static void rec_func(int k) {
        if (k == m + 1) {
            for (int i = 1; i <= m; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= n; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
