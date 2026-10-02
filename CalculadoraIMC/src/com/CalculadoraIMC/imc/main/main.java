/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.CalculadoraIMC.imc.main;

import com.CalculadoraIMC.imc.controller.IMCController;
import com.CalculadoraIMC.imc.view.VistaLogin;

/**
 *
 * @author Sergio García de Baya
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaLogin ventana = new VistaLogin(); // creo la ventana

        IMCController control = new IMCController(ventana); // le paso la ventana al controlador

        control.iniciar(); // arranco la aplicacion
    }
}