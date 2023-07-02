package org.estacionamento.Veiculos;

public class Veiculos {
    private String placa;

    public Veiculos(String placa) {
        this.placa = placa;
    }
    public String getPlaca() {
        return this.placa;
    }

    public String getTipo(Veiculos veiculo) {
        if (veiculo instanceof Carro) {
            return "Carro";
        } else if (veiculo instanceof Moto) {
            return "Moto";
        } else if (veiculo instanceof Caminhao) {
            return "Caminhao";
        } else if (veiculo instanceof Van) {
            return "Van";
        } else if (veiculo instanceof Eletrico) {
            return "Eletrico";
        } else {
            return "Tipo não encontrado";
        }
    }
}
