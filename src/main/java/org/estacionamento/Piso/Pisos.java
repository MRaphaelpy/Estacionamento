package org.estacionamento.Piso;

import org.estacionamento.Atores.Portal;
import org.estacionamento.Estacionamento.Ticket;
import org.estacionamento.Interfaces.IPisos;
import org.estacionamento.Piso.Vaga.Vaga;
import org.estacionamento.Veiculos.*;

import java.util.Scanner;

public class Pisos implements IPisos{
    private Scanner numVagasAdd = new Scanner(System.in);
    private int andar;
    private Portal portal = new Portal();
    private Vaga vagas;
    private int entradas;
    private int saidas;
    public static int totalPisos = 0;

    public Pisos() {
        this.totalPisos++;
    }

    public Pisos(int andar, int entradas, int saidas) {
        this.andar = andar;
        this.entradas = entradas;
        this.saidas = saidas;
        this.portal = new Portal();
        adicionarNumeroDeVagas();
        totalPisos++;
    }

    public int getEntradas() {
        return this.entradas;
    }

    public int setEntradas(int entradas) {
        return this.entradas = entradas;
    }

    public int getSaidas() {
        return this.saidas;
    }

    public int setSaidas(int saidas) {
        return this.saidas = saidas;
    }

    public int getAndar() {
        return this.andar;
    }

    public int setAndar(int andar) {
        return this.andar = andar;
    }

    public void mostrarVagasLivres() {
        portal.getInformacoesVagas(vagas);
    }

    public void estacionarVeiculo(Veiculos veiculo) {
        if (veiculo instanceof Carro) {
            vagas.adicionarCarro((Carro) veiculo);
        } else if (veiculo instanceof Moto) {
            vagas.adicionarMoto((Moto) veiculo);
        } else if (veiculo instanceof Eletrico) {
            vagas.adicionarEletrico((Eletrico) veiculo);
        } else if (veiculo instanceof Van) {
            vagas.adicionarCaminhao(veiculo);
        } else if (veiculo instanceof Caminhao) {
            vagas.adicionarCaminhao((Caminhao) veiculo);
        } else {
            System.out.println("Veiculo não identificado");
        }
    }

    public void sairEstacionamento(Veiculos veiculo) {
        if (veiculo instanceof Carro) {
            vagas.removerCarro((Carro) veiculo);
        } else if (veiculo instanceof Moto) {
            vagas.removerMoto((Moto) veiculo);
        } else if (veiculo instanceof Eletrico) {
            vagas.removerEletrico((Eletrico) veiculo);
        } else if (veiculo instanceof Van) {
            vagas.removerCaminhao((Van) veiculo);
        } else if (veiculo instanceof Caminhao) {
            vagas.removerCaminhao((Caminhao) veiculo);
        } else {
            System.out.println("Veiculo não identificado");
        }
    }

    public void adicionarNumeroDeVagas() {
        try {
            System.out.print("Digite o número de vagas pequenas: ");
            int vagasPequenas = numVagasAdd.nextInt();
            System.out.print("Digite o número de vagas grandes: ");
            int vagasGrandes = numVagasAdd.nextInt();
            System.out.print("Digite o número de vagas elétricas: ");
            int vagasEletricas = numVagasAdd.nextInt();
            System.out.print("Digite o número de vagas para motos: ");
            int vagasMotos = numVagasAdd.nextInt();
            this.vagas = new Vaga(vagasPequenas, vagasGrandes, vagasEletricas, vagasMotos);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar vagas, valor não numérico.");
        }
    }

}
