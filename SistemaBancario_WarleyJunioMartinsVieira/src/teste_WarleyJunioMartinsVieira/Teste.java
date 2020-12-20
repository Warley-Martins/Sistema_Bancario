package teste_WarleyJunioMartinsVieira;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Pessoa.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;
public class Teste {
    private static int opcaoEncerraPrograma = 0;
    private static int quantidadeFuncionalidadesPrograma = 11;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
    ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();
    menuApresentacaoPrograma();
        int opcaoFuncionalidades;
        do{
            do{
                menuFuncionalidadesPrograma();
                opcaoFuncionalidades = Integer.parseInt(input.nextLine());
            }while(opcaoFuncionalidades < opcaoEncerraPrograma
                || opcaoFuncionalidades > quantidadeFuncionalidadesPrograma);
            switch(opcaoFuncionalidades){
                case 1 -> instanciarContaCorrente(contasCorrente);
                case 2 -> instanciarContaPoupanca(contasPoupanca);
                case 3 -> realizarSaqueContaCorrente(contasCorrente);
                case 4 -> realizarSaqueContaPoupanca(contasPoupanca);
                case 5 -> realizarDepositoContaCorrente(contasCorrente);
                case 6 -> realizarDepositoContaPoupanca(contasPoupanca);
                case 7 -> realizarTransferenciaContaCorrente(contasCorrente);
                case 8 -> realizarTransferenciaContaPoupanca(contasPoupanca);
                case 9 -> {
                            var conta = procurarContaCorrente(contasCorrente);
                            printarTodosDadosContaCorrente(conta);
                          }
                case 10 -> {
                            var conta = procurarContaPoupanca(contasPoupanca);
                            printarTodosDadosContaPoupanca(conta);
                          }
                case 11 -> printarCaracteristicasContas();
                default -> finalizarPrograma();
            }
        }while(opcaoFuncionalidades != 0);
    }
    private static void menuApresentacaoPrograma() {
        System.out.print("\tPrograma Sistem Bancario"
                + "\n\tWarley Júnio Martins Vieira"
                + "\n\tProgramação de Computadores 2");
    }
    private static void menuFuncionalidadesPrograma(){
        System.out.print("\nDigite a opção desejada:"
                       + "\n(1). Criar uma nova conta corrente                (2). Criar uma nova conta poupança"
                       + "\n(3). Realizar um saque conta corrente             (4). Realizar um saque conta poupanca"
                       + "\n(5). Realizar um deposito conta corrente          (6). Realizar um deposito conta poupanca"
                       + "\n(7). Realizar uma transferencia conta corrente    (8). Realizar uma transferencia conta poupanca"
                       + "\n(9). Procurar uma conta Corrente                  (10). Procurar uma conta Poupanca: "
                       + "\n(11). Printar taxas e caracteristicas das contas  (0). Encerrar "
                       + "\nOpção desejada: ");
    }
    private static void instanciarContaCorrente(ArrayList<ContaCorrente> contasCorrente) {
        ArrayList<Pessoa> titularesConta = intanciarTitulares();
        System.out.print("Digite o saldo inicial da conta: ");
        var saldo = Double.parseDouble(input.nextLine());
        ContaCorrente contaCorrente = new ContaCorrente(titularesConta, saldo);
        contasCorrente.add(contaCorrente);
        printarTodosDadosContaCorrente(contaCorrente);
    }
    private static void instanciarContaPoupanca(ArrayList<ContaPoupanca> contasPoupanca) {
        ArrayList<Pessoa> titularesConta = intanciarTitulares();
        System.out.print("Digite o saldo inicial da conta: ");
        var saldo = Double.parseDouble(input.nextLine());
                ContaPoupanca contaPoupanca = new ContaPoupanca(titularesConta, saldo);
        contasPoupanca.add(contaPoupanca);
        printarTodosDadosContaPoupanca(contaPoupanca);
    }
    private static ArrayList<Pessoa> intanciarTitulares(){
        ArrayList<Pessoa> titularesConta = new ArrayList<Pessoa>();
        System.out.print("Digite a quantidade de titulares da conta: ");
        var quantidadeTitulares = Integer.parseInt(input.nextLine());
        for(int indiceQuatidadeTitulares = 0; indiceQuatidadeTitulares < quantidadeTitulares; indiceQuatidadeTitulares++){
            System.out.println("\n\tCadastro titular "+(indiceQuatidadeTitulares+1));
            System.out.print("Digite o nome: ");
            var nome = input.nextLine();
            System.out.print("Digite o rg: ");
            var rg = Integer.parseInt(input.nextLine());
            System.out.print("Digite a data de nscimento: ");
            var dataNascimento = input.nextLine();
            titularesConta.add(new Pessoa(rg, nome, dataNascimento));  
        }
        return titularesConta;
    }
    private static ContaCorrente procurarContaCorrente(ArrayList<ContaCorrente> contasCorrente){
        ContaCorrente contaCorrrente;
        do{
            System.out.print("\nDigite o id da conta corrente: ");
            var id = Integer.parseInt(input.nextLine());
            contaCorrrente =  contasCorrente.stream()
                    .filter(cc -> cc.getId() == id)
                    .findFirst()
                    .orElse(null);
            if(contaCorrrente == null){
                System.out.println("\nConta não encontrada!");
            }
        }while(contaCorrrente == null);
        return contaCorrrente;
    }
    private static ContaPoupanca procurarContaPoupanca(ArrayList<ContaPoupanca> contasPoupanca){
        ContaPoupanca contaPoupanca;
        do{
            System.out.print("\nDigite o id da conta poupanca: ");
            var id = Integer.parseInt(input.nextLine());
            contaPoupanca = contasPoupanca.stream()
                    .filter(cp -> cp.getId() == id)
                    .findFirst()
                    .orElse(null);
            if(contaPoupanca == null){
                System.out.println("\nConta não encontrada!");
            }
        }while(contaPoupanca == null);
        return contaPoupanca;
    }
    private static void printarTodosDadosContaCorrente(ContaCorrente contaCorrente ) {
        System.out.println("\n\tConta Corrente:"
                         + "\nTitulares: ");
        for(var titularAuxliar : contaCorrente.getTitularesConta()){
            System.out.println(titularAuxliar.toString());
        }
        System.out.println("\nId: " + contaCorrente.getId()
                         + "\nSaldo: "+ contaCorrente.getSaldo());
    }
    private static void printarTodosDadosContaPoupanca(ContaPoupanca contaPoupanca) {
        System.out.println("\n\tConta Poupanca:"
                         + "\nTitulares: ");
        for(var titularAuxliar : contaPoupanca.getTitularesConta()){
            System.out.println(titularAuxliar.toString());
        }
        System.out.println("\nId: " + contaPoupanca.getId()
                         + "\nSaldo: "+ contaPoupanca.getSaldo());
    }
    private static boolean realizarSaqueContaCorrente(ArrayList<ContaCorrente> contasCorrente) {
        var contaCorrente = procurarContaCorrente(contasCorrente);
        System.out.print("Digite o valor que deseja sacar: ");
        var valorSaque = Double.parseDouble(input.nextLine());
        if(valorSaque <= 0 || valorSaque + ContaCorrente.getTaxaSaqueCaixaEletronico() > contaCorrente.getSaldo()){
            System.out.println("Valor indisponivel");
            return false;
        }
        contaCorrente.sacarValor(valorSaque, ContaCorrente.getTaxaSaqueCaixaEletronico());
        printarTodosDadosContaCorrente(contaCorrente);
        return true;
    }
    private static boolean realizarSaqueContaPoupanca(ArrayList<ContaPoupanca> contasPoupanca) {
        var contaPoupanca = procurarContaPoupanca(contasPoupanca);
        System.out.print("Digite o valor que deseja sacar: ");
        var valorSaque = Double.parseDouble(input.nextLine());
        if(valorSaque <= 0 || valorSaque + ContaPoupanca.getTaxaSaqueCaixaEletronico() > contaPoupanca.getSaldo()){
            System.out.println("Valor indisponivel");
            return false;
        }
        contaPoupanca.sacarValor(valorSaque, ContaPoupanca.getTaxaSaqueCaixaEletronico());
        printarTodosDadosContaPoupanca(contaPoupanca);
        return true;
    }  
    private static boolean realizarDepositoContaCorrente(ArrayList<ContaCorrente> contasCorrente) {
        var contaCorrente = procurarContaCorrente(contasCorrente);
        System.out.print("Digite o valor que deseja depositar: ");
        var valorDeposito = Double.parseDouble(input.nextLine());  
        if(valorDeposito <= 0){
            System.out.println("\nValor indisponivel");
            return false;
        }
        contaCorrente.depositarValor(valorDeposito);
        printarTodosDadosContaCorrente(contaCorrente);
        return true;
    }
    private static boolean realizarDepositoContaPoupanca(ArrayList<ContaPoupanca> contasPoupanca) {
        var contaPoupanca = procurarContaPoupanca(contasPoupanca);
        System.out.print("Digite o valor que deseja depositar: ");
        var valorDeposito = Double.parseDouble(input.nextLine());
        if(valorDeposito <= 0){
            System.out.println("\nValor indisponivel");
            return false;
        }
        contaPoupanca.depositarValor(valorDeposito);
        printarTodosDadosContaPoupanca(contaPoupanca);
        return true;
    }
    private static boolean realizarTransferenciaContaPoupanca(ArrayList<ContaPoupanca> contasPoupanca) {
        System.out.println("\nConta partida: ");
        var contaPoupancaPartida = procurarContaPoupanca(contasPoupanca);
        System.out.println("\nConta destino: ");
        var contaPoupancaDestino = procurarContaPoupanca(contasPoupanca);
        System.out.print("Digite o valor que deseja transferir: ");
        var valorDeposito = Double.parseDouble(input.nextLine());
        if(valorDeposito <= 0 || valorDeposito + ContaPoupanca.getTaxaTransferencia() > contaPoupancaPartida.getSaldo()){
            System.out.println("Valor Indisponivel!");
            return false;
        }
        contaPoupancaPartida.sacarValor(valorDeposito, ContaPoupanca.getTaxaTransferencia());
        contaPoupancaDestino.depositarValor(valorDeposito);
        System.out.println("\nValor Transferido!");
        return true;
    }
    private static boolean realizarTransferenciaContaCorrente(ArrayList<ContaCorrente> contasCorrente) {
        System.out.println("\nConta partida: ");
        var contaCorrentePartida = procurarContaCorrente(contasCorrente);
        System.out.println("\nConta destino: ");
        var contaCorrenteDestino = procurarContaCorrente(contasCorrente);
        System.out.print("Digite o valor que deseja transferir: ");
        var valorDeposito = Double.parseDouble(input.nextLine());
        if(valorDeposito <= 0 || valorDeposito + ContaCorrente.getTaxaTransferencia() > contaCorrentePartida.getSaldo()){
            System.out.println("Valor Indisponivel!");
            return false;
        }
        contaCorrentePartida.sacarValor(valorDeposito, ContaCorrente.getTaxaTransferencia());
        contaCorrenteDestino.depositarValor(valorDeposito);
        System.out.println("\nValor Transferido!");
        return true;    }
    private static void printarCaracteristicasContas() {
        System.out.println("\n\tConta Corrente"
                         + "\nAnuidade: R$" + ContaCorrente.getAnuidade()
                         + "\nTaxa de saque no caixa eletrônico: R$" + ContaCorrente.getTaxaSaqueCaixaEletronico()
                         + "\nTaxa de transfência: R$" + ContaCorrente.getTaxaTransferencia()
                         + "\nQuantidade de contas cadastradas no banco: " + ContaCorrente.getQuantidadeContas());        
        System.out.println("\n\tConta Poupanca"
                         + "\nRendimento anual: %" + ContaPoupanca.getRendimentoAnual()
                         + "\nTaxa de saque no caixa eletrônico: R$" + ContaPoupanca.getTaxaSaqueCaixaEletronico()
                         + "\nTaxa de transfência: R$" + ContaPoupanca.getTaxaTransferencia()
                         + "\nQuantidade de contas cadastradas no banco: " + ContaPoupanca.getQuantidadeContas());
    }
    private static void finalizarPrograma(){
        System.out.println("\nPrograma Encerrado");
    }
}




















