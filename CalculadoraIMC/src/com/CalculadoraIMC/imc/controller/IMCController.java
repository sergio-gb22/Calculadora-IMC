/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CalculadoraIMC.imc.controller;
import java.awt.event.ActionListener;
import com.CalculadoraIMC.imc.view.VistaLogin;
import com.CalculadoraIMC.imc.model.CalculadoraIMC;
import java.awt.event.ActionEvent;
/**
 *
 * @author ergio García de Baya
 */
public class IMCController implements ActionListener {
    private final CalculadoraIMC modelo;
    private final VistaLogin vista;

    public IMCController(CalculadoraIMC modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBotonCalcular().addActionListener(this);
    }// Engancha el listener al botón

    public void iniciar() {
        vista.setVisible(true);
    }// Hace visible la ventana

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBotonCalcular()) {
            procesarCalculo();
        }
    }// Se ejecuta al pulsar el botón

    private void procesarCalculo() {

        //Recogemos los textos (ya vienen sin espacios y con la coma sustituida por un punto)
        String pesoString = vista.getPeso();
        String alturaString = vista.getAltura();

        try {
            // pasamos a double el String para obtener el peso y la altura en valor númerico. Si falla, salta NumberFormatException
            double peso = Double.parseDouble(pesoString);
            double altura = Double.parseDouble(alturaString);

            double imc = modelo.calcular(peso, altura);
            

            // Para enseñar el resultado en su valor numérico con 2 decimales
            vista.mostrarResultado(String.format("%.2f", imc));
        } catch (NumberFormatException nfe) {
            System.err.println("Error: Introduce solo números válidos");
        }//El catch solo salta si deja el campo vacio
    }
}
        
