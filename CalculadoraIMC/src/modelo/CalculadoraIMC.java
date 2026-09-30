/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author DAM2
 */
public class CalculadoraIMC {
    public double calcular(double peso, double altura){
        double imc;
        imc = peso / (altura * altura);
        return imc;
    }
    public String clasificar(double imc){
        String peso;
        
        if (imc < 18.5) { 
            peso = "Bajo Peso"; 
        } else if (imc < 25.0) {
            peso = "Peso Normal"; 
        } else if (imc < 30.0) {
            peso = "Sobrepeso"; 
        } else { 
            peso = "Obesidad"; 
        } 
        return peso;
    }
}
