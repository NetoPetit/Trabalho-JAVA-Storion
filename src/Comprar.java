import java.util.Scanner;

public class Comprar extends Cliente{

    Menu menus = new Menu();
    Scanner entrada = new Scanner(System.in);

    public void cadastrar() {
        System.out.println("==================================");
        System.out.println("||FAÇA SEU CADASTRO PARA COMEÇAR||");
        System.out.println("==================================");

        System.out.println("\nQual seu nome?");
        setNome(entrada.nextLine());

        if (getNome().isEmpty()) {

            while (getNome().isEmpty()) {
                System.out.println("Nome inválido! Digite um nome válido.");
                System.out.println("\n");
                System.out.println("Qual seu nome?");
                setNome(entrada.nextLine());
            }
        }

        System.out.println("Qual sua idade?");
        setIdade(entrada.nextInt());
        System.out.println("\n");

        if (getIdade() == null || getIdade() < 0) {
            while (getIdade() == null || getIdade() < 0) {
                System.out.println("Idade inválida! Digite uma idade válida.\n"
                        + "Qual sua idade?");
                setIdade(entrada.nextInt());
                System.out.println("\n");
            }
        }
    }

    public void comecar() {
        System.out.println("===========================================");
        System.out.println(" SEJA BEM VINDO(A) " + getNome() + " !!! ");
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

        if (opcaoMenu == 1) {
            consultarSaldo();
        } else if (opcaoMenu == 2) {
            fazerDeposito();
        } else if (opcaoMenu == 3) {
            comprarProduto();
        } else if (opcaoMenu == 4) {
            status();

            System.out.println("O que deseja fazer:\n"
                    + "[1] Atualizar Cadastro\n"
                    + "[2] Voltar\n"
                    + "[3] Encerrar");
            int opcaoQuatroMenu = entrada.nextInt();
            System.out.println("\n");

            if (opcaoQuatroMenu == 1) {
                cadastrar();
                status();
                System.out.println("Cadastro atualizado com sucesso!"
                        + " Retornando ao Menu Principal\n");
                comecar();
            } else if (opcaoQuatroMenu == 2) {
                comecar();
            } else if (opcaoQuatroMenu == 3){
                System.out.println("Encerrando o programa...");
                System.exit(0);
            } else {
                while (opcaoQuatroMenu < 1 || opcaoQuatroMenu > 3) {
                    System.out.println("Opção inválida. Escolha uma opção válida!");
                    System.out.println("\n");
                    System.out.println("O que deseja fazer:\n"
                            + "[1] Atualizar cadastro\n"
                            + "[2] Voltar\n"
                            + "[3] Encerrar");
                    opcaoQuatroMenu = entrada.nextInt();
                    System.out.println("\n");

                    if (opcaoQuatroMenu == 1) {
                        cadastrar();
                        status();
                        System.out.println("Cadastro atualizado com sucesso!"
                                + " Retornando ao Menu Principal\n");
                        comecar();
                    }
                    if (opcaoQuatroMenu == 2) {
                        comecar();
                    }
                    if (opcaoQuatroMenu == 3){
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                    }
                }
            }

        } else if (opcaoMenu == 5){
            System.out.println("Encerrando o programa...");
            System.exit(0);
        } else {
            System.out.println("Opção inválida! Escolha uma opção válida.\n");
            comecar();
        }

    }

