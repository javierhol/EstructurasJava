import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpera extends JFrame implements ActionListener {



    JPanel miPanel;
    private JTextField txtNombre;
    private JTextField txtN1;
    private JTextField txtN2;
    private JTextField txtN3;
    private JButton btnRegis;
    private JButton btnListar;

    private JLabel lblN1;
    private JLabel lblN2;
    private JLabel lblN3;
    private JTabbedPane prom;
  JLabel result;

    Procesos pro = new Procesos();
    public VentanaOpera(){
        initComponents();
        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                double n1 = Double.parseDouble(txtN1.getText());
                double n2 = Double.parseDouble(txtN2.getText());
                double n3 = Double.parseDouble(txtN3.getText());
                pro.pedirNotas(n1,n2,n3,nombre);
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void initComponents(){
        miPanel = new JPanel();

        txtNombre= new JTextField();
       String nombre =txtNombre.getText();


        result = new JLabel();



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
