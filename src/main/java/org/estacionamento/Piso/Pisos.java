package org.estacionamento.Piso;
import org.estacionamento.Interfaces.IPisos;
import org.estacionamento.Atores.Portal;
import org.estacionamento.Piso.Vaga.Vaga;
import org.estacionamento.Veiculos.*;

import java.util.Scanner;

public class Pisos{
    private Scanner numVagasAdd = new Scanner(System.in);
    private int andar;
    private Portal portal;
    public Vaga vagas;
    private int entrada;
    private int saida;
    public static int totalPisos;


    public void Pisos(int andar, int entrada, int saida) {
        this.andar = andar;
        this.saida = saida;
        this.entrada = entrada;
        this.portal = new Portal();
        this.numeroDeVagasAdicionar();
        totalPisos++;
    }


    public int getEntradas() {
        return this.entrada;
    }


    public int setEntradas(int entrada) {
        return this.entrada = entrada;
    }


    public int getSaidas() {
        return this.saida;
    }


    public int setSaidas(int saida) {
        return this.saida = saida;
    }


    public int getAndar() {
        return this.andar;
    }


    public int setAndar(int andar) {
        return this.andar = andar;
    }


    public void mostrarVagasLivres() {
        portal.vagasDisponiveis(vagas);
    }


    public boolean estacionarVeiculo(Veiculos veiculo) {

        if(veiculo instanceof Carro){
            vagas.adicionarCarro((Carro) veiculo);
            return  true;
        }
        else if(veiculo instanceof Moto){
            vagas.adicionarMoto((Moto) veiculo);
            return  true;
        }
        else if(veiculo instanceof Eletrico){
            vagas.adicionarEletrico((Eletrico) veiculo);
            return  true;
        }
        else if(veiculo instanceof Van){
            vagas.adicionarCaminhao(veiculo);
            return  true;
        }
        else if(veiculo instanceof Caminhao){
            vagas.adicionarCaminhao((Caminhao) veiculo);
            return  true;
        }
        else{
            System.out.println("Veiculo não identificado");
            return false;
        }

    }


    public void sairEstacionamento(Veiculos veiculo) {

        if(veiculo instanceof Carro){
            vagas.removerCarro((Carro) veiculo);
        }
        else if(veiculo instanceof Moto){
            vagas.removerMoto((Moto) veiculo);
        }
        else if(veiculo instanceof Eletrico){
            vagas.removerEletrico((Eletrico) veiculo);
        }
        else if(veiculo instanceof Van){
          //  vagas.removerCaminhao((Van) veiculo);
        }
        else if(veiculo instanceof Caminhao){
            vagas.removerCaminhao((Caminhao) veiculo);
        }
        else{
            System.out.println("Veiculo não identificado");
        }

        // else if (veiculo.getTipo(veiculo).equals("Eletrico")) {

        // if (vagas.getEletrico() < 0) {
        // vagas.setEletrico(vagas.getEletrico() + 1);
        // System.out.println("Carro eletrico saiu");
        // } else {
        // System.out.println("Sem vagas");
        // }


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
