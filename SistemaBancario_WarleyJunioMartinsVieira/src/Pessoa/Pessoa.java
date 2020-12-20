package Pessoa;
public class Pessoa {
    private int rg;
    private String nome;
    private String dataNascimento;
    public Pessoa(int rg, String nome, String dataNascimento) {
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public int getRg() {
        return rg;
    }
    public void setRg(int rg) {
        this.rg = rg;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    @Override
    public String toString() {
        return "Nome:\t\t\t"+nome+"\nIdentidade:\t\t"+
               rg+"\nData nascimento:\t"+dataNascimento;
    }
    
}


