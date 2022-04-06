# 대표적인 정렬3: 선택 정렬 (Selection sort)
# 1. 선택 정렬 (selection sort) 란?
* 다음과 같은 순서를 반복하며 정렬하는 알고리즘
    1. 주어진 데이터 중, 최소값을 찾음
    2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
    3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함

<img src="https://hudi.kr/wp-content/uploads/2018/02/selectionsort.gif" >

> 출처: https://hudi.kr/wp-content/uploads/2018/02/selectionsort.gif

* 데이터가 두 개 일때
    - 예: dataList = [10, 1]
        - dataList[0] > dataList[1] 이므로 dataList[0] 값과 dataList[1] 값을 교환
* 데이터가 세 개 일때
    - 예: dataList = [10, 1, 7]
        - 처음 한번 실행하면, 1, 10, 7 이 됨
        - 두 번째 실행하면, 1, 7, 10 가 됨
* 데이터가 네 개 일때
    - 예: dataList = [9, 4, 3, 2]
        - 처음 한번 실행하면, 2, 4, 3, 9 가 됨
        - 두 번째 실행하면, 2, 3, 4, 9 가 됨
        - 세 번째 실행하면, 변화 없음
# 2. 알고리즘 구현
1. for (int i = 0; i < dataList.size() - 1; i++) 로 반복
2. min = i 로 놓고,
3. for (int j = i + 1; j < dataList.size(); j++) 로, i 이후부터 반복
    - 내부 반복문 안에서 dataList[min] > dataList[j] 이면,
        - min = num
4. dataList[min] 와 dataList[j]  자리 변경