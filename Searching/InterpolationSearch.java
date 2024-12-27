package Searching;

import java.util.*;
import java.util.function.DoubleFunction;
import java.io.*;
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int val) {
        int low = 0, high = arr.length - 1, mid = 0;
        while (arr[low] <= val && arr[high] >= val) {
            mid = low + ((val - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[mid] < val) {
                low = mid + 1;
            } else if (arr[mid] > val) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (arr[low] == val)
            return low;
        return -1;
    }
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(interpolationSearch(values, 11));
    }
}
