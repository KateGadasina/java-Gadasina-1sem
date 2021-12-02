import java.util.Arrays;

public class MultidimentionalArrays {
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {10, 20, 30},
                {40, 50, 60, 70, 80, 90},
                {100, 200000}
        };
        printTable(arr);

        printTableAligned(arr);

        printTable(createTable(20, '.'));

        System.out.println("============ Заполним строки: =========");
        printTable(fillFirstAndLastLines(createTable(20, '.')));

        System.out.println("============ Заполним столбцы: ==========");
        printTable(fillFirstAndLastColumns(createTable(20, '.')));
    }

    public static void printTable(int[][] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static void printTableAligned(int[][] a){
        int max = 0;
        for (int[] b : a){
            for (int x : b){
                if (x > max)
                    max = x;
            }
        }
        int tmp = 3;
        while (max / 10 != 0){
            tmp++;
            max /= 10;
        }
        //System.out.println(tmp);
        for (int[] b : a){
            for (int x : b){
                System.out.printf("%" + tmp + "d", x);
            }
            System.out.println();
        }
    }

    public static char[][] createTable( int n, char sym){
        char[][] c = new char[n][n];
        for (char x1[] : c){
            for (int i = 0; i < x1.length; i++){
                x1[i] = sym;
            }
        }
        return c;
    }

    public static void printTable(char[][] c){
        for (char x1[] : c){
            System.out.println(x1);
        }
    }

    public static char[][] fillFirstAndLastLines(char[][] c){
        for (int i = 0; i < 20; i++){
            if (i == 0 || i == 19)
                Arrays.fill(c[i], '#');
        }
        return c;
    }

    public static char[][] fillFirstAndLastColumns(char[][] c){
        for (char x1[] : c){
            for (int i = 0; i < x1.length; i++){
                if (i == 0 || i == x1.length-1){
                    x1[i] = '#';
                }
                else
                    x1[i] = '.';
            }
        }
        return c;
    }
}
