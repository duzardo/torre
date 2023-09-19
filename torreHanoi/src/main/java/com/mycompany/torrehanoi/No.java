/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.torrehanoi;

/**
 *
 * @author ZaiaPai
 */
public class No {
    private Integer dado;
    private No proximo;

    public No(){
        this.dado = null;
        this.proximo = null;
    }
    public No(Integer x){
        this.dado = x;
        this.proximo = null;
    }
    
    
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
    
}
