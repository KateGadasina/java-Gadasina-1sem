public class IntroTaskSameDigits {
    public static void main(String[] args){
        int x = 23977;
        if (x % 10 == (x % 100) / 10)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
