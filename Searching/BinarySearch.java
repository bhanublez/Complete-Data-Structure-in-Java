package Searching;

import java.util.*;
import java.util.function.DoubleFunction;
import java.io.*;

public class BinarySearch {
    private static double binarySearch(double low,double high,int target,DoubleFunction<Double> funtion){
        if(high<=low){
            throw new IllegalArgumentException("Hi high should'nt be less then low");
        }
        double mid=0;
        while(low<high){
            mid=(low)+(high-low)/2;
            double value=funtion.apply(mid);
            if(value>target){
                high=mid;
            }else{
                low=mid;
            }
        }
        return mid;
    }
    
}
