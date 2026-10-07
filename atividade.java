// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class atividade {
   public atividade() {
   }

   public static void main(String[] var0) {
      int[] var1 = new int[]{1, 2, 3, 4};
      int[] var2 = new int[]{3, 4, 5, 6};
      int[] var3 = new int[8];
      int var4 = uniao(var1, var1.length, var2, var2.length, var3);
      System.out.println("A) União:");

      for(int var5 = 0; var5 < var4; ++var5) {
         System.out.print(var3[var5] + " ");
      }

      int[] var12 = new int[]{5, 2, 8, 1, 3};
      ordenar(var12, var12.length);
      System.out.println("\n\nB) Ordenação:");

      for(int var6 = 0; var6 < var12.length; ++var6) {
         System.out.print(var12[var6] + " ");
      }

      int[] var13 = new int[]{5, 2, 5, 3, 3, 8, 3, 8, 2};
      int[] var7 = new int[var13.length];
      int var8 = gerarVetorSemRepeticao(var13, var13.length, var7);
      System.out.println("\n\nC) Sem repetição:");

      for(int var9 = 0; var9 < var8; ++var9) {
         System.out.print(var7[var9] + " ");
      }

      int[] var14 = new int[]{1, 2, 3, 4, 5};
      rotacionar(var14, var14.length, 2);
      System.out.println("\n\nD) Rotação k = 2:");

      for(int var10 = 0; var10 < var14.length; ++var10) {
         System.out.print(var14[var10] + " ");
      }

      int[] var15 = new int[]{1, 2, 3, 4, 5};
      rotacionar(var15, var15.length, -1);
      System.out.println("\n\nD) Rotação k = -1:");

      for(int var11 = 0; var11 < var15.length; ++var11) {
         System.out.print(var15[var11] + " ");
      }

   }

   public static boolean existe(int[] var0, int var1, int var2) {
      for(int var3 = 0; var3 < var1; ++var3) {
         if (var0[var3] == var2) {
            return true;
         }
      }

      return false;
   }

   public static int uniao(int[] var0, int var1, int[] var2, int var3, int[] var4) {
      int var5 = 0;

      for(int var6 = 0; var6 < var1; ++var6) {
         if (!existe(var4, var5, var0[var6])) {
            var4[var5] = var0[var6];
            ++var5;
         }
      }

      for(int var7 = 0; var7 < var3; ++var7) {
         if (!existe(var4, var5, var2[var7])) {
            var4[var5] = var2[var7];
            ++var5;
         }
      }

      return var5;
   }

   public static void ordenar(int[] var0, int var1) {
      for(int var2 = 1; var2 < var1; ++var2) {
         int var3 = var0[var2];

         int var4;
         for(var4 = var2 - 1; var4 >= 0 && var0[var4] > var3; --var4) {
            var0[var4 + 1] = var0[var4];
         }

         var0[var4 + 1] = var3;
      }

   }

   public static int gerarVetorSemRepeticao(int[] var0, int var1, int[] var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         if (!existe(var2, var3, var0[var4])) {
            var2[var3] = var0[var4];
            ++var3;
         }
      }

      return var3;
   }

   public static void inverter(int[] var0, int var1, int var2) {
      while(var1 < var2) {
         int var3 = var0[var1];
         var0[var1] = var0[var2];
         var0[var2] = var3;
         ++var1;
         --var2;
      }

   }

   public static void rotacionar(int[] var0, int var1, int var2) {
      if (var1 != 0) {
         var2 %= var1;
         if (var2 < 0) {
            var2 += var1;
         }

         inverter(var0, 0, var2 - 1);
         inverter(var0, var2, var1 - 1);
         inverter(var0, 0, var1 - 1);
      }
   }
}
