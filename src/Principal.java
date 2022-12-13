import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventanita");
        frame.setContentPane(new Ventanita().miPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,500);
    }
}