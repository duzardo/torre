/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.torrehanoi;

/**
 *
 * @author ZaiaPai
 */
import java.util.Scanner;

public class Pilha {
  private No Topo;
  private int tamanho;
  private String nome;
  
  
  public Pilha() 
  {
    this.Topo = null;
  }

  
  public int tamanho()
  {
      return this.tamanho;
  }
  
    public Pilha(String nome) {
        this.Topo = null;
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
  public void inserir(int dado) {
    No no = new No(dado);

    if (Topo == null) {
      Topo = no;
    } else {
      no.setProximo(Topo);
      Topo = no;
    }
    tamanho++;
  }

  public Integer remover() {
    No temporaria = Topo;
    Integer dadoRemovido = temporaria.getDado();

    Topo = temporaria.getProximo();
    temporaria = null;

    return dadoRemovido;
  }

  public void imprimir() {
    No atual = Topo;

    if (atual == null) {
      System.out.println("-");
        System.out.println("\n");
    } else {
      while (atual != null) {
        System.out.print(atual.getDado() + ",  ");
        atual = atual.getProximo();
      }

      System.out.println(" ");
    }
  }
  public boolean EstaVazio()
    {
        return(Topo == null);
    }

  public boolean vitoria_crescente(int tamanhoPilha) {
    No atual = Topo;
    int verifica = 1;

    if (Topo == null) {
      return false;
    }
    if(Topo.getProximo()==null)
    {
        return false;
    }

    while (atual.getProximo() != null) {

      if (atual.getDado() > atual.getProximo().getDado()) {
        return false;
      }
      atual = atual.getProximo();
      verifica++;
    }

    return verifica == tamanhoPilha;
  }

  public boolean vitoria_decrescente(int tamanhoPilha) {
    No atual = Topo;
    int verifica = 1;
    
    if (Topo == null)
    {
      return false;
    }
    if(Topo.getProximo()==null)
    {
        return false;
    }

    while (atual.getProximo() != null) {

      if (atual.getDado() < atual.getProximo().getDado()) {
        return false;
      }
      atual = atual.getProximo();
      verifica++;
    }

    return verifica == tamanhoPilha;
  }

 
}
