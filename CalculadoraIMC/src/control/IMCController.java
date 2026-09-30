/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.event.ActionListener;
import vista.VistaLogin;
import modelo.CalculadoraIMC;
/**
 *
 * @author DAM2
 */
public class IMCController {
    private final CalculadoraIMC modelo;
    private final VistaLogin vista;
    
    public IMCController(VistaLogin vista) {
        this.vista = vista;
        // Para enlazar botón con el método del controlador
        this.vista.getBotonCalcular.addActionListener(new ActionListener() {
        
        }
    }
}
