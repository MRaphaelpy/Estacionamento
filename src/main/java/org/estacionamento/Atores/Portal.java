package org.estacionamento.Atores;

import org.estacionamento.Piso.Vaga.Vaga;
import org.estacionamento.Veiculos.Carro;
import org.estacionamento.Veiculos.Eletrico;
import org.estacionamento.Veiculos.Moto;
import org.estacionamento.Veiculos.Veiculos;

import java.util.List;

public class Portal {
    private static void informacoesVagas(Vaga vaga) {
        System.out.println("---- Carros ----");
        List<Carro> carrosEstacionados = vaga.getCarros();
        for (int i = 0; i < carrosEstacionados.size(); i++) {
            Carro carro = carrosEstacionados.get(i);
            System.out.println("Posição " + i + ": " + carro.getPlaca());
        }
        System.out.println("Vagas disponíveis para carros: " + vaga.getQuantidadeCarrosDisponiveis());

        System.out.println("---- Motos ----");
        List<Moto> motosEstacionadas = vaga.getMotos();
        for (int i = 0; i < motosEstacionadas.size(); i++) {
            Moto moto = motosEstacionadas.get(i);
            System.out.println("Posição " + i + ": " + moto.getPlaca());
        }
        System.out.println("Vagas disponíveis para motos: " + vaga.getQuantidadeMotosDisponiveis());

        System.out.println("---- Veículos Elétricos ----");
        List<Eletrico> eletricosEstacionados = vaga.getEletricos();
        for (int i = 0; i < eletricosEstacionados.size(); i++) {
            Eletrico eletrico = eletricosEstacionados.get(i);
            System.out.println("Posição " + i + ": " + eletrico.getPlaca());
        }
        System.out.println("Vagas disponíveis para veículos elétricos: " + vaga.getQuantidadeEletricosDisponiveis());

        System.out.println("---- Caminhões Ou Vans ----");
        List<Veiculos> caminhoesEstacionados = vaga.getCaminhoes();
        for (int i = 0; i < caminhoesEstacionados.size(); i++) {
            Veiculos caminhao = caminhoesEstacionados.get(i);
            System.out.println("Posição " + i + ": " + caminhao.getPlaca());
        }
        System.out.println("Vagas disponíveis para caminhões ou Vans: " + vaga.getQuantidadeCaminhoesDisponiveis());
    }
    public void getInformacoesVagas(Vaga vaga) {
        informacoesVagas(vaga);
    }
}
