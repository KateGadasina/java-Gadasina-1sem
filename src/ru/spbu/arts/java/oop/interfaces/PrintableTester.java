package ru.spbu.arts.java.oop.interfaces;

import ru.spbu.arts.java.oop.ascigraphics.Drawing;

public class PrintableTester {
    public static void main(String[] args) {
        Printable drPrint = new Drawing(3,4, '*');
        drPrint.print();

        Printable pl = new PrintableLetter('x', 10);
        pl.print();

        Printable ps = new PrintableString("qwerty");
        ps.print();

        Printable a = new Printable() {
            @Override
            public void print() {
                System.out.println("Анонимный класс!");
            }
        };

        Printable lamb = () -> System.out.println("Лямбда-выражение!");

        Printable[] prArray= new Printable[] {drPrint, pl, ps, a, lamb};

        System.out.println("\nPrintable[]:\n");
        for (int x = 0; x < prArray.length; x++){
            prArray[x].print();
        }
    }
}
