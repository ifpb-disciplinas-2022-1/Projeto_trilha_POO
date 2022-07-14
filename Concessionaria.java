package ProjetoTrilha;

//bibliotecas importadas para usar no código
import java.util.Scanner;
import java.util.ArrayList;

public class Concessionaria implements sistemaConcessionaria{
    //scanner para coletar numeros
    Scanner entrada = new Scanner(System.in);
    //scanner para coletar strings
    Scanner entradaString = new Scanner(System.in);
    
    /*método utilizado para que o cliente
    possa realizar a compra de algum veiculo*/
    @Override
    public void comprar(ArrayList<Cliente>clientes, ArrayList<Marcas>marcas, ArrayList<Funcionario>funcionarios){
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
        String funcionarioVendedor = entradaString.nextLine();
        for(int k = 0; k < funcionarios.size(); k++){
            vendedor = funcionarios.get(k);
            if(funcionarioVendedor.equals(vendedor.getNome())){
                achouVendedor = true;
            }
            break;
        }
        if(achouVendedor == true){
            System.out.println("Informe o nome do cliente: ");
            String clienteComprador = entradaString.nextLine();
            for(int i = 0; i < clientes.size(); i++){
                comprador = clientes.get(i);
                if(clienteComprador.equals(comprador.getNome())){
                    achouCliente = true;
                }
                break;
            }
            if(achouCliente == true){
                System.out.println("Informe o modelo da compra: ");
                String modeloComprado = entradaString.nextLine();
                for(int j = 0; j < marcas.size(); j++){
                    comprado = marcas.get(j);
                    if(modeloComprado.equalsIgnoreCase(comprado.getNome())){
                        achouModelo = true;
                        if(comprador.saldoCliente >= comprado.getValorVenda()){
                            comprador.saldoCliente = (comprador.saldoCliente - comprado.getValorVenda());
                            vendedor.salario = vendedor.salario + (comprado.getValorVenda() * vendedor.COMISSAO_VENDEDOR);
                            System.out.println("Compra realizada com sucesso!\n");
                            System.out.println("Comprador: " + comprador.getNome());
                            System.out.println("Vendedor: " + vendedor.getNome());
                            System.out.println("Modelo Comprado: " + comprado.getNome() + " " + comprado.getModelo() + " " + comprado.getAnoFabricacao());
                        }
                        else{
                            System.out.println("Saldo insuficiente! Compra não realizada \n");
                            break;
                        }
                    }
                }
                if(!achouModelo){
                    System.out.println("Modelo não existente! Compra não realizada\n");
                }
            }
            else{
                System.out.println("Cliente não existente! Compra não realizada\n");
            }
        }
        else{
            System.out.println("Funcionário não existente! Compra não realizada\n");
        }
    }
    
    
    /*método utilizado para que o cliente
    possa realizar um testeDrive em algum veiculo*/
    @Override
    public void testDrive(ArrayList<Marcas>marcas){
        boolean encontrado = false;
        System.out.println("==========TESTDRIVE===========");
        System.out.println("Informe o nome do cliente: ");
        String nomeCliente = entradaString.nextLine();
        System.out.println("Informe o modelo para testdrive: ");
        String nomeModelo = entradaString.nextLine();
        for(int i = 0; i < marcas.size(); i++){
            Marcas temporario = marcas.get(i);
            if(nomeModelo.equalsIgnoreCase(temporario.getNome())){
                System.out.println("O cliente " + nomeCliente + " esta fazendo testDrive no modelo " + temporario.getNome() + "\n");
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Não existe esse modelo \n");
        }
    }
    
    
    /*método utilizado para buscar algum cliente pelo nome*/
    @Override
    public void buscar(ArrayList<Cliente>clientes){
        boolean achou = false;
        System.out.println("Informe o nome do cliente que deseja verificar: ");
        String nome_busca = entradaString.nextLine();
        for(int i = 0; i < clientes.size(); i++){
            Cliente temp = clientes.get(i);
            if(nome_busca.equals(temp.getNome())){
                System.out.println("Cliente encontrado!");
                temp.imprimirInformacoes();
                achou = true;
            }
        }
        if(!achou){
            System.out.println("Não existe cliente com esse nome");
        }
    }
    
    
    /*método utilizado para realizar a adição
    de um novo cliente*/
    @Override
    public Cliente adicionarCliente(ArrayList<Cliente>clientes){
        //capturando informações do cliente
        System.out.println("====== ADICIONAR CLIENTE =======");
        System.out.println("Informe o nome: ");
        String nome_cliente = entradaString.nextLine();
        System.out.println("Informe o CPF: ");
        String cpf_cliente = entradaString.nextLine();
        System.out.println("Informe o sexo: ");
        char sexo_cliente = entradaString.next().charAt(0);
        entradaString.nextLine();
        System.out.println("Informe a idade: ");
        int idade_cliente = entrada.nextInt();
        System.out.println("Informe o saldo: ");
        double saldo_cliente = entrada.nextDouble();
        
        //instanciando um novo cliente
        Cliente e = new Cliente();
        
        //setando as informações do cliente
        e.setNome(nome_cliente);
        e.setCpf(cpf_cliente);
        e.setSexo(sexo_cliente);
        e.setIdade(idade_cliente);
        e.setSaldoCliente(saldo_cliente);
        
        //adicionando o novo cliente no arraylist de clientes
        return e;
    }
    
    
    /*método utilizado para realizar
    uma busca por algum modelo específico*/
    @Override
    public void buscarModelo(ArrayList<Marcas>marcas){
        boolean achou = false;
        Marcas temp = null;
        System.out.println("Informe o modelo que deseja pesquisar: ");
        String nome_modelo = entradaString.nextLine();
        for(int i = 0; i < marcas.size(); i++){
            temp = marcas.get(i);
            if(nome_modelo.equalsIgnoreCase(temp.getNome())){
                achou = true;
                break;
            }
        }
        if(achou){
            temp.imprimirModelos();
        }
        else{
            System.out.println("Modelo não encontrado");
        }
    }
    
    
    /*método utilizado para despedir um 
    funcionário que desejar*/
    @Override
    public void demitir(ArrayList<Funcionario>funcionarios){
        System.out.println("==== DEMITIR FUNCIONÁRIO =====");
        for(int i = 0; i < funcionarios.size(); i++){
            Funcionario temp = funcionarios.get(i);
            System.out.println("[" + i + "]" + temp.getNome());
        }
        System.out.println("Informe um numero referente ao nome: ");
        int demitido = entrada.nextInt();
        
        funcionarios.remove(demitido);
        System.out.println("Funcionário demitido!");
    }
    
    
    /*método utilizado para buscar algum funcionário pelo nome*/
    @Override
    public void buscarFuncionario(ArrayList<Funcionario>funcionarios){
        boolean achou = false;
        System.out.println("Informe o nome do funcionário que deseja verificar: ");
        String nome_busca = entradaString.nextLine();
        for(int i = 0; i < funcionarios.size(); i++){
            Funcionario temp = funcionarios.get(i);
            if(nome_busca.equals(temp.getNome())){
                System.out.println("Funcionário encontrado!");
                temp.imprimirInformacoes();
                achou = true;
                break;
            }
        }
        if(!achou){
            System.out.println("Não existe funcionário com esse nome");
        }
    }
    
    
    /*método utilizado para adicionar
    novos funcionarios ao arraylist funcionários*/
    @Override
    public Funcionario adicionarFuncionario(ArrayList<Funcionario>funcionarios){
        //capturando informações do funcionário
        System.out.println("====== ADICIONAR FUNCIONÁRIO =======");
        System.out.println("Informe o nome: ");
        String nome_funcionario = entradaString.nextLine();
        System.out.println("Informe o CPF: ");
        String cpf_funcionario = entradaString.nextLine();
        System.out.println("Informe o sexo: ");
        char sexo_funcionario = entradaString.next().charAt(0);
        entradaString.nextLine();
        System.out.println("Informe o salário: ");
        double salario_funcionario = entrada.nextDouble();
        
        //instanciando um novo funcionario
        Funcionario e = new Funcionario();
        
        //setando as informações do funcionario
        e.setNome(nome_funcionario);
        e.setCpf(cpf_funcionario);
        e.setSexo(sexo_funcionario);
        e.setSalario(salario_funcionario);
        
        //adicionando o novo funcionario no arraylist de funcionarios
        return e;
    }
}
