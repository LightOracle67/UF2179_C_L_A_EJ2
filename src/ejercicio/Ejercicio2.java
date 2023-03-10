package ejercicio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = -296511301297866340L;
	private JPanel contentPane;
	private JTextField txtFld_Matricula;
	private JTextField txtFld_Marca;
	private JTextField txtFld_KMS;
	private JTextField txtFld_Modelo;
	private JTable table;
	private List<Autocar> listaAutocares;
	private JSpinner spinner_Plazas;
	private Integer plazas;
	private double kms;
	private String matricula;
	private String marca;
	private String modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 frame = new Ejercicio2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		listaAutocares = new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow]", "[36.00][][][][][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel, "cell 0 0 4 1,grow");
		panel.setLayout(new MigLayout("", "[][][grow][][]", "[36.00]"));
		
		JLabel lblGestinAutocares = new JLabel("Gesti??n Autocares");
		lblGestinAutocares.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblGestinAutocares, "cell 0 0 5 1,alignx left,aligny center");
		lblGestinAutocares.setBackground(Color.DARK_GRAY);
		lblGestinAutocares.setForeground(Color.WHITE);
		
		JLabel lblMatrcula = new JLabel("Matr??cula: ");
		contentPane.add(lblMatrcula, "cell 0 1,alignx trailing");
		
		txtFld_Matricula = new JTextField();
		contentPane.add(txtFld_Matricula, "cell 1 1,growx");
		txtFld_Matricula.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		contentPane.add(lblMarca, "cell 0 2,alignx trailing");
		
		txtFld_Marca = new JTextField();
		contentPane.add(txtFld_Marca, "cell 1 2,growx");
		txtFld_Marca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		contentPane.add(lblModelo, "cell 2 2");
		
		txtFld_Modelo = new JTextField();
		contentPane.add(txtFld_Modelo, "cell 3 2,growx");
		txtFld_Modelo.setColumns(10);
		
		JLabel lblKilmetros = new JLabel("Kil??metros:");
		contentPane.add(lblKilmetros, "cell 0 3,alignx trailing");
		
		txtFld_KMS = new JTextField();
		contentPane.add(txtFld_KMS, "cell 1 3,growx");
		txtFld_KMS.setColumns(10);
		
		JLabel lblPlazas = new JLabel("Plazas: ");
		contentPane.add(lblPlazas, "cell 2 3");
		
		spinner_Plazas = new JSpinner();
		spinner_Plazas.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spinner_Plazas, "cell 3 3,alignx left");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 4 4 1,alignx center,growy");
		panel_1.setLayout(new MigLayout("", "[grow]", "[]"));
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validaDatos();
			}
		});
		panel_1.add(btnInsertar, "flowx,cell 0 0");
		
		JButton btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
		panel_1.add(btnMostrarDatos, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 4 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Marca", "Kil\u00F3metros", "Modelo", "Plazas"
			}
		) {
			private static final long serialVersionUID = -3649792137276956655L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}

	protected void mostrarDatos() {
		DefaultTableModel modelo1 = (DefaultTableModel) table.getModel();
		modelo1.setRowCount(0)
		;
		for (Autocar auto : listaAutocares) {
			Object fila[] = {
					auto.getMarca(),auto.getModelo(),auto.getKms(),auto.getPlazas(),auto.getMatricula()
					};
			modelo1.addRow(fila);	
		}
	}

	protected void validaDatos() {
		try {
			 plazas = (Integer) spinner_Plazas.getValue();
			 kms = Double.parseDouble(txtFld_KMS.getText());
			 matricula = txtFld_Matricula.getText();
			 marca = txtFld_Marca.getText();
			 modelo = txtFld_Modelo.getText();
			if(matricula==null||matricula.isBlank()||marca==null||marca.isBlank()||modelo==null||modelo.isBlank()) {
				JOptionPane.showMessageDialog(this, "Alguno de los campos a rellenar est?? vac??o.\nEscr??belos todos, y vuelve a intentarlo.","Faltan datos",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Error, el campo 'Kil??metros' es inv??lido, est?? vac??o, o contiene caracteres no num??ricos","Error cr??tico",JOptionPane.ERROR_MESSAGE);
			return;
		}
// esto es un poco absurdo, si ya lo tienes en integer paa que lo pasas a String
		insertaDatos(matricula,marca,modelo,kms,plazas);
	}

	private void insertaDatos(String matricula,String marca,String modelo,Double kms, Integer plazas) {
		Autocar a = new Autocar(matricula,marca,modelo,kms,plazas);
		if(!listaAutocares.contains(a)) {
			listaAutocares.add(a);
		}else {
			JOptionPane.showMessageDialog(this, "No puedes insertar dos autocares con la misma matr??cula.", "Intento de inserci??n fallido",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
}
