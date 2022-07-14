package ProjetoTrilha;

//bibliotecas importadas para usar no código
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //scanner para coletar numeros
        Scanner entrada = new Scanner(System.in);
        //scanner para coletar strings
        Scanner entradaString = new Scanner(System.in);

        //arraylist usado no código
        ArrayList<Marcas> marcas = new ArrayList();
        ArrayList<Funcionario> funcionarios = new ArrayList();
        ArrayList<Cliente> clientes = new ArrayList();

        /*instanciando um cliente e um funcionario que
        *servirão de auxiliar para as operações*/
        Funcionario operador = new Funcionario();
        Cliente aux = new Cliente();
        Concessionaria acaoCliente = new Concessionaria();
        Concessionaria acaoFuncionario = new Concessionaria();

        //preenchendo o arraylist de marcas
        Marcas fiat = new Marcas("Fiat", "Punto", "cinza", "nacional", 25499.00, 2011);
        Marcas chevrolet = new Marcas("Chevrolet", "Cruze", "preta", "nacional", 124595, 2022);
        Marcas porsche = new Marcas("Porsche", "Spyder", "branca", "internacional", 4124591, 2013);
        Marcas nissan = new Marcas("Nissan", "GTR", "laranja", "internacional", 769109, 2017);
        Marcas volkswagen = new Marcas("Volkswagen", "Jetta", "vermelha", "nacional", 144991, 2020);
        Marcas hyundai = new Marcas("Hyundai", "Hb20", "branca", "nacional", 59291, 2020);
        Marcas bmw = new Marcas("BMW", "Serie1", "azul", "internacional", 259951, 2022);
        Marcas audi = new Marcas("Audi", "A3", "azul", "internacional", 153991, 2021);
        Marcas lamborghini = new Marcas("Lamborghini", "Aventador Roadster", "cinza", "internacional", 3224591, 2020);
        Marcas mercedes = new Marcas("Mercedes-Benz", "Classe A", "prata", "internacional", 190951, 2019);

        //adicionando os objetos ao array de marcas
        marcas.add(fiat);
        marcas.add(chevrolet);
        marcas.add(porsche);
        marcas.add(nissan);
        marcas.add(volkswagen);
        marcas.add(hyundai);
        marcas.add(bmw);
        marcas.add(audi);
        marcas.add(mercedes);
        marcas.add(lamborghini);

        //variáveis usadas no código
        int menu;
        int menuCliente;
        int menuFuncionario;
        int Exit = 1;
        int exitCliente = 1;
        int exitFuncionario = 1;

        do {
            exibirMenu();
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    for (Marcas marca : marcas) {
                        marca.imprimirModelos();
                    }
                    System.out.println("");
                    break;
                case 2:
                    acaoCliente.buscarModelo(marcas);
                    break;
                case 3:
                    acaoCliente.testDrive(marcas);
                    break;
                case 4:
                    acaoCliente.comprar(clientes, marcas, funcionarios);
                    break;
                case 5:
                    exitCliente = 1;
                    while (exitCliente != 0) {
                        exibirMenuCliente();
                        menuCliente = entrada.nextInt();
                        switch (menuCliente) {
                            case 1:
                                Cliente novoCliente = acaoCliente.adicionarCliente(clientes);
                                clientes.add(novoCliente);
                                break;
                            case 2:
                                for (Cliente cliente : clientes) {
                                    cliente.imprimirInformacoes();
                                }
                                break;
                            case 3:
                                aux.alterarInformacoesCliente(clientes);
                                break;
                            case 4:
                                System.out.println("Retornando ao menu anterior...");
                                exitCliente--;
                                break;
                            default:
                                System.out.println("Opção Inválida! Tente outra");
                                break;
                        }
                    }
                    break;
                case 6:
                    acaoCliente.buscar(clientes);
                    break;
                case 7:
                    exitFuncionario = 1;
                    while (exitFuncionario != 0) {
                        exibirMenuFuncionario();
                        menuFuncionario = entrada.nextInt();
                        switch (menuFuncionario) {
                            case 1:
                                Funcionario novoFuncionario = acaoFuncionario.adicionarFuncionario(funcionarios);
                                funcionarios.add(novoFuncionario);
                                break;
                            case 2:
                                operador.alterarInformacoesFuncionario(funcionarios);
                                break;
                            case 3:
                                for (Funcionario funcionario : funcionarios) {
                                    funcionario.imprimirInformacoes();
                                }
                                break;
                            case 4:
                                acaoFuncionario.demitir(funcionarios);
                                break;
                            case 5:
                                System.out.println("Retornando ao menu anterior...");
                                exitFuncionario--;
                                break;
                            default:
                                System.out.println("Opção Inválida! Tente outra");
                                break;
                        }
                    }
                    break;
                case 8:
                    acaoFuncionario.buscarFuncionario(funcionarios);
                    break;
                case 9:
                    System.out.println("\nSaindo do programa...");
                    Exit--;
                    break;
                default:
                    System.out.println("Opção Inválida! Tente outra");
                    break;
            }
        } while (Exit != 0);
    }

    /*método para exibir um menu com opçoes
     *para execução da classe principal*/
    static void exibirMenu() {
        System.out.println("============ Concessionária ============");
        System.out.println("====|1| Modelos");
        System.out.println("====|2| Buscar Modelos");
        System.out.println("====|3| Testdrive");
        System.out.println("====|4| Comprar");
        System.out.println("====|5| Clientes");
        System.out.println("====|6| Buscar Clientes");
        System.out.println("====|7| Funcionários");
        System.out.println("====|8| Buscar Funcionários");
        System.out.println("====|9| Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
    }

    /*método para exibir um menu com opções
    *para execução de clientes*/
    static void exibirMenuCliente() {
        System.out.println("============ MENU CLIENTE ============");
        System.out.println("====|1| Adicionar Cliente");
        System.out.println("====|2| Imprimir Informações");
        System.out.println("====|3| Alterar Informações");
        System.out.println("====|4| Menu Anterior");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
        System.out.println("");
    }

    /*método para exibir um menu com opções
    *para execução de funcionários*/
    static void exibirMenuFuncionario() {
        System.out.println("============ MENU FUNCIONÁRIO ============");
        System.out.println("====|1| Adicionar Funcionário");
        System.out.println("====|2| Alterar Informações");
        System.out.println("====|3| Imprimir lista de Funcionários");
        System.out.println("====|4| Demitir Funcionário");
        System.out.println("====|5| Menu Anterior");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
        System.out.println("");
    }
}

