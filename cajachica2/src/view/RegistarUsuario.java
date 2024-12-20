package view;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.RolUsuario;
import controller.RolUsuarioController;
import controller.UsuarioController;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class RegistarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtnombres;
	private JTextField txtapellidos;
	private JTextField txtdnice;
	private JPasswordField txtpassword;
	private JTextField txtcorreo;
	private JTextField txtdireccion;

	/**
	 * Create the frame.
	 */
	public RegistarUsuario() {
		setTitle("Registrar Usuario");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 432, 340);
		getContentPane().setLayout(null);

		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(12, 47, 60, 17);
		getContentPane().add(lblNombres);

		txtnombres = new JTextField();
		txtnombres.setColumns(10);
		txtnombres.setBounds(170, 45, 230, 21);
		getContentPane().add(txtnombres);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 80, 60, 17);
		getContentPane().add(lblApellidos);

		txtapellidos = new JTextField();
		txtapellidos.setColumns(10);
		txtapellidos.setBounds(170, 78, 233, 21);
		getContentPane().add(txtapellidos);

		txtdnice = new JTextField();
		txtdnice.setColumns(10);
		txtdnice.setBounds(170, 107, 233, 21);
		getContentPane().add(txtdnice);

		JLabel lbldnice = new JLabel("DNI_CE");
		lbldnice.setBounds(12, 109, 60, 17);
		getContentPane().add(lbldnice);

		JLabel lblClave = new JLabel("Contraseña");
		lblClave.setBounds(12, 208, 73, 17);
		getContentPane().add(lblClave);

		txtpassword = new JPasswordField();
		txtpassword.setBounds(170, 206, 230, 20);
		getContentPane().add(txtpassword);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(127, 259, 139, 33);
		getContentPane().add(btnGuardar);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(12, 140, 73, 21);
		getContentPane().add(lblCorreo);

		txtcorreo = new JTextField();
		txtcorreo.setColumns(10);
		txtcorreo.setBounds(170, 140, 233, 21);
		getContentPane().add(txtcorreo);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(12, 173, 73, 21);
		getContentPane().add(lblDireccion);

		txtdireccion = new JTextField();
		txtdireccion.setColumns(10);
		txtdireccion.setBounds(170, 173, 233, 21);
		getContentPane().add(txtdireccion);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(12, 12, 73, 17);
		getContentPane().add(lblRol);

		JComboBox<RolUsuario> cbmrol = new JComboBox<RolUsuario>();
		cbmrol.setBounds(170, 7, 148, 26);
		getContentPane().add(cbmrol);

		// método que carga los roles que pueden utilizar los usuarios
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {

				ArrayList<RolUsuario> rolUsuarioArrayList = new RolUsuarioController().listarRolesUsuario();

				cbmrol.addItem(new RolUsuario());

				for (RolUsuario rol_Usuario : rolUsuarioArrayList) {
					cbmrol.addItem(rol_Usuario);
				}
			}
		});

		// método que guarda el usuario creado
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LocalDate fechaActual = LocalDate.now();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
				RolUsuario selectedItem = (RolUsuario) cbmrol.getSelectedItem();

				int rol_id = (int) selectedItem.getRol_id();
				String nombres = txtnombres.getText();
				String apellidos = txtapellidos.getText();
				String dni_ce = txtdnice.getText();
				String correo = txtcorreo.getText();
				String direccion = txtdireccion.getText();
				String password = new String(txtpassword.getPassword());
				String fecha_registro = fechaActual.format(formato);

				try {
					new UsuarioController().agregarUsuario(rol_id, nombres, apellidos, dni_ce, correo, direccion,
							password, fecha_registro);
					JOptionPane.showMessageDialog(null, "Usuario guardado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					cbmrol.setSelectedIndex(0);
					txtnombres.setText("");
					txtapellidos.setText("");
					txtdnice.setText("");
					txtcorreo.setText("");
					txtdireccion.setText("");
					txtpassword.setText("");
				}

			}
		});
	}

}
