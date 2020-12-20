package Contas;
import Pessoa.Pessoa;
import java.util.ArrayList;
public class ContaCorrente extends ContaBancaria {
    private static double anuidade = 120.00;
    private static double taxaTransferencia = 2.5;
    private static double taxaSaqueCaixaEletronico = 1.5;
    public ContaCorrente(ArrayList<Pessoa> titularesConta, double saldo) {
        super(titularesConta, saldo);
    }
    public static double getAnuidade() {
        return anuidade;
    }
    public static double getTaxaTransferencia() {
        return taxaTransferencia;
    }
    public static double getTaxaSaqueCaixaEletronico() {
        return taxaSaqueCaixaEletronico;
    }
    public void sacarValor(double valorSaque, double taxa){
        setSaldo(getSaldo() - valorSaque - taxa);
    }
}










