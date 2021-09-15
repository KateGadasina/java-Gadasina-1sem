public class IntroTaskCat {
    public static void main(String[] args){
        int x = 1011;
        if (x % 100 > 10 && x % 100 < 20)
            System.out.println(x + " " + "котов");
        else if (x % 10 == 1)
            System.out.println(x + " " + "кот");
        else if (x % 10 >= 2 && x % 10 <= 4)
            System.out.println(x + " " + "кота");
        else
            System.out.println(x + " " + "котов");
    }
}
