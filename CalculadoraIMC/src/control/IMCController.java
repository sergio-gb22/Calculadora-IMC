/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaLogin;
import modelo.CalculadoraIMC;
/**
 *
 * @author DAM2
 */
public class IMCController implements ActionListener {
    private final CalculadoraIMC modelo;
    private final VistaLogin vista;

    public IMCController(CalculadoraIMC modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBotonCalcular().addActionListener(this);
    }// Constructor: guarda referencias y engancha el listener al botón.

    public void iniciar() {
        vista.setVisible(true);
    }// Hace visible la ventana.

    /**
     * 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBotonCalcular()) {
            procesarCalculo();
        }
    }// Se ejecuta al pulsar el botón.

    /**
     * Flujo del cálculo:
     * 1. Recoger los String de la vista.
     * 2. Parsear a double dentro de try-catch.
     * 3. Llamar al modelo.
     * 4. Actualizar la vista con resultado, clasificación y color.
     */
    private void procesarCalculo() {

        // 1. Recogemos los textos (ya vienen sin espacios y con coma → punto)
        String pesoString = vista.getPeso();
        String alturaString = vista.getAltura();

        try {
            // 2. Parseamos a double. Si falla, salta NumberFormatException
            double peso = Double.parseDouble(pesoString);
            double altura = Double.parseDouble(alturaString);

            // 3. Llamamos al modelo
            double imc = modelo.calcular(peso, altura);
            String clasificacion = modelo.clasificar(imc);

            // 4. Mostramos el resultado numérico con 2 decimales
            vista.mostrarResultado(String.format("Tu IMC es: %.2f", imc));

            // Elegimos color según clasificación (reto adicional)
            Color color;
            switch (clasificacion) {
                case "Peso Normal":
                    color = new Color(0, 128, 0); // verde
                    break;
                case "Bajo Peso":
                case "Sobrepeso":
                    color = Color.YELLOW;
                    break;
                default: // Obesidad
                    color = Color.RED;
                    break;
            }
            vista.mostrarClasificacion(clasificacion, color);

        } catch (NumberFormatException nfe) {
            // Si el texto no es un número válido (campo vacío, etc.)
            vista.mostrarError("Error: Introduce solo números válidos");
        }
    }
}
