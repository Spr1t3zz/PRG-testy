import java.util.ArrayList;

public class ArrayWrapper {
    public int[] numbers;

    public ArrayWrapper(int[] numbers1) {
        numbers = numbers1;
    }

//--------------------------------------------------------------------------------//

    int countIf(LambdaCount lambda1) {
        int num = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (lambda1.countPod(numbers[i])) {
                num++;
            }
        }
        return num;
    }

//-----------------------------------------------------------------------------------//

    int maxBy(LambdaMax lambda2) {
        int maxNum = Integer.MIN_VALUE;

        for (int j = 0; j < numbers.length; j++) {

            if (lambda2.maxPod(numbers[j]) > maxNum) {
                maxNum = numbers[j];
            }
        }
        return maxNum;
    }

//----------------------------------------------------------------------------------//

    ArrayList<Integer> takeWhile(LambdaTake lambda3) {
        ArrayList<Integer> newNums = new ArrayList<>();

        for (int k = 0; k < numbers.length; k++) {

            if (lambda3.takePod(numbers[k])) {
                newNums.add(numbers[k]);
            } else return newNums;
        }
        return newNums;
    }





}
