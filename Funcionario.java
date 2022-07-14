package ProjetoTrilha;

//bibliotecas usadas na classe funcionario
import java.util.ArrayList;
import java.util.Scanner;

public final class Funcionario extends Pessoa {

    //constante referente ao valor da comissão do vendedor
    final double COMISSAO_VENDEDOR = 0.05;

    //atributos da classe funcionario
    protected double salario;

    //variáveis da classe funcionário
    int menuFuncionario;

    //inicializando os scanners para capturar números e strings
    Scanner entradaNumeros = new Scanner(System.in);
    Scanner entradaStrings = new Scanner(System.in);

    //construtor vazio
    public Funcionario() {
    }

    //construtor inicializado
    public Funcionario(String nome, String CPF, char sexo, double salario) {
        super(nome, CPF, sexo);
        this.salario = salario;
    }

    //métodos acessores da classe Funcionario
    //método usado para acessar o salario do funcionario
    public double getSalario() {
        return salario;
    }

    //métodos modificadores da classe Funcionario
    //método usado para modificar o salario do funcionario
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /*método utilizado para alterar informações do funcionário*/
    public void alterarInformacoesFuncionario(ArrayList<Funcionario> funcionarios) {
        /*variáveis criadas para fazer 
        *as alterações das informações de funcionário*/
        String nome_funcionario;
        String cpf_funcionario;
        char sexo_funcionario;
        double salario_funcionario;

        //coletando e reescrevendo as informações do funcionário
        System.out.println("===== ALTERANDO INFORMAÇÕES FUNCIONÁRIO =====");
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario temp = funcionarios.get(i);
            System.out.println("[" + i + "]" + temp.getNome());
        }
        System.out.println("Informe o número referente ao nome: ");
        int referencia = entradaNumeros.nextInt();

        //capturando os novos dados do funcionário selecionado
        System.out.println("Informe o novo nome: ");
        nome_funcionario = entradaStrings.nextLine();
        System.out.println("Informe o novo CPF: ");
        cpf_funcionario = entradaStrings.nextLine();
        System.out.println("Informe o sexo: ");
        sexo_funcionario = entradaStrings.next().charAt(0);
        entradaStrings.nextLine();
        System.out.println("Informe o novo salario: ");
        salario_funcionario = entradaNumeros.nextDouble();

        //criando um funcionário para servir de auxiliar para alterar os dados
        Funcionario a = funcionarios.get(referencia);

        //setando os novos dados do funcionário
        a.setNome(nome_funcionario);
        a.setCpf(cpf_funcionario);
        a.setSexo(sexo_funcionario);
        a.setSalario(salario_funcionario);

        System.out.println("Funcionário atualizado com sucesso!");
    }

    /*método utilizado para imprimir as informações do funcionário*/
    @Override
    public void imprimirInformacoes() {
        System.out.println("======= INFORMAÇÕES FUNCIONÁRIO =======");
        System.out.println("\tNome: " + getNome());
        System.out.println("\tCPF: " + getCpf());
        System.out.println("\tSEXO: " + getSexo());
        System.out.println("\tSALÁRIO: " + getSalario());
        System.out.println("==================================");
        System.out.println("");
    }
}
