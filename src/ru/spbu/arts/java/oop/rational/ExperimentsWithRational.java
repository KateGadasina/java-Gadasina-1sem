package ru.spbu.arts.java.oop.rational;

public class ExperimentsWithRational {
    public static void main(String[] args) {
        Rational new_num = new Rational(2, 3);
        Rational num_1 = new Rational(4);

        var num_2 = new Rational(0,5);
        var num_3 = new Rational(5,1);
        var num_4 = new Rational(4,5);
        var num_5 = new Rational(10,35);
        var num_6 = new Rational(30,18);

        System.out.println("\ntoString:\n");
        System.out.println(num_1.toString());
        System.out.println(new_num.toString());
        System.out.println(num_2.toString());
        System.out.println(num_3.toString());

        System.out.println("\ntoDouble:\n");
        System.out.println(num_4.toDouble());
        System.out.println(new_num.toDouble());
        System.out.println(num_1.toDouble());
        System.out.println(num_2.toDouble());

        System.out.println("\n10/35 = ");
        System.out.println(num_5.toString());

        System.out.println("\n30/18 = ");
        System.out.println(num_6.toString());

        System.out.println("\nAdd:\n");
        var num_7 = new Rational(1,3);
        var num_8 = new Rational(1,6);
        System.out.println(Rational.add(num_7, num_8));

        System.out.println("\nSub:\n");
        System.out.println(Rational.sub(num_8, num_7));

        System.out.println("\nMul:\n");
        System.out.println(Rational.mul(new_num, num_8));

        System.out.println("\nDiv:\n");
        System.out.println(Rational.div(new_num, num_8));

        /*System.out.println("\nAddInPlace:\n");
        var r1 = new Rational(1,3);
        var r2 = new Rational(1,6);
        System.out.println(r1.addInPlace(r2));

        System.out.println("\nSubInPlace:\n");
        System.out.println(r1.subInPlace(r2));

        System.out.println("\nMulInPlace:\n");
        var r3 = new Rational(2,3);
        System.out.println(r3.mulInPlace(r2));

        System.out.println("\nDivInPlace:\n");
        System.out.println(r3.divInPlace(r2));*/

        System.out.println("\nfunc:\n");
        func(1);
        func(2);
        func(3);
        func(20);

        System.out.println("\nGet:\n");
        System.out.println(new_num.getN());
        System.out.println(new_num.getD());

        System.out.println("\nZERO and ONE:\n");
        System.out.println(Rational.ZERO);
        System.out.println(Rational.ONE);
    }

    public static void func(int n){
        double sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (double) 1 / i;
        System.out.println(sum);
    }
}
