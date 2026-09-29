/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author garci
 */
import Controlador.IMCController;
import Vista.VistaLogin;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaLogin vista = new VistaLogin();
            new IMCController(vista);
            vista.setVisible(true);
        });
    }
}
