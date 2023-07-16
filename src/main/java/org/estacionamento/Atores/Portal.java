package org.estacionamento.Atores;

import org.estacionamento.Piso.Vaga.Vaga;

public class Portal {
    public void vagasDisponiveis(Vaga vagas){
        System.out.printf("Vagas disponíveis para Carros: %d\n", vagas.getQuantidadeCarrosDisponiveis());
        System.out.printf("Vagas disponíveis para Motos: %d\n", vagas.getQuantidadeMotosDisponiveis());
        System.out.printf("Vagas disponíveis para Veículos elétricos: %d\n", vagas.getQuantidadeEletricosDisponiveis());
        System.out.printf("Vagas disponíveis para Caminhões e Vans: %d\n", vagas.getQuantidadeCaminhoesDisponiveis());

    }
}
