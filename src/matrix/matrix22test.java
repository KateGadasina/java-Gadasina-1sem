package matrix;

import java.util.Arrays;

public class matrix22test {
    public static void main(String[] args) {
        matrix22 new_matrix = new matrix22(1, 2, 3, 4);
        System.out.println(new_matrix.a);

        var m_new = new matrix22(1,2,3,4);
        printTable(m_new.matrix(2,3,4,5));


        var m = new matrix22(1,2,3,4);
        System.out.println(m.matr(m));

        System.out.println(m.discr(m));

        printTable(m.getM());
        System.out.println(new_matrix.toString());

        var m_6 = new matrix22(3536, 55, 86, 546578);
        m_6.print();

        m_6.add(m_6);

        var m_8 = new matrix22(5,6,7,8);
        System.out.println(m_8.mul(m_8));

    }

    public static void printTable(int[][] a){
        for (int i = 0; i < a.length; i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

}
