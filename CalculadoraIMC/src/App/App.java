/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package App;

import control.IMCController;
import modelo.CalculadoraIMC;
import vista.VistaLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author DAM2
 */

public class App {

    public static void main(String[] args) {

        // Look and feel nativo del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        // Todo Swing debe ejecutarse en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // 1. Modelo
            CalculadoraIMC modelo = new CalculadoraIMC();

            // 2. Vista
            VistaLogin vista = new VistaLogin();

            // 3. Controlador (engancha el listener al botón)
            IMCController controlador = new IMCController(modelo, vista);

            // 4. Arrancar interfaz
            controlador.iniciar();
        });
    }
}