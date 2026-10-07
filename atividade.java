public class atividade {

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {2, 3, 4};

        int[] u = new int[6];

        for (int i = 0; i < a.length; i++) {
            u[i] = a[i];
        }

        int tamU = a.length;

        for (int i = 0; i < b.length; i++) {

            boolean repetido = false;

            for (int j = 0; j < tamU; j++) {

                if (u[j] == b[i]) {
                    repetido = true;
                }
            }

            if (repetido == false) {
                u[tamU] = b[i];
                tamU++;
            }
        }

        for (int i = 0; i < tamU; i++) {
            System.out.print(u[i] + " ");
        }
    }
}
