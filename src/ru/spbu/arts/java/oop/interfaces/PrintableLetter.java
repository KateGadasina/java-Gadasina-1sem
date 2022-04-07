package ru.spbu.arts.java.oop.interfaces;

public class PrintableLetter implements Printable{
    private char symb;
    private int x;

    public PrintableLetter(char symb, int x){
        this.symb = symb;
        this.x = x;
    }

    @Override
    public void print(){
        String str = "";
        for (int i = 0; i < x; i++)
            str += symb;
        System.out.println(str);
    }
}
