import java.util.LinkedList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // int M1[][] = { { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 } };

        // mostrarM1(M1);

        // System.out.println("");
        // System.out.println("");

        Matriz A = new Matriz(3);
        A.setValue(0, 0, 0);
        A.setValue(0, 1, 1);
        A.setValue(0, 2, 5);
        A.setValue(1, 0, 3);
        A.setValue(1, 1, -6);
        A.setValue(1, 2, 9);
        A.setValue(2, 0, 2);
        A.setValue(2, 1, 6);
        A.setValue(2, 2, 1);

        System.out.println("Matriz A: \n" + A);

        System.out.println("Determinante: " + Matriz.determinante(A));

        // ------------------------

        // LinkedList<Integer> mochila = new LinkedList();
        // LinkedList<Integer> l2 = new LinkedList();
        // l2.add(8);
        // l2.add(3);
        // l2.add(5);
        // l2.add(9);
        // l2.add(2);
        // l2.add(7);

        // mochilaPrimo(l2, mochila, 10, 1);

        // System.out.println(esPrimo(9));
    }

    public static void mochila(LinkedList<Integer> l1, LinkedList<Integer> l2, int max, int pos) {
        int sum = suma(l2);
        if (sum > max) {
            return;
        }
        System.out.println(l2);

        for (int i = pos; i < l1.size(); i++) {
            l2.add(l1.get(i));
            mochila(l1, l2, max, i + 1);
            l2.removeLast();
        }
    }
// -------------------------------------------------------------------
    public static int suma(LinkedList<Integer> l1) {
        int total = 0;
        for (int elem : l1) {
            total += elem;
        }
        return total;
    }

    public static void mochilaPrimo(LinkedList<Integer> l1, LinkedList<Integer> l2, int max, int pos) {
        int sum = suma(l2);
        if (sum > max) {
            return;
        }
        if (esPrimo(l2)) {
            System.out.println(l2);
        }
        for (int i = pos; i < l1.size(); i++) {
            l2.add(l1.get(i));
            mochilaPrimo(l1, l2, max, i + 1);
            l2.removeLast();

        }
    }
// -------------------------------------------------------------
    public static boolean esPrimo(LinkedList<Integer> l1) {
        boolean b = true;
        for (int elem : l1) {
            if (!primo(elem)) {
                b = false;
            }
        }
        return b;
    }
