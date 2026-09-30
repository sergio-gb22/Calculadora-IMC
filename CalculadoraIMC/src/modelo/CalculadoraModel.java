/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sergio García de Baya
 */
public class CalculadoraModel {
    private double peso ;
    private double altura;
    
    public CalculadoraModel(double peso, double altura) {
    this.peso = peso;
    this.altura = altura;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;               
    }
}
