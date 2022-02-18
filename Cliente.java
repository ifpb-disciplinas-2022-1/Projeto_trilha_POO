package ProjetoTrilha;

//bibliotecas usadas na classe cliente
import java.util.ArrayList;
import java.util.Scanner;

public final class Cliente extends Pessoa {

    //atributos da classe cliente
    private int idade;
    private double saldoCliente;

    //inicializando os scanners para capturar os números e strings
    Scanner entradaNumeros = new Scanner(System.in);
    Scanner entradaStrings = new Scanner(System.in);

    //métodos da classe cliente
    /*método utilizado para que o cliente
    *possa realizar a compra de algum veículo*/
    public void comprar(ArrayList<Cliente> clientes, ArrayList<Marcas> marcas, ArrayList<Funcionario> funcionarios) {
        //variáveis auxiliares do método
        Marcas comprado = null;
        Cliente comprador = null;
        Funcionario vendedor = null;

        //variáveis booleanas usadas no método
        boolean achouVendedor = false;
        boolean achouCliente = false;
        boolean achouModelo = false;

        System.out.println("===========COMPRAR=========");
        System.out.println("Informe o nome do funcionário: ");
        String funcionarioVendedor = entradaStrings.nextLine();
        for (int k = 0; k < funcionarios.size(); k++) {
            vendedor = funcionarios.get(k);
            if (funcionarioVendedor.equals(vendedor.getNome())) {
                achouVendedor = true;
            }
            break;
        }
        if (achouVendedor == true) {
            System.out.println("Informe o nome do cliente: ");
            String clienteComprador = entradaStrings.nextLine();
            for (int i = 0; i < clientes.size(); i++) {
                comprador = clientes.get(i);
                if (clienteComprador.equals(comprador.getNome())) {
                    achouCliente = true;
                }
                break;
            }
            if (achouCliente == true) {
                System.out.println("Informe o modelo da compra: ");
                String modeloComprado = entradaStrings.nextLine();
                for (int j = 0; j < marcas.size(); j++) {
                    comprado = marcas.get(j);
                    if (modeloComprado.equalsIgnoreCase(comprado.getNome())) {
                        achouModelo = true;
                        if (comprador.saldoCliente >= comprado.getValorVenda()) {
                            comprador.saldoCliente = (comprador.saldoCliente - comprado.getValorVenda());
                            vendedor.salario = vendedor.salario + (comprado.getValorVenda() * vendedor.COMISSAO_VENDEDOR);
                            System.out.println("Compra realizada com sucesso!\n");
                            System.out.println("Comprador: " + comprador.getNome());
                            System.out.println("Vendedor: " + vendedor.getNome());
                            System.out.println("Modelo comprado: " + comprado.getNome() + " " + comprado.getModelo() + " " + comprado.getAnoFabricacao());
                        } else {
                            System.out.println("Saldo insuficiente! Compra não realizada \n");
                            break;
                        }
                    }
                }
                if (!achouModelo) {
                    System.out.println("Modelo não existente! compra não realizada\n");
                }
            } else {
                System.out.println("Cliente não existente! Compra não realizada\n");
            }
        } else {
            System.out.println("Funcionário não existente! Compra não realizada\n");
        }
    }

