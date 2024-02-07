import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Cliente> clientes = new ArrayList();
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            Cliente aux = new Cliente(gerarAleatorio(10,false), gerarAleatorio(8,false), gerarAleatorio(20,false), gerarAleatorio(10,true)); 
            clientes.add(aux);
        }

        for (Cliente cliente : clientes) {
            Integer choice = random.nextInt(100);
            if(choice%2==0){
                Conta newConta = new ContaCorrente(cliente);
                newConta.depositar((10000 - 1000)*random.nextDouble() + 1000);
                newConta.imprimirExtrato();
            }else{
                Conta newConta = new ContaPoupanca(cliente);
                newConta.depositar((10000 - 1000)*random.nextDouble() + 1000);
                newConta.imprimirExtrato();
            }
        }
        
    }

    public static String gerarAleatorio(int tamanho, boolean isNumber){
        Random random = new Random();
        String aleatorio = "";
        for (int i = 0; i < tamanho; i++) {
            if(isNumber){
                aleatorio += random.nextInt(1,9);
            }else{
                aleatorio += (char) random.nextInt(65,90);
            }
        }
        return aleatorio;
    }
}
