import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Ventanita  extends JFrame implements ActionListener {
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
    HashMap<String,Double> notasEstudent = new HashMap<String,Double>();
    public JPanel miPanel;
    private JTextField txtN1;
    private JTextField txtN2;
    private JTextField txtN3;
    private JTextField txtName;
    private JLabel lblName;
    private JLabel lblN1;
    private JLabel lblN3;
    private JLabel lblN2;
    private JButton btnRegistrar;
    private JButton btnImprimir;
    JLabel result1;
    JLabel result2;
    JLabel result3;
    JLabel result4;
    JLabel result5;
    JLabel result6;
   JLabel result7;
  JLabel result8;
   JLabel result9;

    public Ventanita() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double n1 = Double.parseDouble(txtN1.getText());
                double n2 = Double.parseDouble(txtN2.getText());
                double n3 = Double.parseDouble(txtN3.getText());
                String nombre = txtName.getText();

               pedirNotas(n1, n2, n3, nombre);
                txtName.setText("");
                txtN1.setText("");
                txtN2.setText("");
                txtN3.setText("");
            }
        });
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               imprimirDatos();


            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public void pedirNotas(double n1, double n2, double n3, String nombre) {

        double promedio = (n1+n2+n3)/3;
        if (promedio>=3.5) {
            result1.setText( "El estudiante "+nombre+" aprobo con un promedio de "+promedio);
            cantGanan++;
        }else{
          result1.setText( "El estudiante "+nombre+" reprobo con un promedio de "+promedio);
            cantpierden++;
        }
        if (promedio > 2.0 && promedio < 3.5) {
            cantRecupera++;
        }else if (promedio < 2.0) {
            cantPierden++;
        }
        notasEstudent.put(nombre,promedio);
        cantEstudiantesValidados++;
    }
    public void mostrarEstudiantes(){

        for (String key : notasEstudent.keySet()) {
            result2.setText("Nombre: "+key + " | "+ "Promedio: " + notasEstudent.get(key));
        }
    }
    public void promedioTotal(){
        double promedioTotal = 0;
        for (String key : notasEstudent.keySet()) {
            promedioTotal += notasEstudent.get(key);
        }
        result3.setText("El promedio de las notas finales obtenidas es : "+promedioTotal/notasEstudent.size());
    }
    public void imprimirDatos(){
        result4.setText("Cantidad de estudiantes validados : "+cantEstudiantesValidados);
        result5.setText("Cantidad de notas ingresadas es : "+cantEstudiantesValidados*3);
        result6.setText("Cantidad de estudiantes que ganaron: "+cantGanan);
        result7.setText("Cantidad de estudiantes que perdieron: "+cantpierden);
        result8.setText("Cantidad de estudiantes que pueden recuperar: "+cantRecupera);
        result9.setText("Cantidad de estudiantes que perdieron sin recuperación: "+cantPierden);
        promedioTotal();
        mostrarEstudiantes();
    }
}


