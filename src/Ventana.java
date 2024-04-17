import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Ventana;
    private JTextField textPropietario;
    private JComboBox comboMarca;
    private JTextField textAnio;
    private JButton agregarALaColaButton;
    private JButton matricularButton;
    private JTextArea textArea1;
    private ColaMatricula matriculas = new ColaMatricula();

    public Ventana(){

        agregarALaColaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matriculas.encolar(textPropietario.getText(),comboMarca.getSelectedItem().toString(),
                    Integer.parseInt(textAnio.getText()));
                textArea1.setText(matriculas.listarVehiculos());
                limpiarCampos();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,400);
        frame.setVisible(true);
    }
    public void limpiarCampos(){
        textPropietario.setText("");
        textAnio.setText("");
        comboMarca.setSelectedIndex(0);
    }
}
