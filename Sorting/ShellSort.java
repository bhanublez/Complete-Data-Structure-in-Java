import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = { 12, 34, 54, 2, 3 };
        ShellSort ob = new ShellSort();
        ob.sort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));

    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            return;
        }

    }
}
