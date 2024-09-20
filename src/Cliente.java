import java.util.Scanner;

public class Cliente extends Pessoa {
    private float saldo;
    private float deposito;
    private boolean comprar;

    Scanner entrada = new Scanner(System.in);

    public void cadastrar() {
        System.out.println("==================================");
        System.out.println("||FAÇA SEU CADASTRO PARA COMEÇAR||");
        System.out.println("==================================");

        System.out.println("\nQual seu nome?");
        setNome(entrada.nextLine());
        if (getNome().equals("")) {

            while (getNome().equals("")) {
                System.out.println("Nome inválido! Digite um nome válido.\n"
                        + "Qual seu nome?");
                setNome(entrada.nextLine());
            }
        }
        //**PRECISA ARRUMAR-Em caso de resposta nula, está pulando linha ao invés de recomeçar**//
        System.out.println("Qual sua idade?");
        setIdade(entrada.nextInt());
        if (getIdade() == null || getIdade() < 0) {
            while (getIdade() == null || getIdade() < 0) {
                System.out.println("Idade inválida! Digite uma idade válida.\n"
                + "Qual sua idade?");
                setIdade(entrada.nextInt());
            }
        }
        //**PRECISA ARRUMAR-Está começando a primeira interação vazia**//
        //**Não sei se vai fazer parte do programa final
        System.out.println("Qual seu sexo?");
        setSexo(entrada.nextLine());
        System.out.println("\n");

        if (getSexo().equals("")) {

            while (getSexo().equals("")) {
                System.out.println("Sexo inválido! Digite um sexo válido.\n"
                        + "Qual seu sexo?");
                setSexo(entrada.nextLine());
                System.out.println("\n");
            }
        }
    }

    public void comecar(){
        System.out.println("===========================================");
        System.out.println(" Seja bem vindo(a) " + getNome() + " !!! ");
        System.out.println("===========================================");
        System.out.println("\nPor onde deseja começar?\n"
                + "\n========MENU========\n"
                + "[1] Consultar saldo\n"
                + "[2] Fazer depósito\n"
                + "[3] Comprar\n"
                + "[4] Ver cadastro\n"
                + "[5] Encerrar");
        int opcaoMenu = entrada.nextInt();
        System.out.println("\n");

        if(opcaoMenu == 1){
            consultarSaldo();
        }

    }
    public void consultarSaldo(){
        System.out.println(this.getNome() + " seu saldo é R$ " + this.getSaldo()
        + "\nO que deseja fazer:\n"
        + "[1] Nova consulta\n"
        + "[2] Fazer depósito\n"
        + "[3] Retornar ao Menu Principal\n"
        + "[4] Sair");
        int opcaoCosultarSaldo = entrada.nextInt();
        System.out.println("\n");

        if(opcaoCosultarSaldo == 1){
            consultarSaldo();
        }else if(opcaoCosultarSaldo == 2){
            fazerDeposito();
        }else if(opcaoCosultarSaldo == 3){
            comecar();
        }else if (opcaoCosultarSaldo == 4){
            System.out.println("Encerrando o programa...");
            System.exit(0);
        }else {
            System.out.println("Opção inválida. Escolha uma opção válida:\n");
            consultarSaldo();
        }
    };
    public void fazerDeposito(){
        System.out.println("Qual o valor do depósito?\n");
        float valor = entrada.nextFloat();
        this.setSaldo(this.getSaldo() + valor);
        System.out.println("Seu saldo atual é R$ " + this.getSaldo() + "\n\n"
        + "O que deseja fazer:\n\n"
        + "[1] Novo depósito\n"
        + "[2] Retornar ao Menu Principal"
        + "[3] Encerrar");
    };
    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public float getDeposito(){
        return this.deposito;
    }
    public void setDeposito(float deposito){
        this.deposito = deposito;
    }
    public boolean getComprar(){
        return this.comprar;
    }
    public void setComprar(boolean comprar){
        this.comprar = comprar;
    }
}
