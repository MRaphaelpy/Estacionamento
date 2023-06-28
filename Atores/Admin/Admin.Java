public class Admin extends AccountImplementation{
    private Scanner opcao;

    private ArrayList<Piso> pisos;
    private ArrayList<Admin> Admins;
    private ArrayList<Atendente> funcionarios;

    Piso piso;
    Admin admin;
    Atendente funcionario;
    
    public Admin(ArrayList<Piso> piso, ArrayList<Admin> admin, ArrayList<Atendente> funcionario, String usuario, String senha) {
        this.pisos = new ArrayList<Piso>();
        this.Admins = new ArrayList<Admin>();
        this.funcionarios = new ArrayList<Atendente>();

        this.piso = new Piso(this.pisos);
    }

    public void AdminFunc(){
        System.out.println("Escollha uma opção:");
        System.out.println("1-Alterar Pisos");
        System.out.println("2-Alterar Funcionarios");
        System.out.println("3-Alterar Admins");
        System.out.println("4-Sair");
        String opcoes = opcao.nextInt();

        if(opcoes == 1){

            piso.alterarPiso();
        }
    }


}