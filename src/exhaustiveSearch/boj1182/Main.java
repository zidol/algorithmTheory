package exhaustiveSearch.boj1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, s, ans;
    static int[] nums;

    static StringBuilder sb = new StringBuilder();

    //k번째 원소를 포함시킬 지 정하는 함수
    //value := k-1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value) {
        if (k == n + 1) {//부분 수열을 하나 완성시킨 상태
            //value 가 s 랑 같은지 확인 하기
            if(value == s) ans++;
        } else {
            //k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
            //포함시키고 싶을때
            rec_func(k + 1, value + nums[k]);
            //포함 시키고 싶지 않을때
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) throws IOException {
//        FastReader scan = new FastReader();
//
//        n = scan.nextInt();
//        s = scan.nextInt();
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());

        //1번째 우너소부터 m 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색
        rec_func(1, 0);
        //ans가 정말 "진 부분집합"만 다루는지 확인
        if (s == 0) {
            ans--;
        }
        System.out.println(ans);
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
