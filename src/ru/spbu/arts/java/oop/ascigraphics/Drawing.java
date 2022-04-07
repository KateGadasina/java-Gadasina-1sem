package ru.spbu.arts.java.oop.ascigraphics;

import ru.spbu.arts.java.oop.interfaces.Printable;

import java.util.Arrays;

public class Drawing implements Printable {
    private int line;
    private int column;
    private char[][] dr;

    public Drawing(int line, int column, char symb) {
        this.line = line;
        this.column = column;
        char[][] drNew = new char[line][column];
        this.dr = drNew;
        for (char[] x: drNew)
            Arrays.fill(x, symb);
    }

    public void print(){
        for (int x = 0; x < line; x++) {
            for (int y = 0; y < column; y++)
                System.out.print(dr[x][y]);
            System.out.println();
        }
    }

    public void setPoint(int x,int y, char c){
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (i == x - 1 && j == y - 1)
                    dr[i][j] = c;
            }
    }

    public void drawVerticalLine(int y, char c){
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (j == y - 1)
                    dr[i][j] = c;
            }
    }

    public void drawHorizontalLine(int x, char c){
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (i == x - 1)
                    dr[i][j] = c;
            }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char c){
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (i >= x1 - 1 && i <= x2 - 1 && j >= y1 - 1 && j <= y2 - 1)
                    dr[i][j] = c;
            }
    }

    public void drawCircle(int x, int y, int r, char c){
        if (r + x > line || r + y > column)
            System.out.println("Error!");
        else {
            for (int i = 0; i < line; i++)
                for (int j = 0; j < column; j++){
                    if (((i - x + 1) * (i - x + 1) + ((j - y + 1) * (j - y + 1))) <= (r - 1) * (r - 1))
                        dr[i][j] = c;
                }
        }
    }
/*
    public void draw(int x, int y, Drawing d){

        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if ((i >= x - 1 && i <= x + d.line - 2) && (j >= y - 1 && j <= y + d.column - 2)){
                    for (int i1 = 0; i1 < d.line; i1++)
                        for (int j1 = 0; j1 < d.column; j1++) {
                            dr[x][y] =
                        }
                }
            }
    }*/
}
