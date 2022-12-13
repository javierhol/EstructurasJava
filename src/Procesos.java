import java.util.HashMap;
public class Procesos {
 Ventanita miVentanita = new Ventanita();
    int cantGanan=0, cantpierden=0, cantRecupera=0, cantPierden=0 ,cantEstudiantesValidados=0;
    HashMap<String,Double> notasEstudent = new HashMap<String,Double>();
    public void pedirNotas(double n1, double n2, double n3, String nombre) {

            double promedio = (n1+n2+n3)/3;
            if (promedio>=3.5) {
               miVentanita.result1.setText( "El estudiante "+nombre+" aprobo con un promedio de "+promedio);
                cantGanan++;
            }else{
                miVentanita.result1.setText( "El estudiante "+nombre+" reprobo con un promedio de "+promedio);
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
        System.out.println("Lista de estudiantes :");
        for (String key : notasEstudent.keySet()) {
            miVentanita.result2.setText("Nombre: "+key + " | "+ "Promedio: " + notasEstudent.get(key));
        }
    }
    public void promedioTotal(){
        double promedioTotal = 0;
        for (String key : notasEstudent.keySet()) {
            promedioTotal += notasEstudent.get(key);
        }
        miVentanita.result3.setText("El promedio de las notas finales obtenidas es : "+promedioTotal/notasEstudent.size());
    }
    public void imprimirDatos(){
        miVentanita.result4.setText("Cantidad de estudiantes validados : "+cantEstudiantesValidados);
        miVentanita.result5.setText("Cantidad de notas ingresadas es : "+cantEstudiantesValidados*3);
        miVentanita.result6.setText("Cantidad de estudiantes que ganaron: "+cantGanan);
        miVentanita.result7.setText("Cantidad de estudiantes que perdieron: "+cantpierden);
        miVentanita.result8.setText("Cantidad de estudiantes que pueden recuperar: "+cantRecupera);
        miVentanita.result9.setText("Cantidad de estudiantes que perdieron sin recuperación: "+cantPierden);
        promedioTotal();
        mostrarEstudiantes();
    }
}
