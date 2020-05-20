package ru.ifmo.collections;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private int[] numbers;

    public FirstUnique(int[] numbers) {
        this.numbers = numbers;
    }

    public int showFirstUnique() {
        int result = -1;
        for(int i = 0; i < numbers.length; i++){
            boolean foundPair = false;
            for(int j = 0; j < numbers.length; j++){
                if(numbers[i] == numbers[j] && i != j){
                    foundPair = true;
                    break;
                }
            }
            if(foundPair == false){
                result = numbers[i];
                break;
            }
        }
        return result;
    }

    public void add(int value) {
        int[] newArray = new int[numbers.length + 1];
        for(int i = 0; i < numbers.length; i++){
            newArray[i] = numbers[i];
        }
        newArray[numbers.length] = value;
        numbers = newArray;
    }
}
