package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        Drawing drNew = new Drawing(7, 13, '.');

        var dr1 = new Drawing(4, 5, '.');
        var dr11 = new Drawing(4, 5, '.');
        drNew.print();

        var dr2 = new Drawing(3, 3, '#');
        var dr22 = new Drawing(3, 3, '#');
        dr2.print();

        System.out.println("\nsetPoint:\n");
        drNew.setPoint(3,2,'*');
        drNew.print();

        System.out.println("\ndrawVerticalLine:\n");
        dr1.drawVerticalLine(4,'*');
        dr1.print();

        System.out.println("\ndrawHorizontalLine:\n");
        dr1.drawHorizontalLine(2,'?');
        dr1.print();

        System.out.println("\ndrawRectangle\n");
        dr11.drawRectangle(2,2,3,5,'$');
        dr22.drawRectangle(1,2,3,3,'%');
        dr11.print();
        dr22.print();

        var dr3 = new Drawing(6,4, '-');
        dr3.drawRectangle(1,1,3,4,'|');
        dr3.print();

        System.out.println("\ndrawCircle\n");

        var dr4 = new Drawing(20, 20, '.');
        dr4.drawCircle(10, 10, 7, '*');
        dr4.print();
        dr4.drawCircle(10, 10, 11, '*');

        System.out.println("\ndrawHouse\n");
        var dr44 = new Drawing(20, 20, '.');
        dr44.drawHorizontalLine(3, '@');
        dr44.drawVerticalLine(4, '%');
        dr44.drawVerticalLine(17, '%');
        dr44.drawRectangle(4, 4, 17, 17, '%');
        dr44.drawCircle(8, 10, 4, '*');
        dr44.drawHorizontalLine(1, '.');
        dr44.drawHorizontalLine(2, '.');
        dr44.drawHorizontalLine(20, '.');

        dr44.print();
    }
}
