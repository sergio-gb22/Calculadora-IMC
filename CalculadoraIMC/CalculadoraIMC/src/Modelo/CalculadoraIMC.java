/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Sergio garcía de Baya
 */
public class CalculadoraIMC {

    public double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String clasificar(double imc) {
        if (imc < 18.5) {
            return "Bajo Peso";
        } else if (imc < 25.0) {
            return "Peso Normal";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}