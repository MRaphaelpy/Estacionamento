package org.estacionamento.Piso.Vaga;

import org.estacionamento.Interfaces.IVaga;

public class Vaga implements IVaga {
    private int pequena;
    private int grande;
    private int eletrico;
    private int moto;

    public Vaga(int pequena, int grande, int eletrico, int moto) {
        if (pequena >= 0 && grande >= 0 && eletrico >= 0 && moto >= 0) {
            if (pequena + grande + moto + eletrico >= 5) {
                this.pequena = pequena;
                this.grande = grande;
                this.eletrico = eletrico;
                this.moto = moto;
            } else {
                System.out.print("\033[H\033[2J");
                System.out.println("Numero de vagas Inferior a 5 Nao permitido");
            }
        } else {
            System.out.println("Erro ao criar vagas");
        }
    }

    public void setPequena(int pequena) {
        if (pequena >= 0) {
            this.pequena = pequena;
        } else {
            System.out.println("Erro ao criar vagas pequenas");
        }
    }

    public void setGrande(int grande) {
        if (grande >= 0) {
            this.grande = grande;
        } else {
            System.out.println("Erro ao criar vagas grandes");
        }
    }

    public void setEletrico(int eletrico) {
        if (eletrico >= 0) {
            this.eletrico = eletrico;
        } else {
            System.out.println("Erro ao criar vagas eletricas");
        }
    }

    public void setMoto(int moto) {
        if (moto >= 0) {
            this.moto = moto;
        } else {
            System.out.println("Erro ao criar vagas de moto");
        }
    }

    public int getPequena() {
        return this.pequena;
    }

    public int getGrande() {
        return this.grande;
    }

    public int getEletrico() {
        return this.eletrico;
    }

    public int getMoto() {
        return this.moto;
    }

    public void addGrande(int qtd) {
        qtd += this.grande;
        this.setGrande(qtd);
    }

    public void addEletrico(int qtd) {
        qtd += this.eletrico;
        this.setEletrico(qtd);
    }

    public void addMoto(int qtd) {
        qtd += this.moto;
        this.setMoto(qtd);
    }

    @Override
    public void addPequena(int qtd) {
        qtd += this.pequena;
        this.setPequena(qtd);
    }

}
