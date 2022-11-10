import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Procesos {
    double n1,n2,n3;
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
    String nombre;

   // HashMap<String ,ArrayList<Double>> lista = new HashMap<String, ArrayList<Double>>();

    HashMap<String,Double> notasEstudent = new HashMap<String,Double>();
    public Procesos() {
        pedirNotas();
    }



    private void pedirNotas() {
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cuantos estudiantes desea ingresar?"));

        for(int i=0;i<cant;i++){
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");


            do {
                n1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 1"));
                if (n1<0 || n1>5) {
                    JOptionPane.showMessageDialog(null, "La nota 1 debe estar entre 0 y 5");
                }
            }while (n1<0 || n1>5);
           do {
               n2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 2"));
               if (n2<0 || n2>5) {
                   JOptionPane.showMessageDialog(null, "La nota 2 debe estar entre 0 y 5");
               }
           }while (n2<0 || n2>5);

           do {
               n3 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 3"));
               if (n3<0 || n3>5) {
                   JOptionPane.showMessageDialog(null, "La nota 3 debe estar entre 0 y 5");
               }
           }while (n3<0 || n3>5);

            double promedio = (n1+n2+n3)/3;
            if (promedio>=3.5) {
                JOptionPane.showMessageDialog(null, "El estudiante "+nombre+" aprobo con un promedio de "+promedio);
                cantGanan++;
            }else{
                JOptionPane.showMessageDialog(null, "El estudiante "+nombre+" reprobo con un promedio de "+promedio);
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
        imprimirDatos();
        System.out.println("-------------------------------------------------");
        promedioTotal();
        System.out.println("-------------------------------------------------");
        imprimirLitado();
    }

    public void mostrarEstudiantes(){
        System.out.println("Lista de estudiantes :");
        for (String key : notasEstudent.keySet()) {
            System.out.println("Nombre: "+key + " | "+ "Promedio: " + notasEstudent.get(key));
        }
    }
    public void promedioTotal(){
        double promedioTotal = 0;
        for (String key : notasEstudent.keySet()) {
            promedioTotal += notasEstudent.get(key);
        }
        System.out.println("El promedio de las notas finales obtenidas es : "+promedioTotal/notasEstudent.size());

    }


    public void imprimirDatos(){

        System.out.println("Cantidad de estudiantes validados : "+cantEstudiantesValidados);
        System.out.println("Cantidad de notas ingresadas es : "+cantEstudiantesValidados*3);
        System.out.println("Cantidad de estudiantes que ganaron: "+cantGanan);
        System.out.println("Cantidad de estudiantes que perdieron: "+cantpierden);
        System.out.println("Cantidad de estudiantes que pueden recuperar: "+cantRecupera);
        System.out.println("Cantidad de estudiantes que perdieron sin recuperación: "+cantPierden);
    }

    public void imprimirLitado(){
        mostrarEstudiantes();
    }

}
