package org.estacionamento.Estacionamento;

public class TaxasEstacionamento {
    private static final double PRIMEIRA_HORA = 4.00;
    private static final double SEGUNDA_TERCEIRA_HORA = 3.50;
    private static final double HORA_ADICIONAL = 2.50;

    public TaxasEstacionamento() {
    }

    public static double calcularValorEstacionamento(int horasEstacionado) throws IllegalArgumentException {
        if (horasEstacionado < 0) {
            System.out.println("Kekw\n");
            throw new IllegalArgumentException("O número de horas estacionado não pode ser negativo.");

        }

        double valorTotal = 0.0;

        if (horasEstacionado <= 0) {
            return valorTotal;
        }

        valorTotal += PRIMEIRA_HORA;

        if (horasEstacionado > 1) {
            valorTotal += SEGUNDA_TERCEIRA_HORA * 2;

            if (horasEstacionado > 3) {
                int horasAdicionais = horasEstacionado - 3;
                valorTotal += HORA_ADICIONAL * horasAdicionais;
            }
        }

        return valorTotal;
    }
}
