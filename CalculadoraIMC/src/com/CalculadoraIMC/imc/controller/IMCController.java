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
 * @author Sergio García de Baya
 */
public class IMCController implements ActionListener {

    // variable miembro para la vista
    private final VistaLogin vista;

    // instancio el modelo directamente aquí, como pide el enunciado
    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    public IMCController(VistaLogin vista) {
        this.vista = vista;
        this.vista.getBotonCalcular().addActionListener(this);
    }// Engancha el listener al botón (es decir el listener se activa cuando hay un evento en este caso pulsar el boton y llama al metodo)

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

        // recojo los String de los campos de la vista
        String pesoString = vista.getPeso();
        String alturaString = vista.getAltura();

        try {
            // parseo los textos a double.
            // si el texto no es un número, salta NumberFormatException
            double peso = Double.parseDouble(pesoString);
            double altura = Double.parseDouble(alturaString);

            // compruebo que no sean cero ni negativos.
            // si lo son, muestro error y salgo del método
            if (peso <= 0 || altura <= 0) {
                vista.mostrarError("El peso y la altura deben ser mayores que cero");
                return;
            }

            // llamo al modelo para calcular y clasificar
            double imc = calculadora.calcular(peso, altura);
            String clasificacion = calculadora.clasificar(imc);

            // actualizo la vista: escribo en txtResultado y txtClasificacion
            vista.mostrarResultado(String.format("%.2f", imc));
            vista.mostrarClasificacion(clasificacion);

        } catch (NumberFormatException nfe) {
            // si algo falla al parsear, muestro error y termino el método
            vista.mostrarError("Introduce solo números válidos");
        }
    }
}