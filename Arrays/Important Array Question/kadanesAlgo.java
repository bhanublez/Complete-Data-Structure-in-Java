import java.util.*;

//Find a non-empty sub-array largest sum
public class kadanesAlgo {

    // Brute force O(n^2)
    public int findSubArraySum(int arr[]) {
        int n = arr.length;
        int result = arr[0];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    // Optimal Solution O(n)
    public int optimalFindSubArraySum(int arr[]){
        int n = arr.length;
        int sum = 0, result = arr[0];
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, 0);
            sum += arr[i];
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        kadanesAlgo k = new kadanesAlgo();
        int arr[] = { 4, -1, 2, -7, 3, 4 };
        System.out.println(k.findSubArraySum(arr));
        System.out.println(k.optimalFindSubArraySum(arr));
    }
}