    /*método utilizado para o cliente realizar
    um teste drive em algum veículo*/
    public void testDrive(ArrayList<Marcas> marcas) {
        boolean encontrado = false;
        System.out.println("==========TESTDRIVE===========");
        System.out.println("Informe o nome do cliente: ");
        String nomeCliente = entradaStrings.nextLine();
        System.out.println("Informe o modelo para testdrive: ");
        String nomeModelo = entradaStrings.nextLine();
        for (int i = 0; i < marcas.size(); i++) {
            Marcas temporario = marcas.get(i);
            if (nomeModelo.equalsIgnoreCase(temporario.getNome())) {
                System.out.println("O cliente " + nomeCliente + " está fazendo testdrive no modelo " + temporario.getNome() + "\n");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Não existe esse modelo \n");
        }
    }

    /*método utilizado para adicionar
    *dinheiro ao saldo do cliente*/
    public void adicionarSaldo(ArrayList<Cliente> clientes) {
        boolean achou = false;
        double valor;
        System.out.println("Informe o cliente que deseja adicionar saldo: ");
        String nome_busca = entradaStrings.nextLine();
        System.out.println("Informe a quantia que deseja adicionar: ");
        valor = entradaNumeros.nextDouble();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente temp = clientes.get(i);
            if (nome_busca.equals(temp.getNome())) {
                temp.saldoCliente = temp.saldoCliente + valor;
                System.out.println("Saldo adicionado com sucesso!");
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Não existe cliente com esse nome");
        }
    }

    //construtor vazio
    public Cliente() {
    }

    //construtor inicializado
    public Cliente(String nome, String cpf, char sexo, int idade, double saldoCliente) {
        super(nome, cpf, sexo);
        this.idade = idade;
        this.saldoCliente = saldoCliente;
    }

    //métodos acessores da classe Cliente
    //método usado para acessar a idade do cliente
    public int getIdade() {
        return idade;
    }

    //método usado para acessar o saldo do cliente
    public double getSaldoCliente() {
        return saldoCliente;
    }

    //métodos modificadores da classe Cliente
    //método usado para modificar a idade do cliente
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //método usado para modificar o saldo do cliente
    public void setSaldoCliente(double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    /*método herdado da classe pessoa que será
    *utilizado para alterar informações do cliente*/
    public void alterarInformacoesCliente(ArrayList<Cliente> clientes) {
        /*variáveis criadas para fazer 
        *as alterações das informações de cliente*/
        String nome_cliente;
        String cpf_cliente;
        char sexo_cliente;
        int idade_cliente;
        double saldo_cliente;

        //coletando e reescrevendo as informações do cliente
        System.out.println("===== ALTERANDO INFORMAÇÕES CLIENTE =====");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente temp = clientes.get(i);
            System.out.println("[" + i + "]" + temp.getNome());
        }
        System.out.println("Informe o número referente ao nome: ");
        int referencia = entradaNumeros.nextInt();

        //capturando os novos dados do cliente selecionado
        System.out.println("Informe o novo nome: ");
        nome_cliente = entradaStrings.nextLine();
        System.out.println("Informe o novo CPF: ");
        cpf_cliente = entradaStrings.nextLine();
        System.out.println("Informe o sexo: ");
        sexo_cliente = entradaStrings.next().charAt(0);
        entradaStrings.nextLine();
        System.out.println("Informe a nova idade: ");
        idade_cliente = entradaNumeros.nextInt();
        System.out.println("Informe o novo saldo: ");
        saldo_cliente = entradaNumeros.nextDouble();

        //criando um cliente para servir de auxiliar na atualização dos dados
        Cliente a = clientes.get(referencia);

        //setando os novos dados para o cliente
        a.setNome(nome_cliente);
        a.setCpf(cpf_cliente);
        a.setSexo(sexo_cliente);
        a.setIdade(idade_cliente);
        a.setSaldoCliente(saldo_cliente);

        System.out.println("Cliente atualizado com sucesso!");
    }

    //método usado para buscar algum cliente pelo nome
    public void buscar(ArrayList<Cliente> clientes) {
        boolean achou = false;
        System.out.println("Informe o nome do cliente que deseja verificar: ");
        String nome_busca = entradaStrings.nextLine();
        for (int i = 0; i < clientes.size(); i++) {
            Cliente temp = clientes.get(i);
            if (nome_busca.equals(temp.getNome())) {
                System.out.println("Cliente encontrado!");
                temp.imprimirInformacoes();
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Não existe cliente com esse nome");
        }
    }

    /*método herdado da classe pessoa que será
    *utilizado para imprimir as informações do cliente*/
    @Override
    public void imprimirInformacoes() {
        System.out.println("======= INFORMAÇÕES CLIENTE =======");
        System.out.println("\tNome: " + getNome());
        System.out.println("\tCPF: " + getCpf());
        System.out.println("\tSEXO: " + getSexo());
        System.out.println("\tIDADE: " + getIdade());
        System.out.println("\tSALDO: " + getSaldoCliente());
        System.out.println("==================================");
        System.out.println("");
    }

    /*método herdado da classe pessoa que sera
    *utilizado para adicionar clientes ao arraylist clientes*/
    public Cliente adicionarCliente(ArrayList<Cliente> clientes) {
        //capturando informações do cliente
        System.out.println("====== ADICIONAR CLIENTE =======");
        System.out.println("Informe o Nome: ");
        String nome_cliente = entradaStrings.nextLine();
        System.out.println("Informe o CPF: ");
        String cpf_cliente = entradaStrings.nextLine();
        System.out.println("Informe o Sexo: ");
        char sexo_cliente = entradaStrings.next().charAt(0);
        entradaStrings.nextLine();
        System.out.println("Informe a Idade: ");
        int idade_cliente = entradaNumeros.nextInt();
        System.out.println("Informe o Saldo: ");
        double saldo_cliente = entradaNumeros.nextDouble();

        //instanciando um novo cliente
        Cliente e = new Cliente();

        //setando as informações do cliente
        e.setNome(nome_cliente);
        e.setCpf(cpf_cliente);
        e.setSexo(sexo_cliente);
        e.setIdade(idade_cliente);
        e.setSaldoCliente(saldo_cliente);

        //adicionando o novo cliente ao arraylist
        return e;
    }

    /*método utilizado para realizar
    *uma busca por algum modelo específico*/
    void buscarModelo(ArrayList<Marcas> marcas) {
        boolean achou = false;
        Marcas temp = null;
        System.out.println("Informe o modelo que deseja pesquisar: ");
        String nome_modelo = entradaStrings.nextLine();
        for (int i = 0; i < marcas.size(); i++) {
            temp = marcas.get(i);
            if (nome_modelo.equalsIgnoreCase(temp.getNome())) {
                achou = true;
                break;
            }
        }
        if (achou) {
            temp.imprimirModelos();
        } else {
            System.out.println("Modelo não encontrado");
        }
    }
}
