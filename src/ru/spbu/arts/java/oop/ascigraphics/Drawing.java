package ru.spbu.arts.java.oop.ascigraphics;

import java.util.Arrays;

public class Drawing {
    int line;
    int column;
    char symb;

    public Drawing(int line, int column, char symb) {
        this.line = line;
        this.column = column;
        this.symb = symb;
    }

    public void print(){
        char[][] dr =new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++)
                dr[i][j] = symb;
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }

    public void setPoint(int x,int y, char c){
        char[][] dr =new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (i == x - 1 && j == y - 1)
                    dr[i][j] = c;
                else dr[i][j] = symb;
            }
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }

    public void drawVerticalLine(int y, char c){
        char[][] dr = new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (j == y - 1)
                    dr[i][j] = c;
                else dr[i][j] = symb;
            }
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }

    public void drawHorizontalLine(int x, char c){
        char[][] dr = new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if (i == x - 1)
                    dr[i][j] = c;
                else dr[i][j] = symb;
            }
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char c){
        char[][] dr = new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if ((i == x1 - 1 || i == x2 - 1) && j >= y1 - 1 && j <= y2 - 1)
                    dr[i][j] = c;
                else if (i >= x1 - 1 && i <= x2 - 1 && (j == y2 - 1 || j == y1 - 1))
                    dr[i][j] = c;
                else dr[i][j] = symb;
            }
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }

    public void drawCircle(int x, int y, int r, char c){
        char[][] dr = new char[line][column];
        if (r + x > line || r + y > column)
            System.out.println("Error!");
        else {
            for (int i = 0; i < line; i++)
                for (int j = 0; j < column; j++){
                    if (((i - x + 1) * (i - x + 1) + ((j - y + 1) * (j - y + 1))) <= (r - 1) * (r - 1))
                        dr[i][j] = c;
                    else dr[i][j] = symb;
                }
            for (int i = 0; i < line; i++)
                System.out.println(Arrays.toString(dr[i]));
        }
    }

    public void draw(int x, int y, Drawing d){
        char[][] dr = new char[line][column];
        for (int i = 0; i < line; i++)
            for (int j = 0; j < column; j++){
                if ((i >= x - 1 && i <= x + d.line - 2) && (j >= y - 1 && j <= y + d.column - 2)){
                    for (int i1 = 0; i1 < d.line; i1++)
                        for (int j1 = 0; j1 < d.column; j1++)
                            dr[i][j] = d.symb;
                }
                else dr[i][j] = symb;
            }
        for (int i = 0; i < line; i++)
            System.out.println(Arrays.toString(dr[i]));
    }
}
