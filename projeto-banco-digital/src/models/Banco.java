package models;

import java.util.List;

public class Banco {
    private final String nome = "Banco Desafio Prático";
    private List<Conta> contas;

    public List<Conta> getClientes() {
        return contas;
    }
    
    public void setClientes(List<Conta> clientes) {
        this.contas = clientes;
    }

    public void ListarTodosClientes(){
        for (Conta conta : contas) {
            System.out.printf("Titular: %s\tConta: \tSaldo: R$ %.2f\n", 
                            (conta.getCliente().getNome() + " " + conta.getCliente().getSobrenome()),
                            (conta.getNumeroConta() +"-"+ conta.getDigitoTipoConta()),
                            conta.getSaldo());
        }
    }
}