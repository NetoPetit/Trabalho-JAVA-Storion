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

    //***PRECISA TERMINAR DE PROGRAMAR AS OPÇÕES-SÓ FOI FEITO A [1]***
    //TALVEZ ESSE MÉTODO VÁ PARA OUTRA CLASSE SE NECESSÁRIO
    public void comecar() {
        System.out.println("===========================================");
        System.out.println(" Seja bem vindo(a) " + getNome() + " !!! ");
        System.out.println("===========================================");
        System.out.println("\nPor onde deseja começar?\n"
                + "\n========MENU========\n"
                + "[1] Consultar saldo\n"
                + "[2] Fazer depósito\n"
                + "[3] Comprar\n"//FALTA FAZER ESSA OPÇÃO
                + "[4] Ver cadastro\n"
                + "[5] Encerrar");
        int opcaoMenu = entrada.nextInt();
        System.out.println("\n");

        if (opcaoMenu == 1) {
            consultarSaldo();
        } else if (opcaoMenu == 2) {
            fazerDeposito();
        } else if (opcaoMenu == 3) {
            //A DEFINIR
        } else if (opcaoMenu == 4) {
            status();

            System.out.println("O que deseja fazer:\n"
                    + "[1] Editar Cadastro\n"//**TIRAR?**
                    + "[2] Voltar\n"
                    + "[3] Encerrar");
            int opcaoQuatroMenu = entrada.nextInt();

            while (opcaoQuatroMenu == 1){
                cadastrar();
                status();
            }
            /*if (opcaoQuatroMenu == 1) {
                cadastrar();
                status();

                System.out.println("O que deseja fazer:\n"
                        + "[1] Editar Cadastro\n"
                        + "[2] Voltar\n"
                        + "[3] Encerrar");
                opcaoQuatroMenu = entrada.nextInt();
            } else */if (opcaoQuatroMenu == 2) {
                comecar();
            } else if (opcaoQuatroMenu == 3){
                System.out.println("Encerrando o programa...");
                System.exit(0);
            } else {
                while (opcaoQuatroMenu < 1 || opcaoQuatroMenu > 2) {
                    System.out.println("Opção inválida. Escolha uma opção válida:\n"
                            + "[1] Voltar\n"
                            + "[2] Encerrar");
                    opcaoQuatroMenu = entrada.nextInt();

                    if (opcaoQuatroMenu == 1) {
                        comecar();
                    }
                    if (opcaoQuatroMenu == 2) {
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                    }
                }
            }

        } else {
            System.out.println("Encerrando o programa...");
            System.exit(0);
        }

    }

    public void consultarSaldo() {
        System.out.println(this.getNome() + " seu saldo é R$ " + this.getSaldo()
                + "\nO que deseja fazer:\n"
                + "[1] Nova consulta\n"
                + "[2] Fazer depósito\n"
                + "[3] Retornar ao Menu Principal\n"
                + "[4] Sair");
        int opcaoCosultarSaldo = entrada.nextInt();
        System.out.println("\n");

        if (opcaoCosultarSaldo == 1) {
            consultarSaldo();
        } else if (opcaoCosultarSaldo == 2) {
            fazerDeposito();
        } else if (opcaoCosultarSaldo == 3) {
            comecar();
        } else if (opcaoCosultarSaldo == 4) {
            System.out.println("Encerrando o programa...");
            System.exit(0);
        } else {
            System.out.println("Opção inválida. Escolha uma opção válida:\n");
            consultarSaldo();
        }
    }

    ;

    public void fazerDeposito() {
        System.out.println("Qual o valor do depósito?");
        float valor = entrada.nextFloat();
        this.setSaldo(this.getSaldo() + valor);

        System.out.println("Seu saldo atual é R$ " + this.getSaldo() + "\n\n"
                + "O que deseja fazer:\n\n"
                + "[1] Novo depósito\n"
                + "[2] Retornar ao Menu Principal\n"
                + "[3] Encerrar");
        int opcaoDeposito = entrada.nextInt();
        System.out.println("\n");

        if (opcaoDeposito == 1) {
            fazerDeposito();
        } else if (opcaoDeposito == 2) {
            comecar();
        } else if (opcaoDeposito == 3) {
            System.out.println("Encerrando o programa...");
            System.exit(0);
        }
    }
    public void status(){
        System.out.println("Nome: " + getNome() +"\n"
        + "Idade: " + getIdade() + "\n"
        + "Sexo: " + getSexo() + "\n");
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getDeposito() {
        return this.deposito;
    }

    public void setDeposito(float deposito) {
        this.deposito = deposito;
    }

    public boolean getComprar() {
        return this.comprar;
    }

    public void setComprar(boolean comprar) {
        this.comprar = comprar;
    }

}