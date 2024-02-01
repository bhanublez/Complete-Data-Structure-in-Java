public class prefixSum {

    public int prefixSum(int arr[]) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = { 2, -1, 3, -3, 4 };
        prefixSum p = new prefixSum();
        System.out.println(p.prefixSum(arr));
    }
}
