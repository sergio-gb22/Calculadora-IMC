/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author garci
 */
import Modelo.CalculadoraIMC;
import Vista.VistaLogin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCController {

    // Variables miembro para los componentes de la Vista
    private final VistaLogin vista;
    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    public IMCController(VentanaIMC vista) {
        this.vista = vista;
        // Enlazamos el botón con el método del controlador
        this.vista.btnCalculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = vista.txtPeso.getText().trim();
        String alturaStr = vista.txtAltura.getText().trim();

        try {
            // Parseo (puede lanzar NumberFormatException)
            double peso = Double.parseDouble(pesoStr.replace(',', '.'));
            double altura = Double.parseDouble(alturaStr.replace(',', '.'));

            // Llamadas al Modelo
            double imc = calculadora.calcular(peso, altura);
            String clasificacion = calculadora.clasificar(imc);

            // Actualizar la Vista
            vista.lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
            vista.lblClasificacion.setText("Clasificación: " + clasificacion);

            // Reto adicional: color según clasificación
            switch (clasificacion) {
                case "Peso Normal":
                    vista.lblClasificacion.setForeground(Color.GREEN.darker());
                    break;
                case "Bajo Peso":
                case "Sobrepeso":
                    vista.lblClasificacion.setForeground(Color.ORANGE.darker());
                    break;
                case "Obesidad":
                    vista.lblClasificacion.setForeground(Color.RED);
                    break;
            }

        } catch (NumberFormatException ex) {
            
            vista.lblResultado.setText("Error: Introduce solo números válidos");
            vista.lblClasificacion.setText("Clasificación: --");
            vista.lblClasificacion.setForeground(Color.BLACK);
            return;
        }
    }
}