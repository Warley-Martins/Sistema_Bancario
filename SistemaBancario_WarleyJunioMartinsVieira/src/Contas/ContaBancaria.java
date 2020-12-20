package Contas;
import Pessoa.Pessoa;
import java.util.ArrayList;
public class ContaBancaria {
    private double saldo;
    private static int quantidadeContas = 0;
    private final int id;
    private ArrayList<Pessoa> titularesConta = new ArrayList<Pessoa>();
    public ContaBancaria(ArrayList<Pessoa> titularesConta, double saldo) {
        quantidadeContas++;
        this.id = quantidadeContas;
        this.saldo = saldo;
        this.titularesConta = titularesConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public static int getQuantidadeContas() {
        return quantidadeContas;
    }
    public ArrayList<Pessoa> getTitularesConta() {
        return titularesConta;
    }
    public void setTitularesConta(Pessoa novoTitularesConta) {
        this.titularesConta.add(novoTitularesConta);
    }
    public int getId(){
        return this.id;
    }
    public void depositarValor(double valorDeposito){
        setSaldo(getSaldo() + valorDeposito);
    }
}













