package org.estacionamento.Piso.Vaga;

import org.estacionamento.Veiculos.*;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private int quantidadeCarros;
    private int quantidadeMotos;
    private int quantidadeEletricos;
    private int quantidadeCaminhoes;

    private List<Carro> carros;
    private List<Moto> motos;
    private List<Eletrico> eletricos;
    private List<Veiculos> caminhoes;

    public Vaga(int quantidadeCarros, int quantidadeMotos, int quantidadeEletricos, int quantidadeCaminhoes) {
        this.quantidadeCarros = quantidadeCarros;
        this.quantidadeMotos = quantidadeMotos;
        this.quantidadeEletricos = quantidadeEletricos;
        this.quantidadeCaminhoes = quantidadeCaminhoes;

        carros = new ArrayList<Carro>();
        motos = new ArrayList<Moto>();
        eletricos = new ArrayList<Eletrico>();
        caminhoes = new ArrayList<Veiculos>();
    }

    public void adicionarCarro(Carro carro) {
        if (carros.size() > quantidadeCarros) {

            carros.add(carro);
            System.out.println("Carro adicionado à vaga de carros.");
        } else {
            System.out.println("Não há vagas disponíveis para carros.");
        }
    }

    public void adicionarMoto(Moto moto) {
        if (motos.size() < quantidadeMotos) {
            motos.add(moto);
            System.out.println("Moto adicionada à vaga de motos.");
        } else {
            System.out.println("Não há vagas disponíveis para motos.");
        }
    }

    public void adicionarEletrico(Eletrico eletrico) {
        if (eletricos.size() < quantidadeEletricos) {
            eletricos.add(eletrico);
            System.out.println("Veículo elétrico adicionado à vaga de veículos elétricos.");
        } else {
            System.out.println("Não há vagas disponíveis para veículos elétricos.");
        }
    }

    public void adicionarCaminhao(Veiculos caminhao) {
        if (caminhoes.size() < quantidadeCaminhoes) {
            caminhoes.add(caminhao);
            System.out.println("Caminhão adicionado à vaga de caminhões.");
        } else {
            System.out.println("Não há vagas disponíveis para Caminhões ou Vans");
        }
    }

    public void removerCarro(Carro carro) {
        carros.remove(carro);
    }

    public void removerMoto(Moto moto) {
        motos.remove(moto);
    }

    public void removerEletrico(Eletrico eletrico) {
        eletricos.remove(eletrico);
    }

    public void removerCaminhao(Veiculos caminhao) {
        caminhoes.remove(caminhao);
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public List<Eletrico> getEletricos() {
        return eletricos;
    }

    public List<Veiculos> getCaminhoes() {
        return caminhoes;
    }

    public int getQuantidadeCarrosDisponiveis() {
        return quantidadeCarros - carros.size();
    }

    public int getQuantidadeMotosDisponiveis() {
        return quantidadeMotos - motos.size();
    }

    public int getQuantidadeEletricosDisponiveis() {
        return quantidadeEletricos - eletricos.size();
    }

    public int getQuantidadeCaminhoesDisponiveis() {
        return quantidadeCaminhoes - caminhoes.size();
    }
}
