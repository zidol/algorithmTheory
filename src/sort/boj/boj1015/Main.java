package sort.boj.boj1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Element implements Comparable<Element> {

        /**
         * @param idx A 배열의 idx 위치를 기억하는 변수
         * @param num A[idx]의 원래값
         */
        public int num, idx;


        @Override
        public int compareTo(Element o) {
            //정렬 조건에 맞게 정렬
            //1. num의 비내림 차순
            //2. num이 같으면 idx 오름차순
//            if(num != o.num) return num -o.num;
//            return idx - o.idx;
            return num - o.num;//tim sort이기 떄문(object sort) stable 상태
        }
    }

    static int n;
    static int[]p;
    static Element[] b;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = new Element[n];
        p = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = new Element();
            // Element의 정의에 맞게 b[i]에 값에 넣어주기
            b[i].num = Integer.parseInt(st.nextToken());
            b[i].idx = i;

        }
    }

    static void pro() {
        //b 배열 정렬
        Arrays.sort(b);
        
        //b 배열의 값을 이용해서 p 배열 채우기
        for (int bIdx = 0; bIdx < n; bIdx++) {
            p[b[bIdx].idx] = bIdx;
        }

        //p 배열 출력하기
        for (int i = 0; i < n; i++) {
            sb.append(p[i]).append(' ');
        }

        for (Element element : b) {
            System.out.print("b[i].num = " + element.num +"\t");
        }
        System.out.println();
        for (Element element : b) {
            System.out.print("b[i].idx = " + element.idx +"\t");
        }
        System.out.println();

        System.out.println(sb.toString());

    }




    public static void main(String[] args) throws IOException {
        input();

        pro();
    }
}
