package matrix;

public class matrix22 {
    int a;
    int b;
    int c;
    int d;

    public matrix22(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int[][] matrix(int a, int b, int c, int d){
        int[][] m = new int[][]{
            {a, b},
            {c, d}
        };
        return m;
    }

    public int matr(matrix22 m){
        int matr = m.a + m.d;
        return matr;
    }

    public int discr(matrix22 m){
        int discr = m.a * m.d - m.b * m.c;
        return discr;
    }

    public int[][] getM(){
        int[][] m =new int[][]{{a, b}, {c, d}};
            return m;
    }

    public String toString(){
        String str = String.format("%d %d %d %d", a, b, c, d);
        return str;
    }

    public void print(){
        int[][] m = new int[][]{{a, b}, {c, d}};
        int max = 0;
        for (int[] q : m ){
            for (int x : q){
                if (x > max)
                    max = x;
            }
        }
        int tmp = 3;
        while (max / 10 != 0){
            tmp++;
            max /= 10;
        }
        for (int[] q : m){
            for (int x : q){
                System.out.printf("%" + tmp + "d", x);
            }
            System.out.println();
        }
    }

    public void add(matrix22 m) {
        m.a = a;
        m.b = b;
        m.c = c;
        m.d = d;
        System.out.println(m);
    }

    public matrix22 mul(matrix22 q){
        matrix22 m = new matrix22(1,2,3,4);
        int a1 = 1 * q.a + 2 * q.c;
        int b1 = 1 * q.b + 2 * q.d;
        int c1 = 3 * q.a + 4 * q.c;
        int d1 = 3 * q.b + 4 * q.d;

        matrix22 m_new = new matrix22(a1, b1, c1, d1);
        return m_new;
    }

}
