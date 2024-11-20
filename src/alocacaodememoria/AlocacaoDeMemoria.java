/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alocacaodememoria;

/**
 *
 * @author jaque
 */
public class AlocacaoDeMemoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int tamanhoMemoria = 64; // 64 bytes
        int tamanhoPagina = 16; // 16 bytes

        GerenciadorMemoria gerenciador = new GerenciadorMemoria(tamanhoMemoria, tamanhoPagina);

        Processo p1 = new Processo("Processo 1", 30);
        Processo p2 = new Processo("Processo 2", 35);

        gerenciador.alocar(p1);
        gerenciador.mostrarEstadoMemoria();

        gerenciador.alocar(p2);
        gerenciador.mostrarEstadoMemoria();

        gerenciador.liberar(p1);
        gerenciador.mostrarEstadoMemoria();

        gerenciador.liberar(p2);
        gerenciador.mostrarEstadoMemoria();
    }
    
}
