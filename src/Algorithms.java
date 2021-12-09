import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static void main(String[] args){

        System.out.println(Arrays.toString(sieveOfEratosthenes(30)));

        System.out.println(Arrays.toString(primes(30)));

        printTable(factor(600));
    }


    public static boolean[] sieveOfEratosthenes(int n){
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++){
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++){
            if (prime[i] == true){
                for (int j = i * i; j <= n; j =j + i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static int[] primes(int n){
        boolean[] prime = sieveOfEratosthenes(n);
        int tmp = 0;
        for (int i = 2; i <= n; i++){
            if (prime[i] == true)
                tmp += 1;
        }
        int[] pr = new int[tmp];
        int k = 0;
        for (int i = 2; i <= n; i++){
            if (prime[i] == true){
                pr[k] = i;
                k++;
            }
        }
        return pr;
    }

    public static void printTable(int[][] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static int[][] factor(int n){
        List deg = new ArrayList();
        List num = new ArrayList();
        int tmp = 0;
        int[] pr = primes(n / 2);
        for (int i = 0; pr[i] * pr[i] <= n; i++){
            while (n % pr[i] == 0){
                n /= pr[i];
                tmp++;
                //System.out.println(n);
            }
            deg.add(tmp);
            tmp = 0;
            num.add(pr[i]);
        }
        if (n != 1){
            deg.add(1);
            num.add(n);
        }
        int[][] f = new int[num.size()][2];
        for (int i = 0; i < num.size(); i++){
            f[i][0] = (int) num.get(i);
            f[i][1] = (int) deg.get(i);
        }
        return f;
    }
}
