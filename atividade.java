public class atividade {
//funcao auxiliar//
    public static boolean existe(int[] v, int tam, int valor) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == valor) {
                return true;
            }
        }
        return false;
    }

    //A
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i++) {
            if (!existe(u, tamU, a[i])) {
                u[tamU] = a[i];
                tamU++;
            }
        }

        for (int i = 0; i < tamB; i++) {
            if (!existe(u, tamU, b[i])) {
                u[tamU] = b[i];
                tamU++;
            }
        }

        return tamU;
    }

    //B
    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int atual = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > atual) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = atual;
        }
    }

    //C
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {
            if (!existe(vsr, tamVSR, v[i])) {
                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }

        return tamVSR;
    }

    //funcao auxiliar
    public static void inverter(int[] v, int inicio, int fim) {
        while (inicio < fim) {
            int aux = v[inicio];
            v[inicio] = v[fim];
            v[fim] = aux;

            inicio++;
            fim--;
        }
    }
//D
    public static void rotacionar(int[] v, int tam, int k) {
        if (tam == 0) {
            return;
        }

        k = k % tam;

        if (k < 0) {
            k += tam;
        }

        inverter(v, 0, k - 1);
        inverter(v, k, tam - 1);
        inverter(v, 0, tam - 1);
    }

    //tempo de prova: 2horas
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        int tamA = 4;

        int[] b = {3, 4, 5, 6};
        int tamB = 4;

        int[] u = new int[tamA + tamB];

        int tamU = uniao(a, tamA, b, tamB, u);

        System.out.println("a)");
        for (int i = 0; i < tamU; i++) {
            System.out.print(u[i] + " ");
        }


        {
            int[] v = {5, 2, 8, 1, 3};
            int n = 5;

            ordenar(v, n);

            System.out.println("\n\nb)");
            for (int i = 0; i < n; i++) {
                System.out.print(v[i] + " ");
            }
        }


        {
            int[] v = {5, 2, 5, 3, 3, 8, 3, 8, 2};
            int tamV = 9;
            int[] vsr = new int[tamV];

            int tamVSR = gerarVetorSemRepeticao(v, tamV, vsr);

            System.out.println("\n\nc)");
            for (int i = 0; i < tamVSR; i++) {
                System.out.print(vsr[i] + " ");
            }
        }


        {
            int[] v = {1, 2, 3, 4, 5};
            int tam = 5;
            int k = 2;

            rotacionar(v, tam, k);

            System.out.println("\n\nd) exemplo 1");
            for (int i = 0; i < tam; i++) {
                System.out.print(v[i] + " ");
            }
        }

        {
            int[] v = {1, 2, 3, 4, 5};
            int tam = 5;
            int k = -1;

            rotacionar(v, tam, k);

            System.out.println("\nd) exemplo 2");
            for (int i = 0; i < tam; i++) {
                System.out.print(v[i] + " ");
            }
        }
    }
}