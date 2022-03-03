package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        Drawing new_dr = new Drawing(20, 30, '.');
        System.out.println(new_dr.line);

        var dr_1 = new Drawing(4, 5, '.');
        dr_1.print();

        var dr_2 = new Drawing(3, 3, '#');
        dr_2.print();

        System.out.println("\nsetPoint:\n");
        dr_1.setPoint(3,2,'*');

        System.out.println("\ndrawVerticalLine:\n");
        dr_1.drawVerticalLine(4,'*');
        dr_2.drawVerticalLine(1,'?');

        System.out.println("\ndrawHorizontalLine:\n");
        dr_1.drawHorizontalLine(1,'*');
        dr_2.drawHorizontalLine(2,'?');

        System.out.println("\ndrawRectangle\n");
        dr_1.drawRectangle(2,2,4,5,'$');
        dr_2.drawRectangle(1,2,3,3,'%');

        var dr_3 = new Drawing(6,4, '-');
        dr_3.drawRectangle(1,1,3,4,'|');

        System.out.println("\ndrawCircle\n");

        var dr_4 = new Drawing(20, 20, '.');
        dr_4.drawCircle(10, 10, 7, '*');
        dr_4.drawCircle(10, 10, 11, '*');

        System.out.println("\ndraw\n");
        dr_4.draw(5, 4, dr_2);
    }
}
