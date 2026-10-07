public class atividade {
public static void main(String[] args) {

    int[] a = {1, 2, 3, 4};
    int[] b = {3, 4, 5, 6};
    int[] u = new int[8];

    int tamU = uniao(a, a.length, b, b.length, u);

    System.out.println("A) União:");
    for (int i = 0; i < tamU; i++) {
        System.out.print(u[i] + " ");
    }


    // B) Ordenação
    int[] v1 = {5, 2, 8, 1, 3};

    ordenar(v1, v1.length);

    System.out.println("\n\nB) Ordenação:");
    for (int i = 0; i < v1.length; i++) {
        System.out.print(v1[i] + " ");
    }


    int[] v2 = {5, 2, 5, 3, 3, 8, 3, 8, 2};
    int[] vsr = new int[v2.length];

    int tamVSR = gerarVetorSemRepeticao(v2, v2.length, vsr);

    System.out.println("\n\nC) Sem repetição:");
    for (int i = 0; i < tamVSR; i++) {
        System.out.print(vsr[i] + " ");
    }


    int[] v3 = {1, 2, 3, 4, 5};

    rotacionar(v3, v3.length, 2);

    System.out.println("\n\nD) Rotação k = 2:");
    for (int i = 0; i < v3.length; i++) {
        System.out.print(v3[i] + " ");
    }


    int[] v4 = {1, 2, 3, 4, 5};

    rotacionar(v4, v4.length, -1);

    System.out.println("\n\nD) Rotação k = -1:");
    for (int i = 0; i < v4.length; i++) {
        System.out.print(v4[i] + " ");
    }
}
   
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


    //b
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


    //c
    public static int gerarVetorSemRepeticao(
            int[] v, int tamV, int[] vsr) {

        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {

            if (!existe(vsr, tamVSR, v[i])) {

                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }

        return tamVSR;
    }


    //funcao para inverter leitor
    public static void inverter(int[] v, int inicio, int fim) {

        while (inicio < fim) {

            int aux = v[inicio];
            v[inicio] = v[fim];
            v[fim] = aux;

            inicio++;
            fim--;
        }
    }


    //d
    public static void rotacionar(int[] v, int tam, int k) {

        if (tam == 0) {
            return;
        }

        k = k % tam;

        
        if (k < 0) {
            k = k + tam;
        }

        inverter(v, 0, k - 1);

        inverter(v, k, tam - 1);

        // Inverte o vetor inteiro
        inverter(v, 0, tam - 1);
    }
}