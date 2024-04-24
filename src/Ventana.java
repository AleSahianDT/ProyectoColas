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
    private javax.swing.JScrollPane JScrollPane;
    private JButton buscarPorMarcaButton;
    private JTextArea textArea2;
    private JScrollPane JScrollPane2;
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
        matricularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Vehiculo v = matriculas.desencolar();
                    JOptionPane.showMessageDialog(null,v.toString()+
                            "\n Valor de la matricula "+v.calcularValorMatricula());
                    textArea1.setText(matriculas.listarVehiculos());

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        buscarPorMarcaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = matriculas.listarVehiculosMarca(comboMarca.getSelectedItem().toString());
                if(mensaje.equals(""))
                    JOptionPane.showMessageDialog(null,"No existen vehiculos de tal marca");
                else
                    textArea2.setText(mensaje);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,600);
        frame.setVisible(true);
    }
    public void limpiarCampos(){
        textPropietario.setText("");
        textAnio.setText("");
        comboMarca.setSelectedIndex(0);
    }
}
