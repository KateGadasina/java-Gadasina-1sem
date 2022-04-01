package ru.spbu.arts.java.oop.rational;

public class Rational {
    private int n;
    private int d;
    static Rational ONE = new Rational(1);
    static Rational ZERO = new Rational(0);

    public Rational(int n, int d) {
        if (d == 0)
            System.out.println("denominator is zero");
        else {
            int a = gcd(n, d);
            this.n = n / a;
            this.d = d / a;
            }
    }

    public Rational(int n){
        this.n = n;
        this.d = 1;
    }

    public static int gcd(int x, int y){
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        if (y == 0) return x;
        return gcd(y,x%y);
    }

    @Override
    public String toString(){
        if (n == 0)
            return "0";
        else if (d == 1)
            return String.format("%d", n);
        else return String.format("%d/%d", n, d);
    }

    public double toDouble(){
        double n_d = (double)n;
        double d_d = (double)d;
        return n_d/d_d;
    }

    public static Rational add(Rational r1, Rational r2){
        int d_new = r1.d * r2.d;
        int n_new = r1.n * r2.d + r1.d * r2.n;
        return new Rational(n_new, d_new);
    }

    public static Rational sub(Rational r1, Rational r2){
        int d_new = r1.d * r2.d;
        int n_new = r1.n * r2.d - r1.d * r2.n;
        return new Rational(n_new, d_new);
    }

    public static Rational mul(Rational r1, Rational r2){
        return new Rational(r1.n * r2.n, r1.d * r2.d);
    }

    public static Rational div(Rational r1, Rational r2){
        return new Rational(r1.n * r2.d, r1.d * r2.n);
    }

    public int getN(){
        return n;
    }

    public int getD(){
        return d;
    }

    /*public Rational addInPlace(Rational r){
        n = n * r.d + d * r.n;
        d = d * r.d;
        return new Rational(n, d);
    }

    public Rational subInPlace(Rational r){
        n = n * r.d - d * r.n;
        d = d * r.d;
        return new Rational(n, d);
    }

    public Rational mulInPlace(Rational r){
        n *= r.n;
        d *= r.d;
        return new Rational(n, d);
    }

    public Rational divInPlace(Rational r){
        n *= r.d;
        d *= r.n;
        return new Rational(n, d);
    }*/
}
