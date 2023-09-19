package com.mycompany.torrehanoi;
import java.util.Scanner;
import java.util.Random;

public class TorreHanoi {
    private static Pilha torre1;
    private static Pilha torre2;
    private static Pilha torre3;
    private static int tamanhoPilha;
    private static int escolhaOrdem;
    private static final int[] TAMANHOS_VALIDOS = {3, 5, 7, 8};

    public static void main(String[] args) {
        Integer contadorMovimentos = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tamanho das pilhas (3, 5, 7 ou 8): ");

        do {
            tamanhoPilha = scanner.nextInt();
        } while (!tamanhoValido(tamanhoPilha));
        torre1 = new Pilha("torre 1");
        torre2 = new Pilha("torre 2");
        torre3 = new Pilha("torre 3");
        torre1 = preencherComNumerosAleatorios();
        

        //ordenarPilhaDecrescente(torre1);

        imprimirPilhas(torre1, torre2, torre3);
        imprimirMenu();

        

        while (true) {
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("Jogo encerrado.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Escolha um modo de jogo: [1]torre crescente [2]torre decrescente");
                    int n = scanner.nextInt();
                    escolhaOrdem = n;
                    if (!verificarPilhasOrdenadas(torre1, torre2, torre3)) {
                        moverDisco(contadorMovimentos);
                    }
                    break;
                case 2:
                    System.out.println("Solução automática iniciada.");
                    resolucaoAutomatica(tamanhoPilha, torre1, torre3, torre2);
                    System.out.println("Solução automática concluída.");
                    imprimirPilhas(torre1, torre2, torre3);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor digite de novo: ");
            }
        }
    }
    public static boolean tamanhoValido(int tamanho) {
        for (int validSize : TAMANHOS_VALIDOS) {
            if (tamanho == validSize) {
                return true;
            }
        }
        System.out.println("Tamanho inválido. Escolha entre 3, 5, 7 ou 8.");
        return false;
    }

    public static void moverDisco(Integer contadorMovimentos) {
        if (!verificarPilhasOrdenadas(torre1, torre2, torre3)) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o número da torre de origem (1, 2 ou 3): ");
            int origem = scanner.nextInt();
            Pilha pilhaOrigem = obterPilhaPorNumero(origem);

            System.out.print("Digite o número da torre de destino (1, 2 ou 3): ");
            int destino = scanner.nextInt();
            Pilha pilhaDestino = obterPilhaPorNumero(destino);

            try {
                int objetoMovido = pilhaOrigem.remover();
                pilhaDestino.inserir(objetoMovido);
                contadorMovimentos++;
                imprimirPilhas(torre1, torre2, torre3);
                moverDisco(contadorMovimentos);

                // Verificar a vitória após cada movimento
                if (torre3.tamanho() == tamanhoPilha) {
                    System.out.println("Parabéns! Você venceu com " + contadorMovimentos + " movimentos.");
                    System.exit(0);
                }
            } catch (NullPointerException e) {
                System.out.println("Escolha outra pilha de origem pois esta está vazia :) /n");
                moverDisco(contadorMovimentos);
            }
        } else {
            System.out.println("O jogo foi vencido com " + contadorMovimentos + " movimentos.");
        }
    }

    public static Pilha preencherComNumerosAleatorios() {
        Random random = new Random();
        Pilha pilha = new Pilha();

        for (int i = 0; i < tamanhoPilha; i++) {
            int numeroAleatorio = random.nextInt(101);
            pilha.inserir(numeroAleatorio);
        }
        return pilha;
    }

    public static void imprimirPilhas(Pilha p1, Pilha p2, Pilha p3) {
        System.out.println("Pilha 1: ");
        p1.imprimir();

        System.out.println("Pilha 2: ");
        p2.imprimir();

        System.out.println("Pilha 3: ");
        p3.imprimir();
    }

    public static void imprimirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("0 - Sair do jogo");
        System.out.println("1 - Movimentar");
        System.out.println("2 - Solução automática");
    }

    public static Pilha obterPilhaPorNumero(int numero) {
        switch (numero) {
            case 1:
                return torre1;
            case 2:
                return torre2;
            case 3:
                return torre3;
            default:
                return null;
        }
    }

    public static Boolean verificarPilhasOrdenadas(Pilha pilha1, Pilha pilha2, Pilha pilha3) {
        switch (escolhaOrdem) {
            case 1:
                if (pilha1.vitoria_crescente(tamanhoPilha) || pilha2.vitoria_crescente(tamanhoPilha) || pilha3.vitoria_crescente(tamanhoPilha)) {
                    return true;
                }
                return false;

            case 2:
                if (pilha1.vitoria_decrescente(tamanhoPilha) || pilha2.vitoria_decrescente(tamanhoPilha) || pilha3.vitoria_decrescente(tamanhoPilha)) {
                    return true;
                }
                return false;

            default:
                return false;
        }
    }

    public static void resolucaoAutomatica(int n, Pilha origem, Pilha destino, Pilha auxiliar) {
    if (n > 0) {
        // Move n-1 discos da origem para a auxiliar usando o destino como auxiliar
        resolucaoAutomatica(n - 1, origem, auxiliar, destino);

        // Move o disco n da origem para o destino
        int disco = origem.remover();
        destino.inserir(disco);
        imprimirMovimento(origem, destino, disco);

        // Move os n-1 discos da auxiliar para o destino usando a origem como auxiliar
        resolucaoAutomatica(n - 1, auxiliar, destino, origem);
    }
}

public static void imprimirMovimento(Pilha origem, Pilha destino, int disco) {
    System.out.println("Mover disco " + disco + " de " + origem.getNome() + " para " + destino.getNome());
}
    
}

