package org.estacionamento.Interfaces;
public interface IVaga {
    void setPequena(int pequena);
    void setGrande(int grande);
    void setEletrico(int eletrico);
    void setMoto(int moto);
    int getPequena();
    int getGrande();
    int getEletrico();
    int getMoto();
    void addPequena(int qtd);
    void addGrande(int qtd);
    void addEletrico(int qtd);
    void addMoto(int qtd);
}
