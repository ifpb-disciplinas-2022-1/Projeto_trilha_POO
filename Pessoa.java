package ProjetoTrilha;

public abstract class Pessoa implements VisualizarInformacoes{

    //atributos da classe pessoa
    private String nome;
    private String cpf;
    private char sexo;

    //construtor vazio para a classe pessoa
    public Pessoa() {
    }

    //construtor inicializado para a classe pessoa
    public Pessoa(String nome, String cpf, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    //métodos acessores da clasee pessoa
    //método usado para acessar o noma da pessoa
    public String getNome() {
        return nome;
    }

    //método usado para acessar o cpf da pessoa
    public String getCpf() {
        return cpf;
    }

    //método usado para acessar o sexo da pessoa
    public char getSexo() {
        return sexo;
    }

    //métodos modificadores da classe pessoa
    //método usado para modificar o nome da pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }

    //método usado para modificar o cpf da pessoa
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //método usado para modificar o sexo da pessoa
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //método usado para imprimir as informações da pessoa
    public abstract void imprimirInformacoes();
}
