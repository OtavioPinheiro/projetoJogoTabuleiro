package br.edu.fatecmm.projetojogotabuleiro;

import java.util.Scanner;

public class Jogo {
  private Tabuleiro tabuleiro = new Tabuleiro();
  private int[] numero = new int [2];
  private int[] contador = new int [2];

  public void pedeNumero() {
    for (int i = 0; i < 2; i++) {
      do {
        this.numero[i] = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Escolha o %dº número de 1 a 100: ", i + 1);
        try {
          this.numero[i] = scanner.nextInt();
          if (this.numero[i] < 1 || this.numero[i] > 100) {
            throw new Exception();
          }
        }
        catch (Exception e) {
          System.out.println("Por favor digite um valor válido!");
        }
      } while (this.numero[i] == 0);
    }
  }

  public boolean verificaSeGanhou() {
    this.tabuleiro.setTab();
    boolean[] verifica = new boolean[2];
    boolean ganhou = false;

    for (int h = 0; h < 2; h++) {
      this.contador[h] = 0;
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          if (this.numero[h] == this.tabuleiro.getTab()[i][j]) {
            this.contador[h]++;
          }
        }
      }
      if (this.contador[h] >= 3) {
        verifica[h] = true;
      }
      else {
        verifica[h] = false;
      }
    }

    for (int i = 0; i < 2; i++) {
      if (verifica[i] == true) {
        ganhou = true;
      }
    }

    return ganhou;
  }

  public void premios(boolean ganhou) {
    int acertos = 0;
    int numeroDaSorte = 0;
    if (this.contador[0] >= this.contador[1]) {
      acertos = this.contador[0];
      numeroDaSorte = this.numero[0];
    }
    else {
      acertos = this.contador[1];
      numeroDaSorte = this.numero[1];
    }

    if (ganhou) {
      System.out.println("*#*#*#*# Parabéns!!! *#*#*#*#*");
      System.out.println("Você é o mais novo sortudo!!");
      System.out.printf("O seu número da sorte foi %d\n", numeroDaSorte);
      System.out.printf("Total de acertos foi %d\n", acertos);
      if (acertos > 3) {
        System.out.println("Retire seu prêmio de R$4.000,00 no caixa!");
      }
      else {
        System.out.println("Retire seu prêmio de R$1.000,00 no caixa!");
      }
    }
    else {
      System.out.println("Que pena! Não foi desta vez... =(");
    }
  }

  public boolean jogarNovamente() {
    String resp = new String();
    Scanner scanner = new Scanner(System.in);
    boolean deNovo = false;
    boolean ok = true;

    do {
      System.out.println("Deseja jogar novamente?(S/N)");
      resp = scanner.nextLine().toLowerCase();
      try {
        if (resp.length() > 1 || !resp.equals("s") && !resp.equals("n")) {
          ok = false;
          throw new Exception();
        }
        else {
          ok = true;
        }
      } catch (Exception e) {
        System.out.println("Responda apenas com S para sim ou N para não.");
      }
    } while (ok == false);

    if (resp.equals("s")) {
      return deNovo = true;
    }
    else {
      return deNovo;
    }
  }

  public void exibeTabuleiro() {
    this.tabuleiro.exibeTab();
  }
}
