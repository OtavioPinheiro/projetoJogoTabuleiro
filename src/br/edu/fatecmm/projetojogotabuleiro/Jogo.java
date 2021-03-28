package br.edu.fatecmm.projetojogotabuleiro;

import java.util.Scanner;

public class Jogo {
  private Tabuleiro tabuleiro = new Tabuleiro();
  private int numero = 0;
  private int contador = 0;

  public void pedeNumero() {
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("Escolha um número de 1 a 100: ");
      try {
        this.numero = scanner.nextInt();
        if (this.numero < 1 || this.numero > 100) {
          throw new Exception();
        }
      }
      catch (Exception e) {
        System.out.println("Por favor digite um valor válido!");
      }
    } while (this.numero == 0);
  }

  public boolean verificaSeGanhou() {
    this.contador = 0;
    this.tabuleiro.setTab();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (this.numero == this.tabuleiro.getTab()[i][j]) {
          this.contador++;
        }
      }
    }
    if (this.contador >= 3) {
      return true;
    }
    else {
      return false;
    }
  }

  public void premios(boolean ganhou) {
    if (ganhou) {
      System.out.println("*#*#*#*# Parabéns!!! *#*#*#*#*");
      System.out.println("Você é o mais novo sortudo!!");
      if (this.contador > 3) {
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
