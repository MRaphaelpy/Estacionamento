package org.estacionamento.Atores;

import org.estacionamento.Piso.Vaga.Vaga;

public class Portal {
    public void vagasDisponiveis(Vaga vagas){
        System.out.printf("Veiculos disponiveis: Pequenos %d Grandes %d Eletricos %d Motos %d ", vagas.getPequena(), vagas.getGrande(), vagas.getEletrico(), vagas.getMoto());
    }
}
