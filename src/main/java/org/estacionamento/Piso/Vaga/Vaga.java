package org.estacionamento.Piso.Vaga;

import org.estacionamento.Interfaces.IVaga;
import org.estacionamento.Veiculos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vaga implements IVaga {
    private int quantidadeCarros;
    private int quantidadeMotos;
    private int quantidadeEletricos;
    private int quantidadeCaminhoes;

    private Map<Class<? extends Veiculos>, Integer> vagasOcupadas;

    private List<Carro> carros;
    private List<Moto> motos;
    private List<Eletrico> eletricos;
    private List<Veiculos> caminhoes;

    public Vaga(int quantidadeCarros, int quantidadeMotos, int quantidadeEletricos, int quantidadeCaminhoes) {
        this.quantidadeCarros = quantidadeCarros;
        this.quantidadeMotos = quantidadeMotos;
        this.quantidadeEletricos = quantidadeEletricos;
        this.quantidadeCaminhoes = quantidadeCaminhoes;

        carros = new ArrayList<>();
        motos = new ArrayList<>();
        eletricos = new ArrayList<>();
        caminhoes = new ArrayList<>();

        vagasOcupadas = new HashMap<>();
        vagasOcupadas.put(Carro.class, 0);
        vagasOcupadas.put(Moto.class, 0);
        vagasOcupadas.put(Eletrico.class, 0);
        vagasOcupadas.put(Veiculos.class, 0);
    }

    public void adicionarCarro(Carro carro) {
        if (vagasOcupadas.get(Carro.class) < quantidadeCarros) {
            carros.add(carro);
            vagasOcupadas.put(Carro.class, vagasOcupadas.get(Carro.class) + 1);
            System.out.println("Carro adicionado à vaga de carros.");
        } else {
            System.out.println("Não há vagas disponíveis para carros.");
        }
    }

    public void adicionarMoto(Moto moto) {
        if (vagasOcupadas.get(Moto.class) < quantidadeMotos) {
            motos.add(moto);
            vagasOcupadas.put(Moto.class, vagasOcupadas.get(Moto.class) + 1);
            System.out.println("Moto adicionada à vaga de motos.");
        } else {
            System.out.println("Não há vagas disponíveis para motos.");
        }
    }

    public void adicionarEletrico(Eletrico eletrico) {
        if (vagasOcupadas.get(Eletrico.class) < quantidadeEletricos) {
            eletricos.add(eletrico);
            vagasOcupadas.put(Eletrico.class, vagasOcupadas.get(Eletrico.class) + 1);
            System.out.println("Veículo elétrico adicionado à vaga de veículos elétricos.");
        } else {
            System.out.println("Não há vagas disponíveis para veículos elétricos.");
        }
    }

    public void adicionarCaminhao(Veiculos caminhao) {
        if (vagasOcupadas.get(Veiculos.class) < quantidadeCaminhoes) {
            caminhoes.add(caminhao);
            vagasOcupadas.put(Veiculos.class, vagasOcupadas.get(Veiculos.class) + 1);
            System.out.println("Caminhão adicionado à vaga de caminhões.");
        } else {
            System.out.println("Não há vagas disponíveis para Caminhões ou Vans.");
        }
    }

    public void removerCarro(Carro carro) {
        if (carros.contains(carro)) {
            carros.remove(carro);
            vagasOcupadas.put(Carro.class, vagasOcupadas.get(Carro.class) - 1);
            System.out.println("Carro removido da vaga de carros.");
        } else {
            System.out.println("O carro não está estacionado nesta vaga.");
        }
    }

    public void removerMoto(Moto moto) {
        if (motos.contains(moto)) {
            motos.remove(moto);
            vagasOcupadas.put(Moto.class, vagasOcupadas.get(Moto.class) - 1);
            System.out.println("Moto removida da vaga de motos.");
        } else {
            System.out.println("A moto não está estacionada nesta vaga.");
        }
    }

    public void removerEletrico(Eletrico eletrico) {
        if (eletricos.contains(eletrico)) {
            eletricos.remove(eletrico);
            vagasOcupadas.put(Eletrico.class, vagasOcupadas.get(Eletrico.class) - 1);
            System.out.println("Veículo elétrico removido da vaga de veículos elétricos.");
        } else {
            System.out.println("O veículo elétrico não está estacionado nesta vaga.");
        }
    }

    public void removerCaminhao(Veiculos caminhao) {
        if (caminhoes.contains(caminhao)) {
            caminhoes.remove(caminhao);
            vagasOcupadas.put(Veiculos.class, vagasOcupadas.get(Veiculos.class) - 1);
            System.out.println("Caminhão removido da vaga de caminhões.");
        } else {
            System.out.println("O caminhão não está estacionado nesta vaga.");
        }
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
        return quantidadeCarros - vagasOcupadas.get(Carro.class);
    }

    public int getQuantidadeMotosDisponiveis() {
        return quantidadeMotos - vagasOcupadas.get(Moto.class);
    }

    public int getQuantidadeEletricosDisponiveis() {
        return quantidadeEletricos - vagasOcupadas.get(Eletrico.class);
    }

    public int getQuantidadeCaminhoesDisponiveis() {
        return quantidadeCaminhoes - vagasOcupadas.get(Veiculos.class);
    }
}
