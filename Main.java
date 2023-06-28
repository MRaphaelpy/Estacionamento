class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Estacionamento estacionamento = new Estacionamento("Estacionamento do Zé", "Rua do Zé");
        estacionamento.mensagemBoasVindas();
        ControllerInicial controllerInicial = new ControllerInicial();
        controllerInicial.escolhasIniciais();
    }
}