package ru.ifmo.collections;
import java.util.Arrays;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private int[] numbers;
    private int k;

    public KthLargest(int k, int[] numbers) {
        this.numbers = numbers;
        Arrays.sort(numbers);
        this.k = k;
    }

    public int add(int val) {
        int[] newArray = new int[numbers.length + 1];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < val){
                newArray[i] = numbers[i];
            } else {
                newArray[i] = val;
                for(; i < numbers.length; i++){
                    newArray[i + 1] = numbers[i];
                }
                break;
            }
        }
        numbers = newArray;
        return numbers.length > 2 ? numbers[numbers.length - 3] : null;
    }
}