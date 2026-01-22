import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long result = mergeSort(arr, 0, n - 1);

        System.out.println(result);
    }

    public static long mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            long leftCount = mergeSort(arr, left, mid);
            long rightCount = mergeSort(arr, mid + 1, right);
            long mergeCount = mergeAndCount(arr, left, mid, right);

            return leftCount + rightCount + mergeCount;
        }
        return 0;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        long inversionCount = 0; // 역전 개수

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // 오른쪽 그룹의 원소가 선택됨 → 역전 발생
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1); // 왼쪽 그룹의 남은 원소 개수만큼 역전
            }
        }

        // 나머지 처리
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        // 원본 배열에 복사
        for (int idx = 0; idx < temp.length; idx++) {
            arr[left + idx] = temp[idx];
        }

        return inversionCount;
    }
}