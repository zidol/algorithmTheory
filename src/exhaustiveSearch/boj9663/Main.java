package exhaustiveSearch.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans; //ans : 가능한 경우수를 셀 변수
    static int[] col; // col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록
    static StringBuilder sb = new StringBuilder();

    //row 번 ~ n 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
    static void rec_func(int row) {
        if (row == n + 1) {//각 행마다 하나씩 잘 놓았다.
//            if (validity_check()) {
                ans++;
//            }
        } else {
            for (int i = 1; i <= n; i++) {
                boolean possible = true;
                //valid check (row, c)
                for (int j = 1; j <=row - 1; j++) {
                    if (attackable(row, i, j, col[j])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = i;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean validity_check() {
        for (int i = 0; i <= n; i++) {
            //(i, col[i]) i행 i열
            for (int j = 0; j < i; j++) {
                //(j, col[j[)
                if (attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    //공격 여부
    static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;//같은 열
        if(r1 - c1 == r2 - c2) return true;//왼쪽 대각선 관계
        return r1 + c1 == r2 + c2;//오른쪽 대각선 관계
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        col = new int[n + 1];
        rec_func(1);
        System.out.println(ans);
    }
}
