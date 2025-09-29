import java.util.Scanner;
import java.util.Random;

public class OHeroiTaffeson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int pocao = 2;
        int xp = 0;
        boolean especialDisponivel = true;
        boolean defendendo = false;


        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaHeroi > 0 && vidaMonstro > 0) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");

            int escolha = sc.nextInt();

            if (escolha == 1) {
                vidaMonstro = atacar(vidaMonstro, rand);

            } else if (escolha == 2) {
                if (pocao > 0) {
                    vidaHeroi = usarPocao(vidaHeroi);
                    pocao--;
                } else {
                    System.out.println("Você não tem poções restantes!");
                }

            } else if (escolha == 3) {
                defender();
                defendendo = true;

            } else if (escolha == 4) {

                if (especialDisponivel) {
                    vidaMonstro = poderEspecial(vidaMonstro);
                    especialDisponivel = false;
                } else {
                    System.out.println("❌ O poder especial ja foi utilizado!");
                }

            } else if (escolha == 5) {
                fugir();
                sc.close();
                return;

            } else {
                System.out.println("Opção inválida!");
                continue;

            }

            // Turno do monstro

            vidaHeroi = ataqueDoMonstro(vidaHeroi, defendendo, rand);

        }
        if (vidaMonstro <= 0) {
            xp = ganharXP(rand, xp);

            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }


    public static int atacar(int vidaMonstro, Random rand) {

        int danoAtacar = rand.nextInt(4) + 8;
        boolean ataqueCritical = rand.nextInt(100) < 20;

        if (ataqueCritical) {
            danoAtacar *= 2;
            System.out.println("Dano Critico");
        }
        vidaMonstro -= danoAtacar;

        System.out.println("Taffeson atacou! e causou " + danoAtacar + " de dano");
        System.out.println("Após o ataque o monstro ficou com " + vidaMonstro + " de vida!");
        return vidaMonstro;
    }

    public static int ataqueDoMonstro(int vidaHeroi, Boolean defendendo, Random rand) {
        int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
        boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
        if (critico) {
            ataqueMonstro *= 2;
            System.out.println("💥 O monstro acertou um CRÍTICO!");
        }
        if (defendendo) {
            int reduzidoAtaque = ataqueMonstro / 2;
            ataqueMonstro = reduzidoAtaque;
            defendendo = false;
        }
        vidaHeroi -= ataqueMonstro;
        System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        return vidaHeroi;
    }

    public static int usarPocao(int vidaHeroi) {
        vidaHeroi += 15;
        if (vidaHeroi > 60) vidaHeroi = 60;
        System.out.println("Você usou uma poção e recuperou 15 de vida!");
        System.out.println("Vida de Taffeson agora é: " + vidaHeroi);
        return vidaHeroi;
    }

    public static void defender() {
        System.out.println("Tafferson se defende, reduzindo o dano em 50%");

    }

    public static void fugir() {
        System.out.println("🏃‍♂️ Taffeson decidiu fugir da batalha! O vilarejo permanecerá em perigo... moradores gritam COVARDE!!!!! ");
    }

    public static int poderEspecial(int vidaMonstro) {

        System.out.println("Taffeson usou o PODER ESPECIAL! Causou 25 de dano!");
        vidaMonstro -= 25;
        if (vidaMonstro < 0) vidaMonstro = 0;
        System.out.println("Vida do Monstro agora " + vidaMonstro);
        return vidaMonstro;

    }

    public static int ganharXP(Random rand, int xp) {
        int xpGanhada = rand.nextInt(10) + 20;

        return xpGanhada;
    }

}