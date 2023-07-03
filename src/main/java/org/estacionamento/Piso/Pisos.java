//package org.estacionamento.Piso;
//import org.estacionamento.Interfaces.IPisos;
//import org.estacionamento.Atores.Portal;
//import org.estacionamento.Piso.Vaga.Vaga;
//import org.estacionamento.Veiculos.*;
//
//import java.util.Scanner;
//
//public class Pisos implements IPisos {
//    private Scanner numVagasAdd = new Scanner(System.in);
//    private int andar;
//    private Portal portal;
//    public Vaga vagas;
//    private int entrada;
//    private int saida;
//    public static int totalPisos;
//
//    @Override
//    public void Pisos(int andar, int entrada, int saida) {
//        this.andar = andar;
//        this.saida = saida;
//        this.entrada = entrada;
//        this.portal = new Portal();
//        this.numeroDeVagasAdicionar();
//        totalPisos++;
//    }
//
//    @Override
//    public int getEntradas() {
//        return this.entrada;
//    }
//
//    @Override
//    public int setEntradas(int entrada) {
//        return this.entrada = entrada;
//    }
//
//    @Override
//    public int getSaidas() {
//        return this.saida;
//    }
//
//    @Override
//    public int setSaidas(int saida) {
//        return this.saida = saida;
//    }
//
//    @Override
//    public int getAndar() {
//        return this.andar;
//    }
//
//    @Override
//    public int setAndar(int andar) {
//        return this.andar = andar;
//    }
//
//    @Override
//    public void mostrarVagasLivres() {
//        portal.vagasDisponiveis(vagas);
//    }
//
//    @Override
//    public boolean estacionarVeiculo(Veiculos veiculo) {
//        if(veiculo instanceof Carro)
//        if (veiculo instanceof Carro) {
//            if (vagas.getPequena() > 0) {
//                var vagasrestante = vagas.getPequena() - 1;
//                vagas.setPequena(vagasrestante);
//                System.out.println("Carro estacionado");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        } else if (veiculo instanceof Moto) {
//            if (vagas.getMoto() > 0) {
//                vagas.setMoto(vagas.getMoto() - 1);
//                System.out.println("Moto estacionada");
//                return  true;
//            } else {
//                System.out.println("Sem vagas");
//                return  false;
//            }
//        } else if (veiculo instanceof Eletrico) {
//            if (vagas.getEletrico() > 0) {
//                vagas.setEletrico(vagas.getEletrico() - 1);
//                System.out.println("Carro eletrico estacionado");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        }else if(veiculo instanceof Caminhao){
//            if(vagas.getGrande()>0){
//                vagas.setGrande(vagas.getGrande()-1);
//                System.out.println("Caminhao estacionado");
//                return true;
//            }else{
//                System.out.println("Sem vagas");
//                return false;
//            }
//
//            }
//        else if (veiculo instanceof Van){
//            if(vagas.getGrande() >0){
//                vagas.setGrande(vagas.getGrande() -1);
//                System.out.println("Van estacionada");
//                return true;
//            }else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean sairEstacionamento(Veiculos veiculo) {
//        if (veiculo instanceof Carro) {
//            if (vagas.getPequena() < 0) {
//                vagas.setPequena(vagas.getPequena() + 1);
//                System.out.println("Carro saiu");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        } else if (veiculo instanceof Moto) {
//            if (vagas.getMoto() < 0) {
//                vagas.setMoto(vagas.getMoto() + 1);
//                System.out.println("Moto saiu");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return  false;
//            }
//        } else if (veiculo instanceof Eletrico) {
//            if (vagas.getEletrico() < 0) {
//                vagas.setEletrico(vagas.getEletrico() + 1);
//                System.out.println("Carro eletrico saiu");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        } else if (veiculo instanceof  Van) {
//            if (vagas.getGrande() < 0) {
//                vagas.setGrande(vagas.getGrande() + 1);
//                System.out.println("Van saiu");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        } else if (veiculo instanceof Caminhao) {
//            if (vagas.getGrande() < 0) {
//                vagas.setGrande(vagas.getGrande() + 1);
//                System.out.println("Caminhao saiu");
//                return true;
//            } else {
//                System.out.println("Sem vagas");
//                return false;
//            }
//        }
//
//        // else if (veiculo.getTipo(veiculo).equals("Eletrico")) {
//
//        // if (vagas.getEletrico() < 0) {
//        // vagas.setEletrico(vagas.getEletrico() + 1);
//        // System.out.println("Carro eletrico saiu");
//        // } else {
//        // System.out.println("Sem vagas");
//        // }
//
//        return false;
//    }
//
//    private void numeroDeVagasAdicionar() {
//        try {
//            System.out.println("Digite o numero de vagas pequenas");
//            var pequena = numVagasAdd.nextInt();
//            System.out.println("Digite o numero de vagas grandes");
//            var grande = numVagasAdd.nextInt();
//            System.out.println("Digite o numero de vagas eletricas");
//            var eletrico = numVagasAdd.nextInt();
//            System.out.println("Digite o numero de vagas de moto");
//            var moto = numVagasAdd.nextInt();
//            this.vagas = new Vaga(pequena, grande, eletrico, moto);
//        } catch (Exception e) {
//            System.out.println("Erro ao adicionar vagas, valor nao numerico");
//        }
//    }
//
//}
