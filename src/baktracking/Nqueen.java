package baktracking;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public void dfsFunc(Integer n, Integer currentRow, List<Integer> currentCandidate) {

        //모든 row 다 돌았다면
        if (currentRow == n) {
            System.out.println(currentCandidate);
        }
        for (int i = 0; i < n; i++) {

            //위치가 적합하다
            if (isAvailable(currentCandidate, i)) {
                currentCandidate.add(i);
                dfsFunc(n, currentRow + 1, currentCandidate);
                //조건이 만족되는게 없을때 가지치기(조건이 만족 하지 않으면 다시 돌아가기 위해)
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public boolean isAvailable(List<Integer> candidate, Integer currentCol) {
        int currentRow = candidate.size();  //currentCandidate 사이즈는 현재 확인해야할 행의 위치를 알려줌
        for (int i = 0; i < currentRow; i++) {
            if ((candidate.get(i) == currentCol) || (Math.abs(candidate.get(i) - currentCol) == currentRow - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        nqueen.dfsFunc(4, 0, new ArrayList<>());
    }
}
