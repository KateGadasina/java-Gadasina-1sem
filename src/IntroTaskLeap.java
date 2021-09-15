public class IntroTaskLeap {
    public static void main(String[] args){
        int x = 2200;
        if (x % 400 == 0)
            System.out.println(true);
        else if (x % 100 == 0)
            System.out.println(false);
        else if (x % 4 == 0)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
