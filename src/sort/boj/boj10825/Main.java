package sort.boj.boj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Element implements Comparable<Element> {

        public String name;
        public int korean, english, math;


        @Override
        public int compareTo(Element o) {
            //국어 점수 내림차순
            if(korean != o.korean) return o.korean - korean;
            //영어 점수 오름차순
            if(english != o.english) return english - o.english;
            //수학 점수 내림차순
            if (math != o.math) return o.math- math;
            return name.compareTo(o.name);
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int n;
    static Element[] a;

    static void pro() {
        //기준을 통해 정렬
        Arrays.sort(a);

        //정답 출력
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = new Element[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Element();
            a[i].name = st.nextToken();
            a[i].korean = Integer.parseInt(st.nextToken());
            a[i].english = Integer.parseInt(st.nextToken());
            a[i].math = Integer.parseInt(st.nextToken());
        }
        pro();
    }
}
