package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Usuario;
import repository.UsuarioRepository;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecuperarContrasena extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField txtpassword;
	private JPasswordField txtpasswordval;

	private ArrayList<Usuario> usuarioArrayList;

	/**
	 * Launch the application.
	 * 
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { RecuperarContrasena frame = new
	 * RecuperarContrasena(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public RecuperarContrasena() {

		setTitle("Recuperar Contraseña");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(30, 32, 60, 17);
		getContentPane().add(lblUsuario);

		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		lblNuevaContrasea.setBounds(30, 86, 127, 24);
		getContentPane().add(lblNuevaContrasea);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
		lblConfirmarContrasea.setBounds(30, 136, 156, 31);
		getContentPane().add(lblConfirmarContrasea);

		txtpassword = new JPasswordField();
		txtpassword.setBounds(194, 88, 156, 22);
		getContentPane().add(txtpassword);

		txtpasswordval = new JPasswordField();
		txtpasswordval.setBounds(194, 141, 156, 22);
		getContentPane().add(txtpasswordval);

		JComboBox<Usuario> cbnuser = new JComboBox<Usuario>();
		cbnuser.setBounds(194, 27, 156, 26);
		getContentPane().add(cbnuser);

		JButton btnGuadar = new JButton("Guadar");
		btnGuadar.setBounds(162, 202, 105, 27);
		getContentPane().add(btnGuadar);

		// metodos
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				usuarioArrayList = new UsuarioRepository().listarUsuarios();

				cbnuser.addItem(new Usuario());
				for (Usuario usuario : usuarioArrayList) {
					cbnuser.addItem(usuario);
				}
			}
		});

		btnGuadar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password1 = new String(txtpassword.getPassword());
				String password2 = new String(txtpasswordval.getPassword());

				Usuario usuarioSeleccionado = (Usuario) cbnuser.getSelectedItem();

				if (usuarioSeleccionado != null) {
					// Realizar alguna acción con el usuario seleccionado

					try {

						if (password1.equals(password2)) {
							usuarioSeleccionado.setPassword(password1);
							new UsuarioRepository().actualizarPassword(usuarioSeleccionado);
							JOptionPane.showMessageDialog(null, "password actualizado");

							cbnuser.setSelectedIndex(0);
							txtpassword.setText("");
							txtpasswordval.setText("");

						} else {
							JOptionPane.showMessageDialog(null, "Los password no son iguales");
						}

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
