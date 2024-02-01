import java.util.*;
//Given an array and return true if two elements within a window of size k that are equals
public class slidingwindow {
    
    //Brute force approach
    public boolean checkWindow(int arr[], int k) {
        int n = arr.length;
        if (n >= k) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < k; j++) {
                    if (arr[i] == arr[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 7, 3, 2, 3, 3 };
        slidingwindow s = new slidingwindow();
        System.out.println(s.checkWindow(arr, 3));
    }
}