// -----------------------------------------------------------
    public static boolean primo(int numero) {
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0)
                return false;
        }
        return true;
    }

    // -------------------------------

    private static void mostrar(int[] l1) {
        System.out.print("La lista: ");
        for (int i = 0; i < l1.length; i++) {
            System.out.print(l1[i] + "\t");
        }
    }

    private static void mostrarM1(int[][] M1) {
        System.out.println("La matriz:");
        for (int i = 0; i < M1.length; i++) {
            for (int j = 0; j < M1[i].length; j++) {
                System.out.print(M1[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void mostrarSubListas(int[] L) {
        for (int i1 = 0; i1 < L.length; i1++) {
            for (int i2 = i1; i2 < L.length; i2++) {
                mostrar(i1, i2, L);
            }
        }
    }

    private static void mostrar(int a, int b, int[] L) {
        System.out.print("\nSub lista: ");
        for (int i = a; i <= b; i++)
            System.out.print(L[i] + " ");
    }

    public static void mostrarSubMatrices(int[][] M1) {
        System.out.println("SubMatrices");

        for (int i1 = 0; i1 < M1.length; i1++) {
            for (int j1 = 0; j1 < M1[i1].length; j1++) {
                for (int i2 = i1; i2 < M1.length; i2++) {
                    for (int j2 = j1; j2 < M1[i1].length; j2++)
                        subMatris(M1, i1, j1, i2, j2);
                }
            }
        }
    }

    private static void subMatris(int[][] M1, int i1, int j1, int i2, int j2) {
        System.out.println("Sub Matris : ");
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                System.out.print(M1[i][j] + " ");
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------------

    public static class Randomico extends Random {
        /*
         * valores ramdomicos entre a y b
         */
        public int nextInt(int valorMin, int valorMax) {
            int numeroAleatorio;
            numeroAleatorio = super.nextInt(valorMax - valorMin + 1) + valorMin;
            return numeroAleatorio;
        }
    }

    public static class Matriz {
        private final int MAX_FIL;
        private final int MAX_COL;

        private int cantFil;
        private int cantColum;

        private int elemento[][];

        //-------------------------------
        public Matriz(int orden) {
            this.MAX_FIL = this.MAX_COL = 10;
            this.elemento = new int[MAX_FIL][MAX_COL];
            this.cantFil = orden;
            this.cantColum = orden;

            for (int i = 0; i < this.cantFil; i++)
                for (int j = 0; j < this.cantColum; j++)
                    this.elemento[i][j] = 0;
        }
        //-------------------------------
        public Matriz(Matriz A){
            this.MAX_FIL = this.MAX_COL = 10;
            this.elemento = new int[MAX_FIL][MAX_COL];
            this.cantFil = A.getCantFila();
            this.cantColum = A.getCantColum();
            
             for (int i = 0; i < this.cantFil; i++)
                for (int j = 0; j < this.cantColum; j++)
                    this.elemento[i][j] = A.getValue(i, j);
        }
        //-------------------------------
        public void setValueRamdon() {
            Randomico r = new Randomico();
            for (int i = 0; i < this.cantFil; i++)
                for (int j = 0; j < this.cantColum; j++)
                    this.elemento[i][j] = r.nextInt(10);
        }
        //-------------------------------
        public void setValueRamdon(int valorMin, int valorMax) {
            // hacer una exeption si "Max" no es mayor a "Min" y mayor a cero
            Randomico r = new Randomico();
            for (int i = 0; i < this.cantFil; i++)
                for (int j = 0; j < this.cantColum; j++)
                    this.elemento[i][j] = r.nextInt(valorMin, valorMax);
        }
        //-------------------------------
        public void setValue(int fila, int colum, int value) {
            this.elemento[fila][colum] = value;
        }
        //-------------------------------
        public int getValue(int fila, int colum) {
            // conviene hacer una exeption si los parametros no son menores
            // a fila o columna
            return this.elemento[fila][colum];
        }
        //-------------------------------
        public int getCantFila() {
            return this.cantFil;
        }
        //-------------------------------
        public int getCantColum() {
            return this.cantColum;
        }
        //-------------------------------
        public void eliminarFila(int fila) {
            // Si el valor fila no esta en rango, mandar exeption
            for (int k = fila + 1; k < this.cantFil; k++)
                for (int j = 0; j < this.cantColum; j++)
                    this.elemento[k - 1][j] = this.elemento[k][j];
            this.cantFil--;
        }
        //-------------------------------
        public void eliminarColumna(int colum) {
            // si el valor de columna no esta en rango, conviene hacer una exeption
            for (int h = colum + 1; h < this.cantColum; h++)
                for (int i = 0; i < this.cantFil; i++)
                    setValue(i, h - 1, getValue(i, h));
            this.cantColum--;
        }

        @Override
        public String toString() {
            String matriz = "";

            for (int i = 0; i < this.cantFil; i++) {
                for (int j = 0; j < this.cantColum; j++)
                    matriz = matriz +
                            Integer.toString(this.elemento[i][j]) +
                            "\t";
                matriz = matriz + "\n";
            }
            return matriz;
        }
//-----------------------------------------------------------------------
        private static int signo(int i, int j) {
            if (i + j % 2 == 1)
                return -1;
            return 1;
        }

        public static Matriz menor(Matriz A, int i, int j) {
            Matriz B = new Matriz(A);
            B.eliminarFila(i);
            B.eliminarColumna(j);
            return B;
        }

        /*
         * Determinante de la matriz A
         */
        public static int determinante(Matriz A) {
            int n = A.getCantFila();
            if (n == 1) // si el orden es 1
                return A.getValue(0, 0);
            int suma = 0;
            int i = // Se escoje una fila cualquiera
                    (new Randomico()).nextInt(n);
            // desarrollando el metodo a lo largo de la fila
            for (int j = 0; j < n; j++)
                suma += signo(i, j) * A.getValue(i, j) *
                        determinante(menor(A, i, j));
            return suma;
        }

    }

}
