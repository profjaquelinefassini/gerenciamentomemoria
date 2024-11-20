/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alocacaodememoria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaque
 */
public class Processo {
    
    String nome;
    int tamanho;  // em bytes
    List<Pagina> paginasAlocadas;

    public Processo(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.paginasAlocadas = new ArrayList<>();
    }
    
}
