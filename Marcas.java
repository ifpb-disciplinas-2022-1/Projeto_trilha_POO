package ProjetoTrilha;

public class Marcas {

    //atributos da classe marcas
    private String nome;
    private String modelo;
    private String cor;
    private String nacionalidade;
    private double valorVenda;
    private int anoFabricacao;

    //métodos da classe marcas
    //Método que imprime todas as informações do modelo
    void imprimirModelos() {
        System.out.println("=======INFORMAÇÕES MODELOS=======");
        System.out.println("\tNome: " + getNome());
        System.out.println("\tModelo: " + getModelo());
        System.out.println("\tCor: " + getCor());
        System.out.println("\tNacionalidade: " + getNacionalidade());
        System.out.println("\tPreço: R$ " + getValorVenda());
        System.out.println("\tAno de fabricação: " + getAnoFabricacao());
        System.out.println("================================");
    }

    //construtor vazio
    public Marcas() {
    }

    //construtor inicializado
    public Marcas(String nome, String modelo, String cor, String nacionalidade, double valorVenda, int ano) {
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
        this.nacionalidade = nacionalidade;
        this.valorVenda = valorVenda;
        this.anoFabricacao = ano;
    }

    //métodos acessores da classe Marcas
    //método usado para acessar o nome da marca
    public String getNome() {
        return nome;
    }

    //método usado para acessar o modelo da marca
    public String getModelo() {
        return modelo;
    }

    //método usado para acessar a cor da marca
    public String getCor() {
        return cor;
    }

    //método usado para acessar a nacionalidade da marca
    public String getNacionalidade() {
        return nacionalidade;
    }

    //método usado para acessar o preço de determinado modelo
    public double getValorVenda() {
        return valorVenda;
    }

    //método usado para acessar o ano de fabricação do modelo
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    //métodos modificadores da classe Marcas
    //método usado para modificar o nome da marca
    public void setNome(String nome) {
        this.nome = nome;
    }

    //método usado para modificar o modelo da marca
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //método usado para modificar a cor da marca
    public void setCor(String cor) {
        this.cor = cor;
    }

    //método usado para modificar a nacionalidade da marca
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    //método usado para modificar o preço de um deternimado modelo
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    //método usado para modificar o ano de fabricação do modelo
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
