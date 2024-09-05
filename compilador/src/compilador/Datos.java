package compilador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Datos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		System.out.println("Mensaje de prueba");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datos frame = new Datos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public Datos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 1116, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compilador en java");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBounds(237, 11, 537, 169);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nueva variable");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                // Muestra un cuadro de diálogo para ingresar una palabra
	                String palabra = JOptionPane.showInputDialog(Datos.this, "Ingrese una palabra:");

	                // Verifica la palabra ingresada
	                if (verificarPalabra(palabra)) {
	                    // Si la palabra es válida, solicita al usuario que ingrese un nuevo valor
	                    String nuevoValor = JOptionPane.showInputDialog(Datos.this, "Ingrese el valor para la variable " + palabra + ":");

	                    // Notifica al usuario que la variable ha sido guardada
	                    JOptionPane.showMessageDialog(Datos.this, "Variable " + palabra + " guardada con el valor: " + nuevoValor);
	                } else {
	                    // Si la palabra no es válida, muestra un mensaje de error
	                    JOptionPane.showMessageDialog(Datos.this, "La palabra ingresada no cumple con las reglas.");
	                }
	            }
	        });
		btnNewButton.setBounds(58, 200, 155, 23);
		panel.add(btnNewButton);
		
		JButton btnEliminarVariable = new JButton("Eliminar variable");
		btnEliminarVariable.setBounds(58, 251, 155, 23);
		panel.add(btnEliminarVariable);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnalizar.setBounds(58, 353, 155, 23);
		panel.add(btnAnalizar);
		
		JButton btnVerTabla = new JButton("Ver tabla");
		btnVerTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerTabla.setBounds(58, 302, 155, 23);
		panel.add(btnVerTabla);
	}

    public static boolean verificarPalabra(String palabra) {
        // Verifica que la palabra no sea nula y tenga al menos dos caracteres
        if (palabra == null || palabra.length() < 2) {
            return false;
        }

        // Verifica que el primer símbolo sea '$'
        if (palabra.charAt(0) != '$') {
            return false;
        }

        // Verifica que el segundo símbolo sea una letra mayúscula
        char segundoSimbolo = palabra.charAt(1);
        if (!Character.isUpperCase(segundoSimbolo)) {
            return false;
        }

        // Verifica que los caracteres restantes sean letras minúsculas o números
        for (int i = 2; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (!Character.isLowerCase(c) && !Character.isDigit(c)) {
                return false;
            }
        }

        // Si todas las verificaciones pasaron, la palabra es válida
        return true;
        
    }
}

