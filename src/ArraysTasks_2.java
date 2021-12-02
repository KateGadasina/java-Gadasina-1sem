import java.util.Arrays;

public class ArraysTasks_2 {
    public static void main(String[] args){
        // решение новой задачи
        System.out.println(Arrays.toString(even(5)));

        int[] arr1 = {4,5,5,5,5};
        System.out.println(allSimilar(arr1));

        int[] arr2 = {4,5,7,7,8};
        System.out.println(hasSimilar(arr2));

        System.out.println(mean(arr2));

        shift(arr2);

        //int[] arr3 = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(copyShift(arr2)));
    }

    public static int[] even(int n){
        int[] a = new int[n];
        int x = 2;
        for (int i = 0; i < n; i++) {
            a[i] = x;
            x += 2;
        }
        return a;
    }

    public static boolean allSimilar(int[] a){
        if (a.length < 2)
            return true;
        else {
            int tmp = 1;
            for (int i = 1; i < a.length; i++){
                if (a[0] != a[i])
                    tmp = 0;
            }
            if (tmp == 1)
                return true;
            else
                return false;
        }
    }

    public static boolean hasSimilar(int[] a){
        int tmp = 0;
        for (int i = 0; i < a.length - 1; i++){
            for (int j = i + 1; j < a.length; j++){
                if (a[i] == a[j])
                    tmp = 1;
            }
        }
        if (tmp == 1)
            return true;
        else
            return false;
    }

    public static double mean(int[] a){
        double sum = 0;
        for (int x : a){
            sum += x;
        }
       return sum / a.length;
    }

    public static void shift(int[] a){
        int tmp = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--){
            a[i] = a[i - 1];
        }
        a[0] = tmp;
        System.out.println(Arrays.toString(a));
        return;
    }

    public static int[] copyShift(int[] a){
        int[] new_a = new int[a.length];
        for (int i = 1; i < a.length; i++){
            new_a[i] = a[i - 1];
        }
        new_a[0] = a[a.length - 1];
        return new_a;
    }
}