package models;

import models.interfaces.IConta;

public abstract class Conta implements IConta{

    protected static final Integer NUMEROAGENCIA = 1;
    private static Integer Sequencial = 1;

    protected String numeroConta;
    protected String digitoTipoConta;
    protected Double saldo;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        numeroConta = gerarNumeroConta();
        Sequencial++;
        this.cliente = cliente;
    }

    private String gerarNumeroConta(){
        Integer SequencialNumeros = Integer.toString(Sequencial).length();
        String conta = "";
        for(int i = 0; i < 9 - SequencialNumeros; i++){
            conta += "0";
        }
        return conta + Sequencial;
    }

    @Override
    public void sacar(Double valor) {
        if(valor > this.saldo){System.out.println("Operação não pode ser efetuada: Valor requerido é maior que o saldo em conta.");}
        else{this.saldo -= valor;}
    }

    @Override
    public void depositar(Double valor) {
        if(valor < 0){System.out.println("Operação não pode ser efetuada: Valor depositado é inválido.");}
        else{this.saldo += valor;}
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) {
        try {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void getDados(String digito){
        System.out.print("Conta: " + this.numeroConta + "-" + digito + "\t");
        System.out.print("Agência: " + NUMEROAGENCIA + "\n");
        System.out.println("Títular: " + this.cliente.getNome() + " " +this.cliente.getSobrenome());
        System.out.printf("Saldo: R$ %.2f\n\n", this.saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getDigitoTipoConta() {
        return digitoTipoConta;
    }

    public void setDigitoTipoConta(String digitoTipoConta) {
        this.digitoTipoConta = digitoTipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente client) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
