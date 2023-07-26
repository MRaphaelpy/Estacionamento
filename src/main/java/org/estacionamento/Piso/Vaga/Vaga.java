package org.estacionamento.Piso.Vaga;

import org.estacionamento.Veiculos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Vaga {
    private int quantidadeCarros;
    private int quantidadeMotos;
    private int quantidadeEletricos;
    private int quantidadeCaminhoes;

//    private List<Carro> carros;
//    private List<Moto> motos;
//    private List<Eletrico> eletricos;
//    private List<Veiculos> caminhoes;
private Map<String, List<Carro>> carros;
    private Map<String, List<Moto>> motos;
    private Map<String, List<Eletrico>> eletricos;
    private Map<String, List<Veiculos>> caminhoes;


    public Vaga(int quantidadeCarros, int quantidadeMotos, int quantidadeEletricos, int quantidadeCaminhoes) {
        this.quantidadeCarros = quantidadeCarros;
        this.quantidadeMotos = quantidadeMotos;
        this.quantidadeEletricos = quantidadeEletricos;
        this.quantidadeCaminhoes = quantidadeCaminhoes;

        carros = new HashMap<>();
        motos = new HashMap<>();
        eletricos = new HashMap<>();
        caminhoes = new HashMap<>();
//        carros = new ArrayList<Carro>();
//        motos = new ArrayList<Moto>();
//        eletricos = new ArrayList<Eletrico>();
//        caminhoes = new ArrayList<Veiculos>();
    }

    public void adicionarCarro(Carro carro) {
        if (carros.size() < quantidadeCarros) {
            carros.computeIfAbsent("carros", k -> new ArrayList<>()).add(carro);
            System.out.println("Carro adicionado à vaga de carros.");
        } else {
            System.out.println("Não há vagas disponíveis para carros.");
        }
    }

    public void adicionarMoto(Moto moto) {
        if (motos.size() < quantidadeMotos) {
            motos.computeIfAbsent("motos", k -> new ArrayList<>()).add(moto);
            System.out.println("Moto adicionada à vaga de motos.");
        } else {
            System.out.println("Não há vagas disponíveis para motos.");
        }
    }

    public void adicionarEletrico(Eletrico eletrico) {
        if (eletricos.size() < quantidadeEletricos) {
            eletricos.computeIfAbsent("eletricos", k -> new ArrayList<>()).add(eletrico);
            System.out.println("Veículo elétrico adicionado à vaga de veículos elétricos.");
        } else {
            System.out.println("Não há vagas disponíveis para veículos elétricos.");
        }
    }

    public void adicionarCaminhao(Veiculos caminhao) {
        if (caminhoes.size() < quantidadeCaminhoes) {
            caminhoes.computeIfAbsent("caminhoes", k -> new ArrayList<>()).add(caminhao);
            System.out.println("Caminhão adicionado à vaga de caminhões.");
        } else {
            System.out.println("Não há vagas disponíveis para Caminhões ou Vans");
        }
    }


    public void removerCarro(Carro carro) {
        carros.computeIfPresent("carros", (k, v) -> {
            v.remove(carro);
            return v;
        });
    }

    public void removerMoto(Moto moto) {
        motos.computeIfPresent("motos", (k, v) -> {
            v.remove(moto);
            return v;
        });
    }

    public void removerEletrico(Eletrico eletrico) {
        eletricos.computeIfPresent("eletricos", (k, v) -> {
            v.remove(eletrico);
            return v;
        });
    }

    public void removerCaminhao(Veiculos caminhao) {
        caminhoes.computeIfPresent("caminhoes", (k, v) -> {
            v.remove(caminhao);
            return v;
        });
    }


    public Map<String, List<Carro>> getCarros() {
        return carros;
    }

    public Map<String, List<Moto>> getMotos() {
        return motos;
    }

    public Map<String, List<Eletrico>> getEletricos() {
        return eletricos;
    }

    public Map<String, List<Veiculos>> getCaminhoes() {
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
