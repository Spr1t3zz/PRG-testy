import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[] list = {1, 2, 3, 5, 6, -13, 7, -10, -5};

        ArrayWrapper numbers = new ArrayWrapper(list);

        int count = numbers.countIf(num -> num % 2 == 0);
        System.out.println(count); //funguje- 2,6,-10

        int max = numbers.maxBy(num -> Math.abs(num));
        System.out.println(max); //nefunguje???

        ArrayList<Integer> take = numbers.takeWhile(num -> num > 0);
        System.out.println(take); //funguje- 1,2,3,5,6 potom je -13




    }
}
