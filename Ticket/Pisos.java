package Ticket;

import java.util.Scanner;

import Pisos.Vaga;

public class Pisos {
    private Scanner numVagasAdd = new Scanner(System.in);
    private int andar;
    public Vaga vagas;
    private int entrada;
    private int saida;
    public static int totalPisos;

    public void Pisos(int andar, int entrada, int saida) {
        this.andar = andar;
        this.saida = saida;
        this.entrada = entrada;
        this.numeroDeVagasAdicionar();
    }

    private void numeroDeVagasAdicionar() {
        try {
            System.out.println("Digite o numero de vagas pequenas");
            var pequena = numVagasAdd.nextInt();
            System.out.println("Digite o numero de vagas grandes");
            var grande = numVagasAdd.nextInt();
            System.out.println("Digite o numero de vagas eletricas");
            var eletrico = numVagasAdd.nextInt();
            System.out.println("Digite o numero de vagas de moto");
            var moto = numVagasAdd.nextInt();
            this.vagas = new Vaga(pequena, grande, eletrico, moto);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar vagas, valor nao numerico");
        }
    }
}
