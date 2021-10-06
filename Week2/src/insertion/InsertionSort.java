/*
    자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여,
    자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘
    https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html
 */
package insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
//        int[] array = {8, 5, 6, 2, 4};
        int[] array = {5, 2, 4, 3, 1};
        int[] answer = sort.insertionSort(array);
        System.out.println(Arrays.toString(answer));
    }

    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j+1]) {
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
