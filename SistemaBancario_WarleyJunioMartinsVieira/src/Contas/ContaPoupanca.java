package Contas;
import Pessoa.Pessoa;
import java.util.ArrayList;
public class ContaPoupanca extends ContaBancaria {
    private static double rendimentoAnual = 0.05;
    private static double taxaTransferencia = 2.3;
    private static double taxaSaqueCaixaEletronico = 1.80;
    public ContaPoupanca(ArrayList<Pessoa> titularesConta, double saldo) {
        super(titularesConta, saldo);
    }
    public static double getRendimentoAnual() {
        return rendimentoAnual;
    }
    public static double getTaxaSaqueCaixaEletronico() {
        return taxaSaqueCaixaEletronico;
    }
    public static double getTaxaTransferencia() {
        return taxaTransferencia;
    }
    public void sacarValor(double valorSaque, double taxa){
        setSaldo(getSaldo() - valorSaque - taxa);
    }
}