    public void comprarBebida(){
        System.out.println("\nVocê tem R$" + getSaldo() + "\n");
        menus.menuBebida();
        int opcaoMenuBebida = entrada.nextInt();

        if (opcaoMenuBebida == 1) {

            float valorProduto = 10.5f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Refrigerante.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outra bebida\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoBebida = entrada.nextInt();
                if (segundaOpcaoBebida == 1) {
                    comprarBebida();
                } else if (segundaOpcaoBebida == 2) {
                    comprarProduto();
                }else if (segundaOpcaoBebida == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            }else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                + "[1] Fazer depósito\n"
                + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuBebida == 2){
            float valorProduto = 7.8f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Suco.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outra bebida\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoBebida = entrada.nextInt();
                if (segundaOpcaoBebida == 1) {
                    comprarBebida();
                } else if (segundaOpcaoBebida == 2) {
                    comprarProduto();
                }else if (segundaOpcaoBebida == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            }else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuBebida == 3){
            if (getIdade() < 18){
                System.out.println("\n" + getNome() + " você tem " + getIdade()
                        + " anos. Você é menor de idade!\n");
                System.out.println("=================================================================");
                System.out.println("||          *******Lei federal 13.106/16*******                ||");
                System.out.println("||PROIBIDA A VENDA DE BEBIDAS ALCOÓLICAS PARA MENORES DE IDADE!||");
                System.out.println("||          **********VENDA CANCELADA**********                ||");
                System.out.println("=================================================================");
                System.out.println("\nO que deseja fazer:\n"
                + "[1] Atualizar cadastro\n"
                + "[2] Comprar outro produto\n"
                + "[3] Voltar ao Menu Principal\n"
                + "[4] Sair");
                int opcaoMenuCerveja = entrada.nextInt();

                if (opcaoMenuCerveja == 1){
                    cadastrar();
                    status();
                    System.out.println("Cadastro atualizado com sucesso!"
                            + " Retornando ao Menu Principal\n");
                    comecar();
                } else if (opcaoMenuCerveja == 2){
                    comprarProduto();
                } else if (opcaoMenuCerveja == 3){
                    comecar();
                } else if (opcaoMenuCerveja == 4){
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                } else {
                    while (opcaoMenuCerveja < 1 || opcaoMenuCerveja > 4) {
                        System.out.println("Opção inválida! Escolha uma opção:\n\n");
                        System.out.println("O que deseja fazer:\n"
                                + "[1] Atualizar cadastro\n"
                                + "[2] Comprar outro produto\n"
                                + "[3] Voltar ao Menu Principal\n"
                                + "[4] Sair");
                        opcaoMenuCerveja = entrada.nextInt();

                        if (opcaoMenuCerveja == 1) {
                            cadastrar();
                            status();
                            System.out.println("Cadastro atualizado com sucesso!"
                                    + " Retornando ao Menu Principal\n");
                            comecar();
                        } else if (opcaoMenuCerveja == 2) {
                            comprarProduto();
                        } else if (opcaoMenuCerveja == 3){
                            comecar();
                        } else if (opcaoMenuCerveja == 4){
                            System.out.println("Encerrando o programa...");
                            System.exit(0);
                        }
                    }
                }

            } else {
                float valorProduto = 14.5f;
                if (valorProduto <= getSaldo()) {
                    setSaldo(getSaldo() - valorProduto);
                    System.out.println("\nVoce comprou o produto Cerveja.\n"
                            + "Seu saldo atual é R$" + getSaldo() + "\n");
                    System.out.println("O que deseja fazer?\n"
                            + "[1] Comprar outra bebida\n"
                            + "[2] Comprar outro produto\n"
                            + "[3] Voltar ao Menu Principal");
                    int segundaOpcaoBebida = entrada.nextInt();
                    if (segundaOpcaoBebida == 1) {
                        comprarBebida();
                    } else if (segundaOpcaoBebida == 2) {
                        comprarProduto();
                    }else if (segundaOpcaoBebida == 3){
                        comecar();
                    } else {
                        System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                        comprarProduto();
                    }
                } else {
                    System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                            + "[1] Fazer depósito\n"
                            + "[2] Menu Principal");
                    int opcaoFinal = entrada.nextInt();

                    if (opcaoFinal == 1){
                        fazerDeposito();
                        menuDeposito();
                    } else if (opcaoFinal == 2){
                        comecar();
                    } else {
                        while (opcaoFinal < 1 || opcaoFinal > 2) {
                            System.out.println("Opção inválida! Escolha uma opção\n\n");
                            System.out.println("[1] Fazer depósito\n"
                                    + "[2] Menu Principal");
                            opcaoFinal = entrada.nextInt();

                            if (opcaoFinal == 1) {
                                fazerDeposito();
                                menuDeposito();
                            } else if (opcaoFinal == 2) {
                                comecar();
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Opção inválida! Escolha uma opção: \n");
            comprarBebida();
        }
    }

    public void comprarComida(){
        menus.menuComida();
        int opcaoMenuComida = entrada.nextInt();

        if (opcaoMenuComida == 1) {
            float valorProduto = 8f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Salgado.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outra comida\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoComida = entrada.nextInt();
                if (segundaOpcaoComida == 1) {
                    comprarComida();
                } else if (segundaOpcaoComida == 2) {
                    comprarProduto();
                }else if (segundaOpcaoComida == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuComida == 2){
            float valorProduto = 12.8f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Pastel.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outra comida\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoComida = entrada.nextInt();
                if (segundaOpcaoComida == 1) {
                    comprarComida();
                } else if (segundaOpcaoComida == 2) {
                    comprarProduto();
                }else if (segundaOpcaoComida == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuComida == 3){
            float valorProduto = 17.9f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Salada.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outra comida\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoComida = entrada.nextInt();
                if (segundaOpcaoComida == 1) {
                    comprarComida();
                } else if (segundaOpcaoComida == 2) {
                    comprarProduto();
                }else if (segundaOpcaoComida == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else {
            System.out.println("Opção inválida! Escolha uma opção: \n");
            comprarComida();
        }
    }

    public void comprarHigienie(){
        menus.menuHigiene();
        int opcaoMenuHigiene = entrada.nextInt();

        if (opcaoMenuHigiene == 1) {
            float valorProduto = 19.9f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Shampoo.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outro produto de higiene\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoHigiene = entrada.nextInt();
                if (segundaOpcaoHigiene == 1) {
                    comprarHigienie();
                } else if (segundaOpcaoHigiene == 2) {
                    comprarProduto();
                }else if (segundaOpcaoHigiene == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuHigiene == 2) {
            float valorProduto = 2.35f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Sabonete.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outro produto de higiene\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoHigiene = entrada.nextInt();
                if (segundaOpcaoHigiene == 1) {
                    comprarHigienie();
                } else if (segundaOpcaoHigiene == 2) {
                    comprarProduto();
                }else if (segundaOpcaoHigiene == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else if (opcaoMenuHigiene == 3) {
            float valorProduto = 13.4f;
            if (valorProduto <= getSaldo()) {
                setSaldo(getSaldo() - valorProduto);
                System.out.println("\nVoce comprou o produto Desodorante.\n"
                        + "Seu saldo atual é R$" + getSaldo() + "\n");
                System.out.println("O que deseja fazer?\n"
                        + "[1] Comprar outro produto de higiene\n"
                        + "[2] Comprar outro produto\n"
                        + "[3] Voltar ao Menu Principal");
                int segundaOpcaoHigiene = entrada.nextInt();
                if (segundaOpcaoHigiene == 1) {
                    comprarHigienie();
                } else if (segundaOpcaoHigiene == 2) {
                    comprarProduto();
                }else if (segundaOpcaoHigiene == 3){
                    comecar();
                } else {
                    System.out.println("Opção inválida. Voltando ao Menu dos Produtos!");
                    comprarProduto();
                }
            } else {
                System.out.println("Saldo insuficiente! Escolha uma opção:\n\n"
                        + "[1] Fazer depósito\n"
                        + "[2] Menu Principal");
                int opcaoFinal = entrada.nextInt();

                if (opcaoFinal == 1){
                    fazerDeposito();
                    menuDeposito();
                } else if (opcaoFinal == 2){
                    comecar();
                } else {
                    while (opcaoFinal < 1 || opcaoFinal > 2) {
                        System.out.println("Opção inválida! Escolha uma opção\n\n");
                        System.out.println("[1] Fazer depósito\n"
                                + "[2] Menu Principal");
                        opcaoFinal = entrada.nextInt();

                        if (opcaoFinal == 1) {
                            fazerDeposito();
                            menuDeposito();
                        } else if (opcaoFinal == 2) {
                            comecar();
                        }
                    }
                }
            }
        } else {
            System.out.println("Opção inválida! Escolha uma opção: \n");
            comprarHigienie();
        }

    }

    public void comprarProduto(){
        menus.menuProdutos();
        int opcaoMenuProdutos = entrada.nextInt();
        if (opcaoMenuProdutos == 1){
            comprarBebida();
        } else if (opcaoMenuProdutos == 2){
            comprarComida();
        } else if  (opcaoMenuProdutos == 3){
            comprarHigienie();
        } else {
            System.out.println("Opção inválida. Escolha uma opção válida:\n");
            comprarProduto();
        }
    }

    public void consultarSaldo() {
        System.out.println("=========");
        System.out.println("||SALDO||");
        System.out.println("=========");
        System.out.println("\n" + this.getNome() + " seu saldo é R$ " + this.getSaldo()
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

    public void fazerDeposito() {
        System.out.println("============");
        System.out.println("||DEPÓSITO||");
        System.out.println("============");
        System.out.println("\nQual o valor do depósito?");
        float valor = entrada.nextFloat();
        this.setSaldo(this.getSaldo() + valor);
        menuDeposito();
    }

    public void menuDeposito(){

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
        } else {
            System.out.println("Opção inválida. Escolha uma opção válida:\n");
            menuDeposito();
        }
    }
    public void status(){
        System.out.println("=======================");
        System.out.println("|| DADOS DO CADASTRO ||");
        System.out.println("=======================\n");
        System.out.println("Nome: " + getNome() +"\n"
                + "Idade: " + getIdade() + "\n");
    }

}
