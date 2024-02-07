package models;

public class ContaPoupanca extends Conta{

    private final String DIGITOCONTAPOUPANCA = "03";

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.digitoTipoConta = DIGITOCONTAPOUPANCA;
        super.saldo = 0.0;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("== Conta Poupança ==");
        super.getDados(DIGITOCONTAPOUPANCA);
    }
    
}
