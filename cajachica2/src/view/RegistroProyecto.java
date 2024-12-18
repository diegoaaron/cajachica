package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.CajaChica;
import model.Usuario;
import repository.RegistroCajaChicaRepository;
import repository.UsuarioRepository;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class RegistroProyecto extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtdescripcionproyecto;
	private JTextField txtmontoasignado;
	private JTextField txtnombreproyecto;

	private ArrayList<Usuario> usuarioArrayList;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { RegistroProyecto frame = new
	 * RegistroProyecto(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public RegistroProyecto() {

		setTitle("Registro de Proyecto");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 526, 222);
		getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario Asignado");
		lblUsuario.setBounds(12, 28, 123, 24);
		getContentPane().add(lblUsuario);

		JLabel lblMontoAsignado = new JLabel("Monto asignado");
		lblMontoAsignado.setBounds(12, 136, 123, 24);
		getContentPane().add(lblMontoAsignado);

		txtdescripcionproyecto = new JTextField();
		txtdescripcionproyecto.setColumns(10);
		txtdescripcionproyecto.setBounds(192, 101, 165, 24);
		getContentPane().add(txtdescripcionproyecto);

		txtmontoasignado = new JTextField();
		txtmontoasignado.setColumns(10);
		txtmontoasignado.setBounds(192, 137, 165, 24);
		getContentPane().add(txtmontoasignado);

		JButton btnGuardar = new JButton("Guadar");
		btnGuardar.setBounds(388, 27, 105, 27);
		getContentPane().add(btnGuardar);

		JComboBox<Usuario> cbmUsuario = new JComboBox<Usuario>();
		cbmUsuario.setBounds(192, 28, 165, 25);
		getContentPane().add(cbmUsuario);

		JLabel lblMontoAsignado_1 = new JLabel("Nombre Proyecto");
		lblMontoAsignado_1.setBounds(12, 64, 123, 24);
		getContentPane().add(lblMontoAsignado_1);

		txtnombreproyecto = new JTextField();
		txtnombreproyecto.setColumns(10);
		txtnombreproyecto.setBounds(192, 65, 165, 24);
		getContentPane().add(txtnombreproyecto);

		JLabel lblMontoAsignado_1_1 = new JLabel("Descripcion Proyecto");
		lblMontoAsignado_1_1.setBounds(12, 100, 155, 24);
		getContentPane().add(lblMontoAsignado_1_1);

		// metodos
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				usuarioArrayList = new UsuarioRepository().listarUsuarios();

				cbmUsuario.addItem(new Usuario());
				for (Usuario usuario : usuarioArrayList) {
					cbmUsuario.addItem(usuario);
				}
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CajaChica registroCajaChicaModel = new CajaChica();

				Usuario usuarioSeleccionado = (Usuario) cbmUsuario.getSelectedItem();

				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
				String fecha_registro = fechaActual.format(formato);

				if (usuarioSeleccionado != null) {

					int usuario_id = Integer.valueOf(usuarioSeleccionado.getUsuario_id());
					String nombre_proyecto = txtnombreproyecto.getText();
					String descripcion = txtdescripcionproyecto.getText();
					double monto_asignado = Double.valueOf(txtmontoasignado.getText());
					String fecha_apertura = fecha_registro;

					try {

						registroCajaChicaModel.setUsuario_id(usuario_id);
						registroCajaChicaModel.setNombre_proyecto(nombre_proyecto);
						registroCajaChicaModel.setDescripcion(descripcion);
						registroCajaChicaModel.setMonto_asignado(monto_asignado);
						registroCajaChicaModel.setMonto_gastado(0);
						registroCajaChicaModel.setMonto_cierre(0);
						registroCajaChicaModel.setFecha_apertura(fecha_apertura);
						registroCajaChicaModel.setFecha_cierre("");
						registroCajaChicaModel.setEstado_proyecto("");

						new RegistroCajaChicaRepository().guardar(registroCajaChicaModel);

						JOptionPane.showMessageDialog(null, "caja chica del proyecto creada");

						cbmUsuario.setSelectedIndex(0);
						txtnombreproyecto.setText("");
						txtdescripcionproyecto.setText("");
						txtmontoasignado.setText("");

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario");
				}

			}
		});

	}
}
