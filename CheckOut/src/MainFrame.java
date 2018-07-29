import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.javatuples.Pair;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainFrame {

	private JFrame frame;
	private JTextField textFieldNumeroTarjeta;
	private JTextField textFieldCodigo;
	private JTextField textFieldMonto;
	private JComboBox<String> comboBoxComercio = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNumero = new JLabel("NUMERO");
		lblNumero.setBounds(10, 11, 66, 14);
		frame.getContentPane().add(lblNumero);

		textFieldNumeroTarjeta = new JTextField();
		textFieldNumeroTarjeta.setBounds(127, 8, 220, 20);
		frame.getContentPane().add(textFieldNumeroTarjeta);
		textFieldNumeroTarjeta.setColumns(10);

		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblCodigo);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(127, 58, 66, 20);
		frame.getContentPane().add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel lblComercio = new JLabel("COMERCIO");
		lblComercio.setBounds(10, 115, 66, 14);
		frame.getContentPane().add(lblComercio);
		
		ArrayList<Pair<Integer,String>> comercios = ObtencionDatos.getComercios();
		ArrayList<Integer> nrosComercios = new ArrayList<Integer>();
		
		for (Pair<Integer, String> comercio : comercios) {
			
			comboBoxComercio.addItem(comercio.getValue1());
			nrosComercios.add(comercio.getValue0());
			
		}

		comboBoxComercio.setBounds(127, 112, 220, 20);
		frame.getContentPane().add(comboBoxComercio);
		
		JLabel lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblMonto);

		textFieldMonto = new JTextField();
		textFieldMonto.setBounds(127, 137, 86, 20);
		frame.getContentPane().add(textFieldMonto);
		textFieldMonto.setColumns(10);

		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.setBounds(171, 227, 100, 23);
		frame.getContentPane().add(btnComprar);

		btnComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String numeroTarjeta = textFieldNumeroTarjeta.getText();
				String codSeguridad = textFieldCodigo.getText();
				double monto = Double.parseDouble(textFieldMonto.getText());
				int nroComercio = nrosComercios.get(comboBoxComercio.getSelectedIndex());

				Comprador.realizarCompra(numeroTarjeta, codSeguridad, monto, nroComercio);

			}

		});

	}
	
	

}
