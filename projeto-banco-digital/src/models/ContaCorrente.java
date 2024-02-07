package models;

public class ContaCorrente extends Conta{

    private final String DIGITOCONTACORRENTE = "02";

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.digitoTipoConta = DIGITOCONTACORRENTE;
        super.saldo = 0.0;
    }
 
    @Override
    public void imprimirExtrato() {
        System.out.println("== Conta Corrente ==");
        super.getDados(DIGITOCONTACORRENTE);
    }


    
}
