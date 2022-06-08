package GeeksforGeeks_problem;

import com.fasterxml.jackson.databind.deser.BasicDeserializerFactory;

import java.util.*;

public class ValueEqualIndex {
    public static void main(String[] args){
        int n = 5;
        int[] arr = {15, 2, 45, 12, 7};
        List<Integer> objArrList = new ArrayList<Integer>();
        if(arr.length > 0){
            for(int i = 0; i < n; i++){
                if((i+1) == arr[i]){
                    // System.out.println(arr[i]);
                    objArrList.add(arr[i]);
                }
            }
        }
        System.out.println("arrList: "+ objArrList);
    }
}
