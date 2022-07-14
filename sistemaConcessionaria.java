package ProjetoTrilha;

import java.util.ArrayList;

public interface sistemaConcessionaria {
    //métodos referentes aos clientes no sistema da concessionaria
    public abstract void comprar(ArrayList<Cliente>clientes, ArrayList<Marcas>marcas, ArrayList<Funcionario>funcionarios);
    public abstract void testDrive(ArrayList<Marcas>marcas);
    public abstract void buscar(ArrayList<Cliente>clientes);
    public abstract Cliente adicionarCliente(ArrayList<Cliente>clientes);
    public abstract void buscarModelo(ArrayList<Marcas>marcas);
    
    //métodos referentes aos funcionários no sistema da concessionaria
    public abstract void demitir(ArrayList<Funcionario>funcionarios);
    public abstract void buscarFuncionario(ArrayList<Funcionario>funcionarios);
    public abstract Funcionario adicionarFuncionario(ArrayList<Funcionario>funcionarios);
}
