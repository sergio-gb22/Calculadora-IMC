/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.CalculadoraIMC.imc.main;
import com.CalculadoraIMC.imc.controller.IMCController;
import com.CalculadoraIMC.imc.view.VistaLogin;
import com.CalculadoraIMC.imc.model.CalculadoraIMC;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 *
 * @author Sergio García de Baya
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Modelo
            CalculadoraIMC modelo = new CalculadoraIMC();

            // 2. Vista
            VistaLogin vista = new VistaLogin();

            // 3. Controlador (engancha el listener al botón)
            IMCController controlador = new IMCController(modelo, vista);

            // 4. Arrancar interfaz
            controlador.iniciar();
    }
    
}
