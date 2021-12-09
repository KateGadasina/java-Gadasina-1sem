import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularExp {
    public static void main(String[] args){

        String text = "ffnd@jbj.com";
        Pattern email = Pattern.compile("[a-z][a-z]*\\@[a-z][a-z]*\\.[a-z]{2,4}");
        Matcher m = email.matcher(text);
        System.out.println(m.matches());

        String text2 = "ff.nd@jb4-j.com";
        Pattern email2 = Pattern.compile("([a-z][a-z]*|[a-z][a-z._\\.\\-\\d]*)\\@([a-z][a-z]*|[a-z][a-z._\\-\\.\\d]*)\\.[a-z]{2,4}");
        Matcher m2 = email2.matcher(text2);
        System.out.println(m2.matches());

        String text3 = "23:16 и 12:54 и 77:88, а также 35:21";
        time(text3);

        String text4 = "Это , строка   , у которой  , зачем-то   , написаны два , пробела   , перед запятой.";
        System.out.println(del(text4));

        String text5 = "какая-то сине-зеленовая трава";
        System.out.println(replace(text5));

    }

    public static void time(String ar){
        Pattern timePattern = Pattern.compile("\\d\\d:\\d\\d");
        Matcher m = timePattern.matcher(ar);
        Pattern timePattern2 = Pattern.compile("((0|1)\\d|20|21|22|23):(0|1|2|3|4|5)\\d");

        while (m.find()) {
            Matcher m2 = timePattern2.matcher(m.group());
            System.out.println(m.group());
            System.out.println(m2.matches());
        }
    }
    public static String del(String ar){
        String strnew = ar.replaceAll(" *,", ",");
        return strnew;
    }

    public static String replace(String ar){
        String strnew = ar.replaceAll("([а-я]+)-([а-я]+)", "$2-$1");
        return strnew;
    }
}
