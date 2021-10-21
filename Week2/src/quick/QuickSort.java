/*
    https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html
    - 리스트 안에 있는 한 요소를 선택한다. 이렇게 고른 원소를 피벗(pivot)이라고 한다.
    - 피벗을 기준으로 피벗보다 작은 요소들은 모두 피벗의 왼쪽으로 옮겨지고
    - 피벗보다 큰 요소들은 모두 피벗의 오른쪽으로 옮겨진다.
    - 피벗을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 정렬한다.
        - 분할된 부분 리스트에 대하여 순환 호출을 이용하여 정렬을 반복한다.
        - 부분 리스트에서도 다시 피벗을 정하고 피벗을 기준으로 2개의 부분 리스트로 나누는 과정을 반복
    - 부분 리스트들이 더 이상 분할이 불가능할 때까지 반복한다.
        - 리스트의 크기가 0이나 1이 될 때까지 반복한다.
 */
package quick;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = {5, 3, 2, 4, 1};
        sort.quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;
        while (start < end) {

            while (i < end && pivot > array[start]) start++;
            while (j > start && pivot < array[end]) end--;

            System.out.println(start);
            System.out.println(end);
        }
    }
}
