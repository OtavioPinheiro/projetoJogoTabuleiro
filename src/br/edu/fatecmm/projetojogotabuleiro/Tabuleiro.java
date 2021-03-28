package br.edu.fatecmm.projetojogotabuleiro;

import java.security.SecureRandom;
import java.util.Random;

public class Tabuleiro {
//    Random random = new Random(); //não é gera números realmente randômicos.
  SecureRandom secureRandom = new SecureRandom();
  private int[][] tab = new int[10][10];
  private int valor;

  private int geraValores() {
    /**
     * Para saber mais sobre os métodos de gerar números randômicos acesse:
     * https://stackoverflow.com/questions/738629/math-random-versus-random-nextintint
     * https://www.geeksforgeeks.org/random-vs-secure-random-numbers-java/
     */
//    return this.valor = (int)Math.round(Math.random() * 100); //usa o dobro do processamento.

//    return this.valor = random.nextInt(100);

    return this.valor = secureRandom.nextInt(100) + 1;
  }

  public void setTab() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        this.tab[i][j] = geraValores();
      }
    }
  }

  public int[][] getTab() {
    return this.tab;
  }

  private String formatarNumero(int numero) {
    if (numero < 10) {
      return "00"+numero;
    }
    else if (numero >= 10 && numero < 100) {
      return "0"+numero;
    }
    else {
      return ""+numero;
    }
  }

  public void exibeTab() {
    for(int i = 0; i < 10; i++) {
      for(int j = 0; j < 10; j++) {
        if (j == 0 || j % 10 == 0) {
          System.out.printf("| %s", formatarNumero(this.tab[i][j]));
        }
        else if (j % 9 == 0) {
          System.out.printf("%s |\n", formatarNumero(this.tab[i][j]));
        }
        else {
          System.out.printf(" %s ", formatarNumero(this.tab[i][j]));
        }
      }
    }
  }
}
