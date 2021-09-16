public class IntroTaskQuadraticEquation {
    public static void main(String[] args){
        double a = 0;
        double b = 4;
        double c = 3;

        if (a == 0 && b == 0 && c == 0)
            System.out.println("бесконечно много решений");
        else if (a == 0 && b == 0)
            System.out.println("нет решений");
        else if (a == 0) {
            double x = -c / b;
            System.out.printf("одно решение x = %.2f", x);
        }
        else if ((b * b - 4 * a * c) == 0) {
            double x = -b / (2 * a);
            System.out.printf("одно решение x = %.2f", x);
        }
        else if ((b * b - 4 * a * c) < 0)
            System.out.println("нет решений");
        else if ((b * b - 4 * a * c) > 0) {
            double x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double x2 = (-b + Math.sqrt(b * b - 4 * a * c))/ (2 * a);
            if (x2 > x1)
                System.out.printf("два решения x1 = %.2f, x2 = %.2f", x1, x2);
            else
                System.out.printf("два решения x1 = %.2f, x2 = %.2f", x2, x1);
        }
    }
}
