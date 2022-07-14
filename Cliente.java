package ProjetoTrilha;

//bibliotecas usadas na classe cliente
import java.util.ArrayList;
import java.util.Scanner;

public final class Cliente extends Pessoa {

    //atributos da classe cliente
    private int idade;
    protected double saldoCliente;

    //inicializando os scanners para capturar os números e strings
    Scanner entradaNumeros = new Scanner(System.in);
    Scanner entradaStrings = new Scanner(System.in);

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

    /*método utilizado para alterar informações do cliente*/
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

    /*método utilizado para imprimir as informações do cliente*/
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
}