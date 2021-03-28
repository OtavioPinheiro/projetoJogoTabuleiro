package br.edu.fatecmm.projetojogotabuleiro;

public class Menu {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.bemvindo();
        menu.infos();
        menu.regras();
        menu.inicia();
        menu.fim();
    }

    private void bemvindo() {
        System.out.println("############################");
        System.out.println("Seja Bem-vindo ao Jogo Tabuleiro da Sorte");
        System.out.println("############################");
    }

    private void infos() {
        System.out.println("Para jogar esse jogo basta escolher um número entre 1 e 100.\n" +
            "Se o número escolhido por você se repetir 3 ou mais vezes no tabuleiro 10x10, você ganhará prêmios.\n" +
            "Repetições --------- Prêmios\n" +
            "3 vezes    --------- R$1.000,00\n" +
            "4 ou mais  --------- R$4.000,00");
    }

    private void regras() {
        System.out.println("********REGRAS**********");
        System.out.println("1. Não é permitido escolher mais de um par de números por vez.");
        System.out.println("2. Só serão aceitos números e eles devem estar entre 1 e 100.");
        System.out.println("3. Toda vez que um par de números for escolhido, o tabuleiro será revelado\n para que o jogador" +
            "possa conferir os números. \nSe o jogador quiser jogar novamente, novos números serão gerados.");
    }

    private void inicia() {
        Jogo jogo = new Jogo();
        boolean ganhou;
        boolean outroJogo;

        do {
            jogo.pedeNumero();
            ganhou = jogo.verificaSeGanhou();
            jogo.exibeTabuleiro();
            jogo.premios(ganhou);
            outroJogo = jogo.jogarNovamente();
        } while (outroJogo == true);
    }

    private void fim() {
        System.out.println("######### Obrigado por jogar o Jogo Tabuleiro da Sorte! ###########");
        System.out.println("Que a sorte sempre esteja com você!");
    }
}
