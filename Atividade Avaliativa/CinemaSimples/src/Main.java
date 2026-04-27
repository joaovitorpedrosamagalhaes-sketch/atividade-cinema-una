import java.util.Scanner;

public class Main {

    //Deus nos ajude rs
    static class Cinema {
        int[][] sala = new int[6][8]; //para definirmos o tamanho da nossa matrizs

        void reservar(int f, int a) {
            if (sala[f - 1][a - 1] == 0) {
                sala[f - 1][a - 1] = 1;
                System.out.println("Assento já reservado Glender, procure outro! : !"); //pra vc em especial professor
            } else {
                System.out.println("Assento já esta ocupado!");
            }
        }

        void cancelar(int f, int a) { // f vai indicar fileira / a vai indicar assentos
            if (sala[f - 1][a - 1] == 1) {
                sala[f - 1][a - 1] = 0;
                System.out.println("Reserva cancelada!");
            } else {
                System.out.println("Assento ja esta livre!");
            }
        }

        void mostrarMapa() {
            System.out.println("\nMapa da sala:");
            for (int i = 0; i < 6; i++) {
                System.out.print("Fileira " + (i + 1) + ": ");
                for (int j = 0; j < 8; j++) {
                    System.out.print(sala[i][j] + " ");
                }
                System.out.println();
            }
        }

        void estatisticas() {
            int livres = 0;
            int ocupados = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
                    if (sala[i][j] == 0) livres++;
                    else ocupados++;
                }
            }

            int total = livres + ocupados;
            double perc = (ocupados * 100.0) / total;

            System.out.println("Assentos livres: " + livres);
            System.out.println("Assentos ocupados: " + ocupados);
            System.out.printf("Percentual de ocupaçao: %.2f%%\n", perc);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema();

        int opcao;

        do {
            System.out.println("\n1. Reservar assento");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Exibir mapa");
            System.out.println("4. Exibir quantidade de assentos livres e ocupados");
            System.out.println("5. Encerrar");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.print("Fileira (1-6): ");
                int f = sc.nextInt();

                System.out.print("Assento (1-8): ");
                int a = sc.nextInt();

                cinema.reservar(f, a);

            } else if (opcao == 2) {
                System.out.print("Fileira: ");
                int f = sc.nextInt();

                System.out.print("Assento: ");
                int a = sc.nextInt();

                cinema.cancelar(f, a);

            } else if (opcao == 3) {
                cinema.mostrarMapa();

            } else if (opcao == 4) {
                cinema.estatisticas();

            } else if (opcao == 5) {
                System.out.println("Encerrando...");

            } else {
                System.out.println("Opção invalida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}