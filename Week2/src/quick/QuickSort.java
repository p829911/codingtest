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
        System.out.println(Arrays.toString(sort.quickSort(array)));
    }

//    public int[] quickSort(int[] array) {
    public int[] quickSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        if (array.length == 2) {
            if (array[0] > array[1]) {
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
            return array;
        }

        int left = array[0];
        int lowIndex = 1;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            for (int i = lowIndex; i <= highIndex; i++) {
                if (array[i] > left) {
                    lowIndex = i;
                    break;
                }
            }

            for (int j = highIndex; j >= lowIndex; j--) {
                if (array[j] < left) {
                    highIndex = j;
                    break;
                }
            }
            int tmp = array[lowIndex];
            array[lowIndex] = array[highIndex];
            array[highIndex] = tmp;
            System.out.println(lowIndex);
            System.out.println(highIndex);
        }

        return array;
    }

}
