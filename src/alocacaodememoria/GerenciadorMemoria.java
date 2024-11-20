/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alocacaodememoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jaque
 */
public class GerenciadorMemoria {
    
    private List<Pagina> paginas;
    private int tamanhoPagina;
    private int totalPaginas;

    public GerenciadorMemoria(int tamanhoMemoria, int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
        this.totalPaginas = tamanhoMemoria / tamanhoPagina;
        this.paginas = new ArrayList<>();

        for (int i = 0; i < totalPaginas; i++) {
            paginas.add(new Pagina(i));
        }
    }

    public Map<Integer, List<Pagina>> alocar(Processo processo) {
        int paginasNecessarias = (int) Math.ceil((double) processo.tamanho / tamanhoPagina);
        Map<Integer, List<Pagina>> alocacao = new HashMap<>();

        for (int i = 0; i < paginas.size() && paginasNecessarias > 0; i++) {
            if (!paginas.get(i).ocupada) {
                paginas.get(i).ocupada = true;
                processo.paginasAlocadas.add(paginas.get(i));
                paginasNecessarias--;

                alocacao.put(processo.hashCode(), processo.paginasAlocadas);
            }
        }

        return alocacao;
    }

    public void liberar(Processo processo) {
        for (Pagina pagina : processo.paginasAlocadas) {
            pagina.ocupada = false;
        }
        processo.paginasAlocadas.clear();
        System.out.println("Memória liberada para o processo: " + processo.nome);
    }

    public void mostrarEstadoMemoria() {
        System.out.println("Estado da Memória:");
        for (Pagina pagina : paginas) {
            System.out.print((pagina.ocupada ? "X" : "O") + " ");
        }
        System.out.println();
    }
    
}
